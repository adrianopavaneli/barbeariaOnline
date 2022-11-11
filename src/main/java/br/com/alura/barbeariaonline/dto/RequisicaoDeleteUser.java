package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

public class RequisicaoDeleteUser {

    @NotBlank
    private String idUser;

   

  

    public String getIdUser() {
        return idUser;
    }





    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }





    public String toUser() {
        String id = idUser;
        
        
        return id;
    }

}
