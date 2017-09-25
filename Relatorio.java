/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */

public class Relatorio {
    
    
    ArrayList<String> relatorios = new ArrayList<>();
    
    public void adicionarRelatorio(Automovel automovel, Boolean entrou, LocalDateTime tempo, int vaga, float valorConta)
    {
        //1System.out.println("OLÀ1");
        Moto moto;
        if (entrou)
        {
            if(automovel.carroOuMoto().equals("Carro"))
                relatorios.add(tempo.getDayOfMonth()+"/"+tempo.getMonthValue()+"/"+tempo.getYear()+" - " + tempo.getHour() + ":" + tempo.getMinute() + ":" + tempo.getSecond() + " -> ENTROU "
                        + "carro modelo " + automovel.getNome() + " ano " + automovel.getAno() +  " com placa " + automovel.getPlaca() +" na vaga "+ vaga +".");
            else
            {
                moto = (Moto)automovel;
                relatorios.add(tempo.getDayOfMonth()+"/"+tempo.getMonthValue()+"/"+tempo.getYear()+" - " + tempo.getHour() + ":" + tempo.getMinute() + ":" + tempo.getSecond() + " -> ENTROU "
                        + "moto modelo " + automovel.getNome() +" "+ moto.getCilindradas() + "cc ano " + automovel.getAno() +  " com placa " + automovel.getPlaca() +" na vaga "+ vaga +".");
            }
        }
        else
        {
            
            if(automovel.carroOuMoto().equals("Carro"))
                relatorios.add(tempo.getDayOfMonth()+"/"+tempo.getMonthValue()+"/"+tempo.getYear()+" - " + tempo.getHour() + ":" + tempo.getMinute() + ":" + tempo.getSecond() + " -> SAIU "
                        + "carro modelo " + automovel.getNome()+ " ano " + automovel.getAno()+ " com placa " + automovel.getPlaca() +" da vaga "+ vaga +".");
            else
            {
                moto = (Moto)automovel;
                relatorios.add(tempo.getDayOfMonth()+"/"+tempo.getMonthValue()+"/"+tempo.getYear()+" - " + tempo.getHour() + ":" + tempo.getMinute() + ":" + tempo.getSecond() + " -> SAIU "
                        + "moto modelo " + moto.getNome() + " "+moto.getCilindradas()+ "cc ano " + moto.getAno()+ " om placa " + moto.getPlaca() +" da vaga "+ vaga +".");
            }
        }
        int size = relatorios.size()-1;
        if(automovel.getPrioridade())
        {
            relatorios.set(size, relatorios.get(size)+" - Com Prioridade");
        }
        else
        {
            relatorios.set(size, relatorios.get(size)+" - Sem Prioridade");
        }
        
        if (!entrou)
            relatorios.set(size, relatorios.get(size)+" - Valor da Conta: " + valorConta);
    }
    
    public void listarRelatorios()
    {
        int i;
        System.out.println("\n");
        for(i=0;i<relatorios.size();i++)
        {
            System.out.println(relatorios.get(i));
        }
        System.out.println("\n");
    }
}
