package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.User;

public class RequisicaoNovoUser {
	
	
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


    public User toUser() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}
	
	
	
}
