package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Servico;
import br.com.alura.barbeariaonline.repository.AgendamentoRepository;
import br.com.alura.barbeariaonline.repository.BarbeiroRepository;
import br.com.alura.barbeariaonline.repository.ClienteRepository;

@Controller

public class AgendamentosController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ServicoController servicoRepository;
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	
	
	
	
	
	@GetMapping("/agendamentos")
	public String agendamentos(Model model, Principal principal) {
	    Sort sort = Sort.by("data").ascending();
		
		List<Agendamento> agendamentos = agendamentoRepository.findAllTodosAgendamentos();
		System.out.println(agendamentos);
		model.addAttribute("agendamentos", agendamentos);
		
		
		return "agendamentos";
	}
	


}
