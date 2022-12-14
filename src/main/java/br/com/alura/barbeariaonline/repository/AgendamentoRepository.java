package br.com.alura.barbeariaonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.Agendamento;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    @Query(value = "select * from agendamentos p inner join clientes c ON c.id = p.cliente_id inner join servicos s on s.id = p.servico_id  inner join barbeiros b ON b.id = p.barbeiro_id WHERE ativo = TRUE order by data", nativeQuery = true)
    List<Agendamento> findAllTodosAgendamentos();
}