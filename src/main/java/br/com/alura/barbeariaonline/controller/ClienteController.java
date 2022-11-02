package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarCliente;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteCliente;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoCliente;
import br.com.alura.barbeariaonline.model.Cliente;
import br.com.alura.barbeariaonline.repository.ClienteRepository;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("cadastrar")
    public String formulario() {
        return "cliente/cadastrar";
    }
    
    @GetMapping("deletar")
    public String formdelete() {
        return "cliente/deletar";
    }
    
    @GetMapping("alterar")
    public String formalterar() {
        return "cliente/alterar";
    }
    @GetMapping("sucesso")
    public String formsucesso() {
        return "cliente/sucesso";
    }
    
    @PostMapping("novo")
    public String novo(RequisicaoNovoCliente requisicao) throws ParseException {
    
        Cliente cliente = requisicao.toCliente();
        System.out.println(cliente);
        clienteRepository.save(cliente);
        return "cliente/sucesso";
    }
    
       @PostMapping("alterar")
        public String alterar(RequisicaoAlterarCliente requisicao) throws ParseException {
            
           Cliente cliente = requisicao.toCliente();
           clienteRepository.save(cliente);
            return "cliente/sucesso";
        }
       
    @GetMapping("consultar")
    public String cliente(Model model, Principal principal) {
        Sort sort = Sort.by("id").ascending();
        
        List<Cliente> clientes = clienteRepository.findAll();       
        model.addAttribute("clientes", clientes);
        return "cliente/consultar";
    }

    
      @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteCliente requisicao) {        
         
        String idstring = requisicao.toCliente();          
        Long id = Long.parseLong(idstring);
       
        clienteRepository.deleteById(id);
        return "cliente/sucesso";
       
        
    }
    
    
}
