package br.com.alura.barbeariaonline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoNovoUsuario;
import br.com.alura.barbeariaonline.repository.UsuarioRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoUsuario requisicao) {
		return "usuario/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "usuario.formulario";
		}
		
		
		
		return null;
	}

}
