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

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarBarbeiro;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteBarbeiro;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoBarbeiro;
import br.com.alura.barbeariaonline.model.Barbeiro;
import br.com.alura.barbeariaonline.repository.BarbeiroRepository;

@Controller
@RequestMapping("barbeiro")
public class BarbeiroController {
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	@GetMapping("cadastrar")
	public String formulario() {
		return "barbeiro/cadastrar";
	}
	
	@GetMapping("deletar")
    public String formdelete() {
        return "barbeiro/deletar";
    }
	
	@GetMapping("alterar")
    public String formalterar() {
        return "barbeiro/alterar";
    }
	@GetMapping("sucesso")
    public String formsucesso() {
        return "barbeiro/sucesso";
    }
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoBarbeiro requisicao) {
	System.out.println("teste");
		Barbeiro barbeiro = requisicao.toBarbeiro();
		barbeiroRepository.save(barbeiro);
		return "barbeiro/sucesso";
	}
	
	   @PostMapping("alterar")
	    public String alterar(RequisicaoAlterarBarbeiro requisicao) {
	        
	        Barbeiro barbeiro = requisicao.toBarbeiro();
	        barbeiroRepository.save(barbeiro);
	        return "barbeiro/sucesso";
	    }
	   
	@GetMapping("consultar")
	public String barbeiro(Model model, Principal principal) {
	    Sort sort = Sort.by("id").ascending();
	    
	    List<Barbeiro> barbeiros = barbeiroRepository.findAll();       
        model.addAttribute("barbeiros", barbeiros);
        return "barbeiro/consultar";
	}

	
      @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteBarbeiro requisicao) {
         
         
                  String idstring = requisicao.toBarbeiro();          
        Long id = Long.parseLong(idstring);
        
        barbeiroRepository.deleteById(id);
        return "barbeiro/sucesso";
       
	    
	}
	
	
}
