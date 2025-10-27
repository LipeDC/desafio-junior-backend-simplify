package com.example.desafio_simplify.repositories;

import com.example.desafio_simplify.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
