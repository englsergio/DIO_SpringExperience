package me.dio.academiadigital.service.impl;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;
import me.dio.academiadigital.infra.utils.JavaTimeUtils;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public Optional<Aluno> get(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(!aluno.isPresent())
            throw new IllegalArgumentException("id não existente");
        return aluno;
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(!aluno.isPresent())
            throw new IllegalArgumentException("aluno não encontrado");
        List<AvaliacaoFisica> avaliacoes = aluno.get().getAvaliacoes();
        return avaliacoes;
    }

    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento == null) return alunoRepository.findAll();
        List<Aluno> alunosByDataDeNascimento = alunoRepository.findByDataDeNascimento(
                LocalDate.parse(
                        dataDeNascimento,
                        JavaTimeUtils.LOCAL_DATE_FORMATTER));
        return alunosByDataDeNascimento;
    }

    @Override
    public List<Aluno> retornaAlunosPorBairro(String bairro) {
        List<Aluno> alunosMatriculadosBairro = alunoRepository
                .findAlunosMatriculadosBairro(bairro);
        return alunosMatriculadosBairro;
    }
}
