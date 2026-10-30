package com.projeto.CoachChess.controller;

import com.projeto.CoachChess.database.model.JogadorEntity;
import com.projeto.CoachChess.dto.JogadorCadastroDto;
import com.projeto.CoachChess.dto.JogadorEditarDto;
import com.projeto.CoachChess.dto.JogadorPublicoDto;
import com.projeto.CoachChess.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController {

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<JogadorPublicoDto> pegarTodosJogadores() {
        return jogadorService.getAllJogadores();
    }

    private final JogadorService jogadorService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorCadastroDto criarJogador(@RequestBody JogadorCadastroDto jogador) {
        return jogadorService.criarJogador(jogador);
    }

    @PatchMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JogadorEditarDto editarJogador(@RequestBody JogadorEditarDto jogador, @PathVariable Long id) {
        return jogadorService.editarInfoJogador(jogador, id);

    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarJogador(@PathVariable Long id) {
        jogadorService.deletarJogador(id);

    }
}
