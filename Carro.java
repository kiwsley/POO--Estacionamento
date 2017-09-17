/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Carro {
    private String modelo;
    private String placa;
    private int ano;
    private Boolean ePrioritario;
    
    public Carro(String modelo, String placa, int ano, Boolean ePrioritario)
    {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.ePrioritario = ePrioritario;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public String getNome(){
        return this.modelo;
    }
    
    public Boolean getPrioridade()
    {
        return this.ePrioritario;
    }
}
