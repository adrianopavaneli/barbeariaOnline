package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoAlterarBarbeiro;
import br.com.alura.barbeariaonline.dto.RequisicaoDeleteBarbeiro;
import br.com.alura.barbeariaonline.dto.RequisicaoNovoAgendamento;
import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Barbeiro;
import br.com.alura.barbeariaonline.model.Cliente;
import br.com.alura.barbeariaonline.repository.AgendamentoRepository;
import br.com.alura.barbeariaonline.repository.BarbeiroRepository;
import br.com.alura.barbeariaonline.repository.ClienteRepository;
import br.com.alura.barbeariaonline.repository.ServicoRepository;

@Controller
@RequestMapping("agendamento")
public class AgendamentosController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	
    
    @GetMapping("cadastrar")
    public String formulario() {
        return "agendamento/cadastrar";
    }
    
    @GetMapping("deletar")
    public String formdelete() {
        return "agendamento/deletar";
    }
    
    @GetMapping("alterar")
    public String formalterar() {
        return "agendamento/alterar";
    }
    @GetMapping("sucesso")
    public String formsucesso() {
        return "agendamento/sucesso";
    }
    
    @PostMapping("novo")
    public String novo(RequisicaoNovoAgendamento requisicao) {
    
        Agendamento agendamento = requisicao.toAgendamento();
        agendamentoRepository.save(agendamento);
        return "agendamento/sucesso";
    }
    
       @PostMapping("alterar")
        public String alterar(RequisicaoAlterarAgendamento requisicao) {
            
            Agendamento agendamento = requisicao.toAgendamento();
            agendamentoRepository.save(agendamento);
            return "agendamento/sucesso";
        }
	
	
	
	
	
	
	@GetMapping("consultar")
	public String agendamentos(Model model, Principal principal) {
//	    Sort sort = Sort.by("data").descending();
		
		List<Agendamento> agendamentos = agendamentoRepository.findAllTodosAgendamentos();
		List<Cliente> clientes = clienteRepository.findAll();
		
		List<Barbeiro> barbeiros = barbeiroRepository.findAll();
		System.out.println(agendamentos);
		model.addAttribute("agendamentos", agendamentos);
		
		
		return "agendamento/consultar";
	}
	
	 @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteBarbeiro requisicao) {
         
         
                  String idstring = requisicao.toBarbeiro();          
        Long id = Long.parseLong(idstring);
        
        barbeiroRepository.deleteById(id);
        return "agendamento/sucesso";
       
        
    }
	


}
