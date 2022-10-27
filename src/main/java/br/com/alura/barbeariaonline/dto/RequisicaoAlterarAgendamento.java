package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Servico;

public class RequisicaoAlterarAgendamento {
    
    @NotBlank
    private String idAgendamento;
    @NotBlank 
    private String observacao;
    @NotBlank
    private String valor;
          
 
    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

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
        Long id = Long.parseLong(idServico);
        servico.setDescricao(descricao);
        Double valorcerto = Double.parseDouble(valor);
        servico.setValor(valorcerto);
        servico.setId(id);
        return servico;
    }
    

}
