package com.projeto.CoachChess.controller;

import com.projeto.CoachChess.dto.PartidaCadastroDto;
import com.projeto.CoachChess.dto.PartidaRespostaDto;
import com.projeto.CoachChess.services.PartidasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidasController {

    private final PartidasService partidasService;

    public PartidasController(PartidasService partidasService) {
        this.partidasService = partidasService;
    }

    @PostMapping
    public ResponseEntity<PartidaRespostaDto> criarPartida(@RequestBody PartidaCadastroDto dto) {
        PartidaRespostaDto resposta = partidasService.criarPartida(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaRespostaDto> buscarPorId(@PathVariable Long id) {
        PartidaRespostaDto resposta = partidasService.buscarPorId(id);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping
    public ResponseEntity<List<PartidaRespostaDto>> listarTodas() {
        List<PartidaRespostaDto> partidas = partidasService.listarTodas();
        return ResponseEntity.ok(partidas);
    }
}
