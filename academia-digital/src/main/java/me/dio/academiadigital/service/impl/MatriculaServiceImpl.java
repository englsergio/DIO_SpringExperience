package me.dio.academiadigital.service.impl;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.MatriculaRepository;
import me.dio.academiadigital.service.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    private final AlunoRepository alunoRepository;
    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(
            AlunoRepository alunoRepository,
            MatriculaRepository matriculaRepository) {
        this.alunoRepository = alunoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Optional<Aluno> aluno = alunoRepository.
                findById(form.getAlunoId());
        if(!aluno.isPresent()) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }
        matricula.setAluno(aluno.get());
        matricula.setDataDaMatricula(form.getDataDeMatricula());
        matriculaRepository.save(matricula);
        return matricula;
    }

    @Override
    public Matricula get(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        if(!matricula.isPresent()) {
            throw new IllegalArgumentException("Matrícula não encontrada");
        }
        return matricula.get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if(bairro == null) return matriculaRepository.findAll();
        return matriculaRepository.findByAlunoBairro(bairro);
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public List<Matricula> getAllMatriculasPorBairro(String bairro) {
        List<Matricula> list = matriculaRepository
                .getAllMatriculasPorBairro(bairro);
        return list;
    }
}
