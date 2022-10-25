package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Usuario;

public class RequisicaoNovoUsuario {
	
	
	@NotBlank 
	private String username;
	@NotBlank
	private String password;
	
	


	public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }




    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }




    public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setPassword(password);
		return usuario;
	}
	
	
	
}
