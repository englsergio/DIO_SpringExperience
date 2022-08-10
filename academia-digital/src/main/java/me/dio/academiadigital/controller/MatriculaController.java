package me.dio.academiadigital.controller;

import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;
import me.dio.academiadigital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return matriculaService.create(form);
    }
    //Duas maneiras de extrair um 'parâmetro': @PathVariable e @RequestParam.
    //https://www.baeldung.com/spring-requestparam-vs-pathvariable
    @GetMapping("/{bairro}")
    public List<Matricula> getAllByBairro(@PathVariable String bairro) {
        return matriculaService.getAllMatriculasPorBairro(bairro);
    }
    @GetMapping("/por")
    public List<Matricula> getAllByBairroParam(@RequestParam String bairro) {
        return matriculaService.getAllMatriculasPorBairro(bairro);
    }
    @GetMapping
    public List<Matricula> getAll(@RequestBody(required = false) String bairro) {
        return matriculaService.getAll(bairro);
    }
}
