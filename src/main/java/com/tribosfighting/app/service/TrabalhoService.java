package com.tribosfighting.app.service;

import com.tribosfighting.app.entity.Trabalho;
import com.tribosfighting.app.repository.AlunoRepository;
import com.tribosfighting.app.repository.TrabalhoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrabalhoService {
    private final TrabalhoRepository trabalhoRepo;
    private final AlunoRepository alunoRepo;

    public TrabalhoService(TrabalhoRepository trabalhoRepo, AlunoRepository alunoRepo) {
        this.trabalhoRepo = trabalhoRepo;
        this.alunoRepo = alunoRepo;
    }

    public List<Trabalho> listarTodos() {
        return trabalhoRepo.findAll();
    }

    public List<Trabalho> buscarPorRaETitulo(Long ra, String titulo) {
        return trabalhoRepo.buscarPorRaETitulo(ra, titulo);
    }


    public Trabalho cadastrar(Trabalho trabalho) {
        if (trabalho.getTitulo() == null || trabalho.getTitulo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titulo obrigatorio poxa");
        }
        if (trabalho.getAluno() == null
                || trabalho.getAluno().getId() == null
                || !alunoRepo.existsById(trabalho.getAluno().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "filho, trabalho nao foi encontrada");
        }
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        return trabalhoRepo.save(trabalho);


    }


}
