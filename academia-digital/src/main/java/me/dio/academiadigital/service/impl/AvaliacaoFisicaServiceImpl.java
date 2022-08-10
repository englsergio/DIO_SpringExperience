package me.dio.academiadigital.service.impl;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.AvaliacaoFisicaRespository;
import me.dio.academiadigital.service.IAvaliacaoFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisica {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    AvaliacaoFisicaRespository avaliacaoFisicaRespository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
        if(!aluno.isPresent()) {
            throw new IllegalArgumentException("aluno não encontrado");
        }
        avaliacaoFisica.setAluno(aluno.get());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisicaRespository.save(avaliacaoFisica);
        return avaliacaoFisica;
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        Optional<AvaliacaoFisica> avaliacaoById =
                avaliacaoFisicaRespository.findById(id);
        return avaliacaoById.get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        List<AvaliacaoFisica> list = avaliacaoFisicaRespository.findAll();
        return list;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaForm form) {
        Optional<AvaliacaoFisica> opAvaliacaoFisica = avaliacaoFisicaRespository.
                findById(id);
        if(!opAvaliacaoFisica.isPresent()) {
            throw new IllegalArgumentException("avaliação não encontrada");
        }
        AvaliacaoFisica avaliacaoFisica = opAvaliacaoFisica.get();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisicaRespository.save(avaliacaoFisica);
        return avaliacaoFisica;
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRespository.deleteById(id);
    }
}
