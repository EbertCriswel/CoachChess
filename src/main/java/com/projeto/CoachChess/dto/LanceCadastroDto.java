package com.projeto.CoachChess.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record LanceCadastroDto(
        @NotNull(message = "O ID da partida é obrigatório")
        Long partidaId,

        @NotNull(message = "O ID do jogador é obrigatório")
        Long jogadorId,

        @NotNull(message = "O número do lance é obrigatório")
        @Positive(message = "O número do lance deve ser positivo")
        Integer numeroDoLance,

        @NotBlank(message = "O movimento não pode estar em branco")
        @Size(max = 20)
        String movimento,

        @NotBlank(message = "O código FEN é obrigatório")
        @Size(max = 120)
        String codigoFen,

        @Size(max = 30)
        String qualidade
) {}