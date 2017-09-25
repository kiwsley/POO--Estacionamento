/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Moto extends Automovel{
    
    private int cilindradas;
    
    public Moto(String modelo, String placa, int ano, Boolean ePrioritario,int cilindradas) {
        super(modelo, placa, ano, ePrioritario);
        this.cilindradas = cilindradas;
    }
    
    /*
    * Retorna "Carro" se for carro e "Moto" se for moto.
    */
    @Override
    public String carroOuMoto()
    {
        return "Moto";
    }
    
    public int getCilindradas()
    {
        return this.cilindradas;
    }
    
}
