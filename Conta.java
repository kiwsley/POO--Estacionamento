/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Usuário
 */
public class Conta {
    private float taxaFixa;
    private float taxaPorHora;
    private LocalDateTime dataEntrada;
    private Automovel carro;
    private boolean aberta;     // Bool para dizer se a conta esta aberta ou fechada
    
    
    public Conta()
    {
        
    }
    
    
    // Calcula quantidade de horas da chegada do carro até a saída,
    // multiplica pela taxa por hora e soma à taxa fixa
    public float calculaConta(LocalDateTime dataSaida)
    {
        //calcula diferença entre as horas de chegada e saída
        long meses = dataEntrada.until(dataSaida, ChronoUnit.HOURS);
        
        return meses*taxaPorHora + taxaFixa;
    }
    
    public Automovel getCarro()
    {
        return this.carro;
    }
    
    public void abrirConta(LocalDateTime dataEntrada, Automovel carro)
    {
        this.dataEntrada = dataEntrada;
        this.taxaFixa = 2;                  // Taxa fixa = 2 reais
        this.carro = carro;
        this.aberta = true;
        this.taxaPorHora = 2;       // + 2 reais por hora
    }
    
    public void fecharConta()
    {
        this.aberta = false;
    }
}
