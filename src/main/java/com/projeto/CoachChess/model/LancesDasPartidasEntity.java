package com.projeto.CoachChess.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CC_LANCES_TODAS_AS_PARTIDAS")
public class LancesDasPartidasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "partida_ID", nullable = false)
    private PartidasEntity partida;

    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
    private JogadorEntity jogadorDoLance;

    @Column(nullable = false)
    private int numeroDoLance;

    @Column(nullable = false)
    private String movimento;

    @Column(nullable = false)
    private String codigoFen;

    @Column(nullable = false)
    private String qualidade;



}
