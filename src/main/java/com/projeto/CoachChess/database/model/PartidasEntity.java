package com.projeto.CoachChess.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "CC_PARTIDAS_JOGADAS")
public class PartidasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column
    private LocalDateTime dataFim;

    @Column
    private Long duracaoSegundos;

    @Column(length = 20)
    private String resultadoPartida;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "jogador_pretas_id",
            nullable = false
    )
    private JogadorEntity jogadorPretas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "jogador_brancas_id",
            nullable = false
    )
    private JogadorEntity jogadorBrancas;

    @Column(columnDefinition = "TEXT")
    private String pgnCompleto;

    @PrePersist
    public void aoCriar() {
        if (dataInicio == null) {
            dataInicio = LocalDateTime.now();
        }
    }
}
