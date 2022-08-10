package me.dio.academiadigital.repository;

import me.dio.academiadigital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoFisicaRespository
        extends JpaRepository<AvaliacaoFisica, Long> {
}
