package br.com.alura.barbeariaonline.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.barbeariaonline.dto.RequisicaoDeleteAgendamento;
import br.com.alura.barbeariaonline.model.Agendamento;
import br.com.alura.barbeariaonline.model.Barbeiro;
import br.com.alura.barbeariaonline.model.Cliente;
import br.com.alura.barbeariaonline.repository.AgendamentoRepository;
import br.com.alura.barbeariaonline.repository.BarbeiroRepository;
import br.com.alura.barbeariaonline.repository.ClienteRepository;


@Controller
@RequestMapping("agendamento")
public class AgendamentosController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
//	@Autowired
//	private ServicoRepository servicoRepository;
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
    
 
    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Barbeiro barbeiro, Model theModel) {
        theModel.addAttribute("barbeiros", barbeiroRepository.findAll());
        
        return"/cadastrar";
    }
    
    @GetMapping("buscaCliente")
    public String buscaCliente(Model model, Principal principal, @PathVariable Long id) {
        System.out.println("testecliente");
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
      System.out.println(clientes);
        return "agendamento/cadastrar";
    }
    
    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
       Map<String, String> countryList = new HashMap<String, String>();
       countryList.put("US", "United States");
       countryList.put("CH", "China");
       countryList.put("SG", "Singapore");
       countryList.put("MY", "Malaysia");
       return countryList;
    }
    
    
	
	
	
	@GetMapping("consultar")
	public String agendamentos(Model model, Principal principal) {
//	    Sort sort = Sort.by("data").descending();
		
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
