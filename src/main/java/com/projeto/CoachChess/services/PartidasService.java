package com.projeto.CoachChess.services;

import com.projeto.CoachChess.database.model.JogadorEntity;
import com.projeto.CoachChess.database.model.PartidasEntity;
import com.projeto.CoachChess.database.repository.IJogadorRepository;
import com.projeto.CoachChess.database.repository.IPartidasRespository;
import com.projeto.CoachChess.dto.PartidaCadastroDto;
import com.projeto.CoachChess.dto.PartidaRespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidasService {

    private final IPartidasRespository partidasRepository;
    private final IJogadorRepository jogadorRepository;

    public PartidasService(IPartidasRespository partidasRepository, IJogadorRepository jogadorRepository) {
        this.partidasRepository = partidasRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public PartidaRespostaDto criarPartida(PartidaCadastroDto dto) {
        JogadorEntity brancas = jogadorRepository.findById(dto.idJogadorBrancas())
                .orElseThrow(() -> new RuntimeException("Jogador de brancas não encontrado com ID: " + dto.idJogadorBrancas()));

        JogadorEntity pretas = jogadorRepository.findById(dto.idJogadorPretas())
                .orElseThrow(() -> new RuntimeException("Jogador de pretas não encontrado com ID: " + dto.idJogadorPretas()));


        PartidasEntity partida = new PartidasEntity();
        partida.setJogadorBrancas(brancas);
        partida.setJogadorPretas(pretas);

        PartidasEntity partidaSalva = partidasRepository.save(partida);

        return new PartidaRespostaDto(
                partidaSalva.getId(),
                partidaSalva.getDataInicio(),
                partidaSalva.getDataFim(),
                partidaSalva.getDuracaoSegundos(),
                partidaSalva.getResultadoPartida(),
                partidaSalva.getJogadorBrancas().getId(),
                partidaSalva.getJogadorPretas().getId(),
                partidaSalva.getPgnCompleto()
        );
    }


    public PartidaRespostaDto buscarPorId(Long id) {
        PartidasEntity partida = partidasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada com o ID: " + id));

        return new PartidaRespostaDto(
                partida.getId(),
                partida.getDataInicio(),
                partida.getDataFim(),
                partida.getDuracaoSegundos(),
                partida.getResultadoPartida(),
                partida.getJogadorBrancas().getId(),
                partida.getJogadorPretas().getId(),
                partida.getPgnCompleto()
        );
    }


    public List<PartidaRespostaDto> listarTodas() {
        return partidasRepository.findAll()
                .stream()
                .map(partida -> new PartidaRespostaDto(
                        partida.getId(),
                        partida.getDataInicio(),
                        partida.getDataFim(),
                        partida.getDuracaoSegundos(),
                        partida.getResultadoPartida(),
                        partida.getJogadorBrancas().getId(),
                        partida.getJogadorPretas().getId(),
                        partida.getPgnCompleto()
                ))
                .toList();
    }


}