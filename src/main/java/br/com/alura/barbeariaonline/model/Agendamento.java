package br.com.alura.barbeariaonline.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="agendamentos")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
	@ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;
	@ManyToOne(fetch = FetchType.EAGER)
    private Barbeiro barbeiro;
    private double valor;
    private Date data;
    private boolean ativo;
    
    private String observacao;
    
    public Agendamento() {
    	
    }

    public Agendamento(Long id, Cliente cliente, Servico servico, double valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Agendamento(Long id, Cliente cliente, Servico servico, Barbeiro barbeiro,double valor, Date data, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.barbeiro = barbeiro;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        
    }

   

    public Agendamento(Long id, double valor, Date data, String observacao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }


    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor + ", data=" + data + ", observacao=" + observacao + '}';
    }
    

}
