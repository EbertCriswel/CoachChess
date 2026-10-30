package com.projeto.CoachChess.services;

import com.projeto.CoachChess.database.model.JogadorEntity;
import com.projeto.CoachChess.database.repository.IJogadorRepository;
import com.projeto.CoachChess.dto.JogadorCadastroDto;
import com.projeto.CoachChess.dto.JogadorEditarDto;
import com.projeto.CoachChess.dto.JogadorPublicoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class JogadorService {

    private final IJogadorRepository jogadorRepository;

    public List<JogadorPublicoDto> getAllJogadores() {

        List<JogadorEntity> jogadores = jogadorRepository.findAll();

        return jogadores.stream().map(JogadorEntity -> new JogadorPublicoDto(
                JogadorEntity.getApelido(),
                JogadorEntity.getNome(),
                JogadorEntity.getEmail(),
                JogadorEntity.getRating(),
                JogadorEntity.getNumeroDePartidas(),
                JogadorEntity.getEstado()
        )).toList();
    }

    public JogadorCadastroDto criarJogador(JogadorCadastroDto jogador) {
        JogadorEntity jogadorEntity = new JogadorEntity();
        jogadorEntity.setApelido(jogador.apelido());
        jogadorEntity.setNome(jogador.nome());
        jogadorEntity.setEmail(jogador.email());
        jogadorEntity.setSenha(jogador.senha());
        jogadorEntity.setRating(1200);
        jogadorEntity.setNumeroDePartidas(0);

        JogadorEntity savedJogador = jogadorRepository.save(jogadorEntity);
        return new JogadorCadastroDto(
                savedJogador.getApelido(),
                savedJogador.getNome(),
                savedJogador.getEmail(),
                savedJogador.getSenha()
        );
    }

    public JogadorEditarDto editarInfoJogador(JogadorEditarDto jogador, Long id) {
        JogadorEntity jogadorEntity = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

       if(jogador.apelido() != null) {
            jogadorEntity.setApelido(jogador.apelido());
       }else{
           jogadorEntity.setApelido(jogadorEntity.getApelido());
       }
       if(jogador.nome() != null) {
            jogadorEntity.setNome(jogador.nome());
       }else{
           jogadorEntity.setNome(jogadorEntity.getNome());
       }
       if(jogador.email() != null) {
            jogadorEntity.setEmail(jogador.email());
       }else{
           jogadorEntity.setEmail(jogadorEntity.getEmail());
       }
       if(jogador.senha() != null) {
            jogadorEntity.setSenha(jogador.senha());
       }else{
           jogadorEntity.setSenha(jogadorEntity.getSenha());
       }

        JogadorEntity updatedJogador = jogadorRepository.save(jogadorEntity);
        return new JogadorEditarDto(
                updatedJogador.getApelido(),
                updatedJogador.getNome(),
                updatedJogador.getEmail(),
                updatedJogador.getSenha()
        );
    }

    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }



}
