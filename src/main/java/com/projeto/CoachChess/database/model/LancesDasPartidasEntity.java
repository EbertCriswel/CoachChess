package com.projeto.CoachChess.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "CC_LANCES_TODAS_AS_PARTIDAS",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_partida_numero_lance",
                        columnNames = {
                                "partida_id",
                                "numero_do_lance"
                        }
                )
        }
)
public class LancesDasPartidasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "partida_id",
            nullable = false
    )
    private PartidasEntity partida;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "jogador_id",
            nullable = false
    )
    private JogadorEntity jogadorDoLance;

    /**
     * Indice sequencial de meia-jogada na partida: 1 = e4, 2 = e5, 3 = Cf3.
     * Cada movimento recebe seu proprio numero, inclusive o das pretas.
     */
    @NotNull
    @Positive
    @Column(
            name = "numero_do_lance",
            nullable = false
    )
    private Integer numeroDoLance;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String movimento;

    /** Posicao do tabuleiro em FEN depois da execucao deste movimento. */
    @NotBlank
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String codigoFen;

    @Size(max = 30)
    @Column(length = 30)
    private String qualidade;
}
