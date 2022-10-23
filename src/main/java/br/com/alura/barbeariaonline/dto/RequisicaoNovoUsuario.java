package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoUsuario {
	@NotBlank
	private String nomeUsuario;
	@NotBlank
	private String senhaUsuario;
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	
	
	

}
