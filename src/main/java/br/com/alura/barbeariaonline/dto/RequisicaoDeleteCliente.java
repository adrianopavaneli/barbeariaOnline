package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteCliente {

    @NotBlank
    private String idCliente;

   

  




    public String getIdCliente() {
        return idCliente;
    }








    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }








    public String toCliente() {
        String id = idCliente;
        
        
        return id;
    }

}
