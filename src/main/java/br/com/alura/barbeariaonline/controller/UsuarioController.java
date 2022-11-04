package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarUsuario;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteUsuario;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoUsuario;
import br.com.alura.barbeariaonline.model.Usuario;
import br.com.alura.barbeariaonline.repository.UsuarioRepository;
import br.com.alura.barbeariaonline.service.MyUserDetailService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
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
    
    @PostMapping("novo")
    public String novo(RequisicaoNovoUsuario requisicao) {
    
        Usuario usuario = requisicao.toUsuario();
        usuarioRepository.save(usuario);
        return "usuario/sucesso";
    }
    
       @PostMapping("alterar")
        public String alterar(RequisicaoAlterarUsuario requisicao) {
            
           Usuario usuario = requisicao.toUsuario();
           usuarioRepository.save(usuario);
            return "usuario/sucesso";
        }
       
    @GetMapping("consultar")
    public String usuario(Model model, Principal principal) {
        Sort sort = Sort.by("id").ascending();
        
        List<Usuario> usuarios = usuarioRepository.findAll();       
        model.addAttribute("usuarios", usuarios);
        return "usuario/consultar";
    }

    
      @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteUsuario requisicao) {        
         
        String idstring = requisicao.toUsuario();          
        Long id = Long.parseLong(idstring);
       
        usuarioRepository.deleteById(id);
        return "usuario/sucesso";
       
        
    }
      @GetMapping("/new-user")
      public String newUser() {
          Usuario usuario = new Usuario();
          usuario.setId(1L);
          usuario.setUsername("danilo");
          usuario.setPassword("123");
          usuarioService.save(usuario);
          return usuario.toString();
      }
    
    
}