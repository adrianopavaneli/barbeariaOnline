package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Usuario;

public class RequisicaoAlterarUsuario {
    
    @NotBlank
    private String idUsuario;
    @NotBlank 
    private String username;
    @NotBlank
    private String password;
    
    
    
 
    public String getIdUsuario() {
        return idUsuario;
    }




    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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




 
    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        Long id = Long.parseLong(idUsuario);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setId(id);
        return usuario;   
    
    
    }

}