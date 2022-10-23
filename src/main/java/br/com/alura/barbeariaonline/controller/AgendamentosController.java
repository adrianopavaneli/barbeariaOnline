package br.com.alura.barbeariaonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Cliente;
import br.com.alura.barbeariaonline.repository.AgendamentoRepository;
import br.com.alura.barbeariaonline.repository.ClienteRepository;

@Controller
public class AgendamentosController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@GetMapping("/agendamentos")
	public String agendamentos(Model model) {
		
		List<Agendamento> agendamentos = agendamentoRepository.findAll();
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("agendamentos", agendamentos);
		
		
		return "agendamentos";
	}

}
