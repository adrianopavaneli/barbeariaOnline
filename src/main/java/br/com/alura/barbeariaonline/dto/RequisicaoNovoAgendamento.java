package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Servico;

public class RequisicaoNovoAgendamento {
	
	
	@NotBlank 
	private String descricao;
	@NotBlank
	private String valor;
	
	

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }







    public Servico toAgendamento() {
		Servico servico = new Servico();
		servico.setDescricao(descricao);
		Double valorcerto = Double.parseDouble(valor);
		servico.setValor(valorcerto);
		return servico;
	}


  
	
	
}
