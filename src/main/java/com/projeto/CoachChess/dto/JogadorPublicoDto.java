package com.projeto.CoachChess.dto;

public record JogadorPublicoDto(
        String apelido,
        String nome,
        String email,
        Integer rating,
        Integer numeroDePartidas,
        Boolean estado
    ) {

}
