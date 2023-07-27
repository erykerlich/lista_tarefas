package com.eryk.tarefas.services;

import com.eryk.tarefas.domain.Tarefa;
import com.eryk.tarefas.repositories.TarefaRepository;
import com.eryk.tarefas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa findById(Integer id) {
        Optional<Tarefa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                id + ", Tipo: " + Tarefa.class.getName()));
    }

    public List<Tarefa> findAllOpen() {
        List<Tarefa> list = repository.findAllOpen();
        return list;
    }

    public List<Tarefa> findAllClose() {
        List<Tarefa> list = repository.findAllClose();
        return list;
    }

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Tarefa create(Tarefa obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public Tarefa update(Integer id, Tarefa obj) {
        Tarefa newObj = findById(id);
        newObj.setTitle(obj.getTitle());
        newObj.setDescription(obj.getDescription());
        newObj.setDataFinish(obj.getDataFinish());
        newObj.setFinalizar(obj.getFinalizar());
        return repository.save(obj);
    }
}
