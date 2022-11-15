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
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.barbeariaonline.dto.RequisicaoDeleteAgendamento;
import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Barbeiro;
import br.com.alura.barbeariaonline.model.Cliente;
import br.com.alura.barbeariaonline.model.Servico;
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
	
	@GetMapping(value = "cadastrar")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("agendamento/cadastrar");
        mv.addObject(new Agendamento());
        Sort sortBarbeiro = Sort.by("nome").ascending();
        List<Barbeiro> listaBarbeiro = barbeiroRepository.findAll(sortBarbeiro);
        mv.addObject("listaBarbeiro", listaBarbeiro);
        Sort sortCliente = Sort.by("nome").ascending();
        List<Cliente> listaCliente = clienteRepository.findAll(sortCliente);
        mv.addObject("listaCliente", listaCliente);
        Sort sortServico = Sort.by("descricao").ascending();
        List<Servico> listaServico = servicoRepository.findAll(sortServico);
        mv.addObject("listaServico", listaServico);
        return mv;
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
    
	@GetMapping("consultar")
	public String agendamentos(Model model, Principal principal) {
	    Sort sort = Sort.by("data").descending();
		
		List<Agendamento> agendamentos = agendamentoRepository.findAllTodosAgendamentos();
//		List<Cliente> clientes = clienteRepository.findAll();
//		
//		List<Barbeiro> barbeiros = barbeiroRepository.findAll();
//		
		model.addAttribute("agendamentos", agendamentos);
		
		
		return "agendamento/consultar";
	}
	
	 @PostMapping("deletar")  
     @DeleteMapping("deletar/{id}")   
    public String delete(RequisicaoDeleteAgendamento requisicao) {
         
         
                  String idstring = requisicao.toAgendamento();          
        Long id = Long.parseLong(idstring);
        
        agendamentoRepository.deleteById(id);
        return "agendamento/sucesso";
       
        
    }
	   
	    


}
