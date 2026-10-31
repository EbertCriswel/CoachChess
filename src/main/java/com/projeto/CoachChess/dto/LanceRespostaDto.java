package com.projeto.CoachChess.dto;

public record LanceRespostaDto(
        Long id,
        Long partidaId,
        Long jogadorId,
        Integer numeroDoLance,
        String movimento,
        String codigoFen,
        String qualidade
) {}