package br.com.alura.barbeariaonline.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarUser;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteUser;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoUser;
import br.com.alura.barbeariaonline.model.User;
import br.com.alura.barbeariaonline.repository.UsuarioRepo;
import br.com.alura.barbeariaonline.service.MyUserDetailService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepo usuarioRepository;
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
    @GetMapping("novo")
    public String novo(RequisicaoNovoUser requisicao) {
        
        User user = requisicao.toUser();
        usuarioService.save(user);
        return "usuario/sucesso";
    }
    @GetMapping("alterando")
    public String alterar(RequisicaoAlterarUser requisicao) {
        
       User user = requisicao.toUser();
       usuarioService.save(user);
        return "usuario/sucesso";
    }
    
    @GetMapping("consultar")
    public String user(Model model, Principal principal) {
        Sort sort = Sort.by("id").ascending();
        
        Iterable<User> users = usuarioRepository.findAll();       
        model.addAttribute("users", users);
        return "usuario/consultar";
    }
    
    @PostMapping("deletar")  
    @DeleteMapping("deletar/{id}")   
   public String delete(RequisicaoDeleteUser requisicao) {        
        
       String idstring = requisicao.toUser();          
       Long id = Long.parseLong(idstring);
      
       usuarioRepository.deleteById(id);
       return "usuario/sucesso";
      
       
   }
    
     
    @GetMapping("new-user")
    public String newUser() {
        User usuario = new User();
        usuario.setId(2L);
        usuario.setUsername("adriano");
        usuario.setPassword("1234");
        usuarioService.save(usuario);
        return usuario.toString();
    }
    
    
}