package br.com.alura.barbeariaonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findByNome(Cliente cliente);
    
    @Query(value = "select * from clientes", nativeQuery = true)
    public List<Cliente> listarclientes();
        
   

}
