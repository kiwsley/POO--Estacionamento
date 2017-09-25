/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Automovel {
    String modelo;
    private String placa;
    private int ano;
    private Boolean ePrioritario;
    
    public Automovel(String modelo, String placa, int ano, Boolean ePrioritario)
    {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.ePrioritario = ePrioritario;
    }
    
    /*
    * Retorna "Carro" se for carro e "Moto" se for moto.
    */
    public String carroOuMoto()
    {
        return "Carro";
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
    
    public int getAno()
    {
        return this.ano;
    }
}
