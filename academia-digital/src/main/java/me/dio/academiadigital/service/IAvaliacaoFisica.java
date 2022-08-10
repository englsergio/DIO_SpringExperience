package me.dio.academiadigital.service;

import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;

import java.util.List;

public interface IAvaliacaoFisica {
    AvaliacaoFisica create(AvaliacaoFisicaForm form);
    AvaliacaoFisica get(Long id);
    List<AvaliacaoFisica> getAll();
    AvaliacaoFisica update(Long id, AvaliacaoFisicaForm form);
    void delete(Long id);
}
