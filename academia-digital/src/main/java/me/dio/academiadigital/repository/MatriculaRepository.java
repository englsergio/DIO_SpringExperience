package me.dio.academiadigital.repository;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "SELECT * FROM tb_matriculas m INNER JOIN tb_alunos a " +
            "ON m.aluno_id = a.id WHERE a.bairro = :bairro", nativeQuery = true)
    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro") //faz o mesmo que o método acima
    List<Matricula> getAllMatriculasPorBairro(String bairro);

    List<Matricula> findByAlunoBairro(String bairro);
}
