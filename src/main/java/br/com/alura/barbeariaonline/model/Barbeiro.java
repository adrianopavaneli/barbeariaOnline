package br.com.alura.barbeariaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="barbeiros")
public class Barbeiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;

    public Barbeiro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Barbeiro() {
        
    }   
   

    @Override
    public String toString() {
        return nome;
    }

}
