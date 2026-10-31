package com.projeto.CoachChess.services;

import com.projeto.CoachChess.database.model.JogadorEntity;
import com.projeto.CoachChess.database.model.LancesDasPartidasEntity;
import com.projeto.CoachChess.database.model.PartidasEntity;
import com.projeto.CoachChess.database.repository.IJogadorRepository;
import com.projeto.CoachChess.database.repository.ILancesDasPartidasRepository;
import com.projeto.CoachChess.database.repository.IPartidasRespository;
import com.projeto.CoachChess.dto.LanceCadastroDto;
import com.projeto.CoachChess.dto.LanceRespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancesDasPartidasService {

    private final ILancesDasPartidasRepository lancesRepository;
    private final IPartidasRespository partidasRepository;
    private final IJogadorRepository jogadorRepository;

    public LancesDasPartidasService(
            ILancesDasPartidasRepository lancesRepository,
            IPartidasRespository partidasRepository,
            IJogadorRepository jogadorRepository
    ) {
        this.lancesRepository = lancesRepository;
        this.partidasRepository = partidasRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public LanceRespostaDto registrarLance(LanceCadastroDto dto) {
        PartidasEntity partida = partidasRepository.findById(dto.partidaId())
                .orElseThrow(() -> new RuntimeException("Partida não encontrada com ID: " + dto.partidaId()));

        JogadorEntity jogador = jogadorRepository.findById(dto.jogadorId())
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com ID: " + dto.jogadorId()));

        LancesDasPartidasEntity lance = new LancesDasPartidasEntity();
        lance.setPartida(partida);
        lance.setJogadorDoLance(jogador);
        lance.setNumeroDoLance(dto.numeroDoLance());
        lance.setMovimento(dto.movimento());
        lance.setCodigoFen(dto.codigoFen());
        lance.setQualidade(dto.qualidade());

        LancesDasPartidasEntity lanceSalvo = lancesRepository.save(lance);

        return new LanceRespostaDto(
                lanceSalvo.getId(),
                lanceSalvo.getPartida().getId(),
                lanceSalvo.getJogadorDoLance().getId(),
                lanceSalvo.getNumeroDoLance(),
                lanceSalvo.getMovimento(),
                lanceSalvo.getCodigoFen(),
                lanceSalvo.getQualidade()
        );
    }

    public List<LanceRespostaDto> listarLancesPorPartida(Long partidaId) {
        return lancesRepository.findByPartidaIdOrderByNumeroDoLanceAsc(partidaId)
                .stream()
                .map(lance -> new LanceRespostaDto(
                        lance.getId(),
                        lance.getPartida().getId(),
                        lance.getJogadorDoLance().getId(),
                        lance.getNumeroDoLance(),
                        lance.getMovimento(),
                        lance.getCodigoFen(),
                        lance.getQualidade()
                ))
                .toList();
    }
}