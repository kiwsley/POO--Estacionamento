/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Carro extends Automovel{

    public Carro(String modelo, String placa, int ano, Boolean ePrioritario) {
        super(modelo, placa, ano, ePrioritario);
    }
    
   /*
    * Retorna "Carro" se for carro e "Moto" se for moto.
    */
    @Override
    public String carroOuMoto()
    {
        return "Carro";
    }
}
