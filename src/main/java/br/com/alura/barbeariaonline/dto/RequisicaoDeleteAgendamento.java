package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteAgendamento {

    @NotBlank
    private String idAgendamento;

    public String getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(String idAgendamento) {
        this.idAgendamento = idAgendamento;
    }


    public String toAgendamento() {
        String id = idAgendamento;
        
        
        return id;
    }

}
