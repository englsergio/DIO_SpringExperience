import dominio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DevTest {
    static Conteudo curso1 = new Curso();
    static Conteudo curso2 = new Curso();
    static Conteudo mentoria = new Mentoria();
    static Bootcamp bootcamp = new Bootcamp();
    static Dev dev = new Dev();

    @BeforeAll
    static void setUp() {
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        ((Curso) curso1).setCargaHoraria(8);

        curso2.setTitulo("Curso Javascript");
        curso2.setDescricao("Descrição curso Javascript");
        ((Curso) curso2).setCargaHoraria(4);

        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria de Java");
        ((Mentoria) mentoria).setData(LocalDate.now());

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

    }

    @Test
    void whenSubscribingToBootcampConteudoIncrements() {
        DevTest.setUp();

        dev.inscreverBootcamp(bootcamp);

        Assertions.assertNotNull(dev.getConteudosInscritos());
    }
}
