package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.User;

public class RequisicaoAlterarUser {
    
    @NotBlank
    private String idUser;
    @NotBlank 
    private String username;
    @NotBlank
    private String password; 
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        User user = new User();
        Long id = Long.parseLong(idUser);
        user.setUsername(username);
        user.setPassword(password);        
        user.setId(id);
        return user;
    }
    

}
