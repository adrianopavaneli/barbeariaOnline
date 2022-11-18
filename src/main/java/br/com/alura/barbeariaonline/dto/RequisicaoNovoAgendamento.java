package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Barbeiro;

public class RequisicaoNovoAgendamento {
	
	
	@NotBlank 
	private String nomeCliente;
	private String nomeBarbeiro;
	private String nomeServico;
	private String DataeHora;
	private String Valor;
	private String Observacao;

	
A() {
		Barbeiro barbeiro = new Barbeiro();
		barbeiro.setNome(nomeBarbeiro);
		return barbeiro;
	}
	
	
	
}
