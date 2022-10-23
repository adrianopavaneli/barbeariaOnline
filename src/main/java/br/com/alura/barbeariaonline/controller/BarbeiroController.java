package br.com.alura.barbeariaonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("barbeiro")
public class BarbeiroController {
	
	@GetMapping("formulario")
	public String formulario() {
		return "barbeiro/formulario";
	}
	
	

}
