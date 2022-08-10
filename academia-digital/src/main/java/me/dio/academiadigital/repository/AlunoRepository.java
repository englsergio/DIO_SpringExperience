package me.dio.academiadigital.repository;

import me.dio.academiadigital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

    @Query(value = "SELECT * FROM tb_matriculas m" +
            "INNER JOIN tb_alunos a ON m.aluno_id = a.id" +
            "WHERE a.bairro = :bairro", nativeQuery = true)
    List<Aluno> findAlunosMatriculadosBairro(String bairro);
}
