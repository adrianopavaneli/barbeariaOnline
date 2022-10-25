package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteServico {

    @NotBlank
    private String idServico;

   

  

    public String getIdServico() {
        return idServico;
    }





    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }





    public String toServico() {
        String id = idServico;
        
        
        return id;
    }

}
