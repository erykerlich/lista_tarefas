package com.eryk.tarefas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFinish;
    private Boolean finalizar = false;

    public Tarefa() {
    }

    public Tarefa(Integer id, String title, String description, Date dataFinish, Boolean finalizar) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dataFinish = dataFinish;
        this.finalizar = finalizar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDataFinish() {
        return dataFinish;
    }

    public void setDataFinish(Date dataFinish) {
        this.dataFinish = dataFinish;
    }

    public Boolean getFinalizar() {
        return finalizar;
    }

    public void setFinalizar(Boolean finalizar) {
        this.finalizar = finalizar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
