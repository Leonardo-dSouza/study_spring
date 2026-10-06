package com.tribosfighting.app.repository;

import com.tribosfighting.app.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
