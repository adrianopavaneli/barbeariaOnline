package br.com.alura.barbeariaonline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String nome;
	    private String sexo;
	   
	    private LocalDate dataNascimento;
	    private String telefone;
	    private String email;
	    private String rg;
	    private String endereco;
	    private String cep;
	    private String cidade;
	    
	    public void setDataNascimento(String data) {
	        try {
	            this.dataNascimento = LocalDate.parse(data);                
            } catch (Exception e) {
                System.out.println("erro ao parsear data: " + e.getMessage());
            }
	       	       	        
	    }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
	    

}
