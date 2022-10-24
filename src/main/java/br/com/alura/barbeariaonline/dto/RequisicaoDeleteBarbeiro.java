package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteBarbeiro {

    @NotBlank
    private String idBarbeiro;

    public String getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(String idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public String toBarbeiro() {
        String id = idBarbeiro;
        
        
        return id;
    }

}
