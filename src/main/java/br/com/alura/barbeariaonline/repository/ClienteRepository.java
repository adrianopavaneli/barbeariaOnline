package br.com.alura.barbeariaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findByNome(Cliente cliente);
  

}
