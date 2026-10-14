package com.projeto.CoachChess.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "CC_JOGADOR")
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //funciona como incremento
    private long id;

    @Column(nullable = false)
    private String apelido;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private long rating;

    @Column(nullable = false)
    private int numeroDePartidas;

    @Column(nullable = false)
    private boolean estado;

}
