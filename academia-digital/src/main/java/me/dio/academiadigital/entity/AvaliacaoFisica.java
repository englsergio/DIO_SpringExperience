package me.dio.academiadigital.entity;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
    @Column(name = "peso_atual")
    private double peso;
    @Column(name = "altura_atual")
    private double altura;
}
