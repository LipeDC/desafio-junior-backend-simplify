package com.example.desafio_simplify.models;

import com.example.desafio_simplify.enums.Prioridade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "realizado", nullable = false)
    private boolean realizado;

    @Enumerated(EnumType.STRING)

    @Column(name = "prioridade", nullable = false)
    private Prioridade prioridade;
}
