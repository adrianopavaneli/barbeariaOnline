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
@Table(name="usuarios")
public class Usuario {	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;

	    public Usuario(Long id,String username, String password) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	    }

	    public Usuario(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
	    
	    public Usuario() {
	        
	    }

		

	    
	    

}
