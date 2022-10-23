package br.com.alura.barbeariaonline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("formulario")
	public String formulario() {
		return "barbeiro/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoBarbeiro requisicao) {
//		if(result.hasErrors()) {
//			return "barbeiro/formulario";
//		}
		Barbeiro barbeiro = requisicao.toBarbeiro();
		barbeiroRepository.save(barbeiro);
		return "barbeiro/formulario";
	}
}
