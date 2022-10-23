package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoBarbeiro requisicao) {
	
		Barbeiro barbeiro = requisicao.toBarbeiro();
		barbeiroRepository.save(barbeiro);
		return "barbeiro/cadastrar";
	}
	@GetMapping("consultar")
	public String barbeiro(Model model, Principal principal) {
	    Sort sort = Sort.by("id").ascending();
	    
	    List<Barbeiro> barbeiros = barbeiroRepository.findAll();       
        model.addAttribute("barbeiros", barbeiros);
        return "barbeiro/consultar";
	    
	    
	}
	
	
}
