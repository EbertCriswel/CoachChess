package com.projeto.CoachChess.dto;

import java.time.LocalDateTime;

public record PartidaRespostaDto(
        Long id,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        Long duracaoSegundos,
        String resultadoPartida,
        Long idJogadorBrancas,
        Long idJogadorPretas,
        String pgnCompleto
) {}