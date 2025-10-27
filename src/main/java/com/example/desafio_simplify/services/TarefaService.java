package com.example.desafio_simplify.services;

import com.example.desafio_simplify.models.Tarefa;
import com.example.desafio_simplify.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa tarefaPorId(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public Tarefa atualizarTarefa (Tarefa tarefaAtualizada, Long id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException
                                ("Tarefa não encontrada"));
        tarefa.setName(tarefaAtualizada.getName());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setRealizado(tarefaAtualizada.isRealizado());
        tarefa.setPrioridade(tarefaAtualizada.getPrioridade());

        return tarefaRepository.save(tarefa);
    }

}
