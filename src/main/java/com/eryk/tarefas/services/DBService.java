package com.eryk.tarefas.services;

import com.eryk.tarefas.domain.Tarefa;
import com.eryk.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


@Service
public class DBService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void instanceDatabase() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Tarefa t1 = new Tarefa(null, "Estudar", "Estudar Spring Boot e Angular",
                sdf.parse("20/07/2003" ), false);
        Tarefa t2 = new Tarefa(null, "Academia", "Treinar superiores",
                sdf.parse("20/07/2003"), false);
        Tarefa t3 = new Tarefa(null, "Tomar café", "Preparar o café",
                sdf.parse("20/07/2003"), true);
        Tarefa t4 = new Tarefa(null, "Ler", "Ler algum livro",
                sdf.parse("20/07/2003"), false);

        tarefaRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }

}
