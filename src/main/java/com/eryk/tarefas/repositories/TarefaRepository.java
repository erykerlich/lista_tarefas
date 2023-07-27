package com.eryk.tarefas.repositories;

import com.eryk.tarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("SELECT obj FROM Tarefa obj WHERE obj.finalizar = false ORDER BY obj.dataFinish")
    List<Tarefa> findAllOpen();

    @Query("SELECT obj FROM Tarefa obj WHERE obj.finalizar = true ORDER BY obj.dataFinish")
    List<Tarefa> findAllClose();

}
