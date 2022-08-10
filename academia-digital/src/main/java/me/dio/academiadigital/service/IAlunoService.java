package me.dio.academiadigital.service;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    Aluno create(AlunoForm form);
    Optional<Aluno> get(Long id);
    List<Aluno> getAll();

    Aluno update(Long id, AlunoForm form);

    void delete(Long id);
    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
    List<Aluno> getAll(String dataDeNascimento);
    List<Aluno> retornaAlunosPorBairro(String bairro);

}
