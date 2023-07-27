package com.eryk.tarefas.controllers;

import com.eryk.tarefas.domain.Tarefa;
import com.eryk.tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin("*")
@Controller
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Integer id){
        Tarefa obj = tarefaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Tarefa>> listOpen(){
        List<Tarefa> list = tarefaService.findAllOpen();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/close")
    public ResponseEntity<List<Tarefa>> listClose(){
        List<Tarefa> list = tarefaService.findAllClose();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> list = tarefaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa obj){
        obj = tarefaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody Tarefa obj){
        Tarefa newObj = tarefaService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }




}
