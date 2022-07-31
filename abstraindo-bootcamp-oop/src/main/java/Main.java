import dominio.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Conteudo curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        ((Curso) curso1).setCargaHoraria(8);

        Conteudo curso2 = new Curso();
        curso2.setTitulo("Curso Javascript");
        curso2.setDescricao("Descrição curso Javascript");
        ((Curso) curso2).setCargaHoraria(4);

//        System.out.println(curso1);
//        System.out.println(curso2);

        Conteudo mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria de Java");
        ((Mentoria) mentoria).setData(LocalDate.now());

//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp");
        bootcamp.setDescricao("Descrição do Bootcamp");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        System.out.println("Conteúdos inscritos" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluídos" + devCamila.getConteudosConcluidos());
        devCamila.progredir();
        System.out.println("Conteúdos inscritos" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluídos" + devCamila.getConteudosConcluidos());
        devCamila.progredir();
        System.out.println("Conteúdos inscritos" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos concluídos" + devCamila.getConteudosConcluidos());
        devCamila.progredir();

//        Dev devJoao = new Dev();
//        devJoao.setNome("João");
//        devJoao.inscreverBootcamp(bootcamp);
//        System.out.println(devJoao.getConteudosInscritos());
//        devJoao.progredir();
//        System.out.println(devJoao.getConteudosConcluidos());
    }
}
