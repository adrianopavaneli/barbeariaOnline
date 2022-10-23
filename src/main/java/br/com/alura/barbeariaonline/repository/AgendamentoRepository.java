package br.com.alura.barbeariaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.Agendamento;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}