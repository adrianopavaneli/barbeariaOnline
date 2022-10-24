package br.com.alura.barbeariaonline.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.barbeariaonline.model.Barbeiro;

public class RequisicaoAlterarBarbeiro {
    
    @NotBlank
    private String idBarbeiro;
    @NotBlank
    private String nomeBarbeiro;
    
    
    
    public String getIdBarbeiro() {
        return idBarbeiro;
    }
    public void setIdBarbeiro(String idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }
    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }
    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }
    public Barbeiro toBarbeiro() {
        Barbeiro barbeiro = new Barbeiro();
        Long id = Long.parseLong(idBarbeiro);
        barbeiro.setNome(nomeBarbeiro);
        barbeiro.setId(id);
        return barbeiro;
    }
    
    
    
    

}
