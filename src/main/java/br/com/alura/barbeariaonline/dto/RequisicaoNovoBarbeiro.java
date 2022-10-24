package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Barbeiro;

public class RequisicaoNovoBarbeiro {
	
	
	@NotBlank 
	private String nomeBarbeiro;

	public String getNomeBarbeiro() {
		return nomeBarbeiro;
	}

	public void setNomeBarbeiro(String nomeBarbeiro) {
		this.nomeBarbeiro = nomeBarbeiro;
	}

	public Barbeiro toBarbeiro() {
		Barbeiro barbeiro = new Barbeiro();
		barbeiro.setNome(nomeBarbeiro);
		return barbeiro;
	}
	
	
	
}
