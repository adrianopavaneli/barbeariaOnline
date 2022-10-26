package br.com.alura.barbeariaonline.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Cliente;


public class RequisicaoNovoCliente {
	
	@NotBlank
	private String nomeCliente;
	@NotBlank
	private String cep;
	@NotBlank
	private String cidade;
	@NotBlank
	private String dataNascimento;
	@NotBlank
	private String email;
	@NotBlank
	private String endereco;
	@NotBlank
	private String rg;
	@NotBlank
	private String sexo;
	@NotBlank
	private String telefone;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:MM");
	
	public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String datanascimento) {
        this.dataNascimento = datanascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Cliente toCliente() throws ParseException {
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		cliente.setCep(cep);
	    cliente.setCidade(cidade);
	    cliente.setEmail(email);
	    cliente.setEndereco(endereco);
	    cliente.setRg(rg);
	    cliente.setSexo(sexo);
	    cliente.setTelefone(telefone);
	    Date data  = (Date) formatter.parse(dataNascimento);	    
	    cliente.setDataNascimento(data);
	   
		return cliente;
	}
	
	
	
}
