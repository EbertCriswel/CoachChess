package com.projeto.CoachChess.database.model;

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
@Table(name = "CC_JOGADOR",
uniqueConstraints = {
@UniqueConstraint(
        name = "uk_jogador_email",
        columnNames = "email"
),
@UniqueConstraint(
        name = "uk_jogador_apelido",
        columnNames = "apelido"
)
    }
            )
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String apelido;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(nullable = false)
    private Integer rating = 1200;

    @Column(nullable = false)
    private Integer numeroDePartidas = 0;

    @Column(nullable = false)
    private Boolean estado = true;
}