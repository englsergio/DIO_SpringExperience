package me.dio.academiadigital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {
    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "O id do aluno precisa ser positivo.")
    private Long alunoId;
    @NotNull(message = "Preencha o campo corretamente.")
    private LocalDateTime dataDeMatricula;
}
