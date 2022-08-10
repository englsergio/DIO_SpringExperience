package me.dio.academiadigital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;
    @NotEmpty(message = "Preencha o campo corretamente.")
    @Positive(message = "O peso do aluno precisa ser positivo.")
    private Double peso;
    @NotEmpty(message = "Preencha o campo corretamente.")
    @Positive(message = "A altura do aluno precisa ser positiva.")
    @DecimalMin(value = "150", message = "'${validatedValue}'," +
            "precisa ser no mínimo {value}.")
    private Double altura;
}
