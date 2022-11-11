package br.com.alura.barbeariaonline.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.barbeariaonline.model.User;

@Repository
public interface UsuarioRepo extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}