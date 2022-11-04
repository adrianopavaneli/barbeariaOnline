package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteUsuario {

    @NotBlank
    private String idUsuario;

   

    public String getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }



    public String toUsuario() {
        String id = idUsuario;
        
        
        return id;
    }

}