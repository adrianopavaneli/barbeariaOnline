package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Barbeiro;
import lombok.Getter;
import lombok.Setter;

public class RequisicaoNovoAgendamento {
	
	@Getter
	@Setter
	@NotBlank 
	private String nomeCliente;
	private String nomeBarbeiro;
	private String nomeServico;
	private String DataeHora;
	private String Valor;
	private String Observacao;

	

	public Agendamento toAgendamento() {
	    agendamento.setNome(nomeBarbeiro);
		return barbeiro;
	}
	
	
	
}
