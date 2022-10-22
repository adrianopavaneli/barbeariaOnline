package br.com.alura.barbeariaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String usuario;
	    private String senha;

	    public Usuario(Long id,String usuario, String senha) {
	        this.id = id;
	        this.usuario = usuario;
	        this.senha = senha;
	    }

	    public Usuario(String usuario, String senha) {
	        this.usuario = usuario;
	        this.senha = senha;
	    }

	   
	    

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
	    
	    
	    

}
