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

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarServico;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteServico;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoServico;
import br.com.alura.barbeariaonline.model.Servico;
import br.com.alura.barbeariaonline.repository.ServicoRepository;

@Controller
@RequestMapping("servico")
public class ServicoController {
    @Autowired
    private ServicoRepository servicoRepository;
    
    @GetMapping("cadastrar")
    public String formulario() {
        return "servico/cadastrar";
    }
    
    @GetMapping("deletar")
    public String formdelete() {
        return "servico/deletar";
    }
    
    @GetMapping("alterar")
    public String formalterar() {
        return "servico/alterar";
    }
    @GetMapping("sucesso")
    public String formsucesso() {
        return "servico/sucesso";
    }
    
    @PostMapping("novo")
    public String novo(RequisicaoNovoServico requisicao) {
    
        Servico servico = requisicao.toServico();
        servicoRepository.save(servico);
        return "servico/sucesso";
    }
    
       @PostMapping("alterar")
        public String alterar(RequisicaoAlterarServico requisicao) {
            
           Servico servico = requisicao.toServico();
           servicoRepository.save(servico);
            return "servico/sucesso";
        }
       
    @GetMapping("consultar")
    public String servico(Model model, Principal principal) {
        Sort sort = Sort.by("id").ascending();
        
        List<Servico> servicos = servicoRepository.findAll();       
        model.addAttribute("servicos", servicos);
        return "servico/consultar";
    }

    
      @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteServico requisicao) {        
         
        String idstring = requisicao.toServico();          
        Long id = Long.parseLong(idstring);
        
        servicoRepository.deleteById(id);
        return "servico/sucesso";
       
        
    }
    
    
}
