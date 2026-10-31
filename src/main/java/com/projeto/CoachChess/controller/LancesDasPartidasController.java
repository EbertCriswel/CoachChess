package com.projeto.CoachChess.controller;

import com.projeto.CoachChess.dto.LanceCadastroDto;
import com.projeto.CoachChess.dto.LanceRespostaDto;
import com.projeto.CoachChess.services.LancesDasPartidasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lances")
public class LancesDasPartidasController {

    private final LancesDasPartidasService lancesService;

    public LancesDasPartidasController(LancesDasPartidasService lancesService) {
        this.lancesService = lancesService;
    }

    @PostMapping
    public ResponseEntity<LanceRespostaDto> registrarLance(@RequestBody @Valid LanceCadastroDto dto) {
        LanceRespostaDto resposta = lancesService.registrarLance(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/partida/{partidaId}")
    public ResponseEntity<List<LanceRespostaDto>> listarLancesPorPartida(@PathVariable Long partidaId) {
        List<LanceRespostaDto> lances = lancesService.listarLancesPorPartida(partidaId);
        return ResponseEntity.ok(lances);
    }
}