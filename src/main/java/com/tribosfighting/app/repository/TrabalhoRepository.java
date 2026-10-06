package com.tribosfighting.app.repository;

import com.tribosfighting.app.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    List<Trabalho> findByAlunoRaAndTituloContainingIgnoreCase(Long ra, String titulo);


    @Query("SELECT t FROM Trabalho t WHERE t.aluno.ra = :ra AND LOWER(t.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Trabalho> buscarPorRaETitulo(Long ra, String titulo);
}
