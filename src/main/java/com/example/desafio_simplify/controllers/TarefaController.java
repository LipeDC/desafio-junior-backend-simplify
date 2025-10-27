package com.example.desafio_simplify.controllers;

import com.example.desafio_simplify.models.Tarefa;
import com.example.desafio_simplify.services.TarefaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa){
        try{
        tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@RequestBody Tarefa tarefa, @PathVariable Long id){
        try{
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(tarefa,id);
        return ResponseEntity.ok().body(tarefaAtualizada);

    }
        catch (EntityNotFoundException e){
        return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        try {
            List<Tarefa> tarefas = tarefaService.listarTarefas();
            return ResponseEntity.ok().body(tarefas);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> tarefaPorId(@PathVariable Long id){
        try{
       Tarefa tarefa = tarefaService.tarefaPorId(id);
        return ResponseEntity.ok().body(tarefa);
    } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
        try {
            tarefaService.deletarTarefa(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
