package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.model.User;

import br.com.alura.barbeariaonline.repository.UsuarioRepo;
import br.com.alura.barbeariaonline.service.MyUserDetailService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    
    @Autowired
    private MyUserDetailService usuarioService;
    
    @GetMapping("cadastrar")
    public String formulario() {
        return "usuario/cadastrar";
    }
    
    @GetMapping("deletar")
    public String formdelete() {
        return "usuario/deletar";
    }
    
    @GetMapping("alterar")
    public String formalterar() {
        return "usuario/alterar";
    }
    @GetMapping("sucesso")
    public String formsucesso() {
        return "usuario/sucesso";
    }
 
    
     
//    @GetMapping("new-user")
//    public String newUser() {
//        User usuario = new User();
//        usuario.setId(1L);
//        usuario.setUsername("adriano");
//        usuario.setPassword("1234");
//        usuarioService.save(usuario);
//        return usuario.toString();
//    }
    
    
}