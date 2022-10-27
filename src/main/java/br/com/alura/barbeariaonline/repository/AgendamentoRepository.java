package br.com.alura.barbeariaonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.Agendamento;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    @Query(value = "select p.id as pid, ativo, data, observacao, p.valor as pvalor, barbeiro_id, cliente_id, servico_id, c.id as cid, cep, cidade, data_nascimento, email, endereco, c.nome as cnome, rg, sexo, telefone, s.id as sid, descricao, s.valor as svalor, b.id as bid, b.nome as bnome  from agendamentos p inner join clientes c ON c.id = p.cliente_id inner join servicos s on s.id = p.servico_id inner join barbeiros b ON b.id = p.barbeiro_id WHERE ativo = TRUE", nativeQuery = true)
    List<Agendamento> findAllTodosAgendamentos();
}