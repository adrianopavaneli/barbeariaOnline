package br.com.alura.barbeariaonline.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
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
    private LocalDateTime data;
    private boolean ativo;    
    private String observacao;
    
    public Agendamento() {
    	
    }

    public void setData(String datastring) {
        try {
            this.data = LocalDateTime.parse(datastring);                
        } catch (Exception e) {
            System.out.println("erro ao parsear data: " + e.getMessage());
        }
                        
    }
   
    

   

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor + ", data=" + data + ", observacao=" + observacao + '}';
    }
    

}
