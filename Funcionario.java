/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuário
 */
public class Funcionario {
    private String nome;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Carro> carros = new ArrayList<>();
        
        Funcionario pedro = new Funcionario("Pedro");
        
       /* 
        Carro siena = new Carro("Siena", "ILR3212", 1998,true);
        Carro gol = new Carro("gol", "IEC9923", 1991,false);
        Carro fiesta = new Carro("fiesta", "III3212", 2011,false);
       
        pedro.estacionaCarro(siena, pareAqui);
        pedro.estacionaCarro(gol, pareAqui);
        pedro.estacionaCarro(fiesta, pareAqui);
        */
        
        
        Scanner ler = new Scanner(System.in);
        int input = 9;
        
        String nome;
        String placa;
        Boolean prioridade;
        int ano;
        
        int VAGAS = 5;
        int paraIdosos = 2;
        
        Estacionamento pareAqui = new Estacionamento(VAGAS, paraIdosos);
        
        while(input != 0)
        {
            System.out.println("\nBem vindo ao estacionamento Pare Aqui. Nosso estacionamento dispões de "+ VAGAS + 
                    " vagas e "+paraIdosos+" delas são prioritárias.\nDigite uma opção:\n1-Estacionar Carro\n2-Retirar Carro\n3-Listar Vagas\n0-Sair\n\nSua opção:");
            input=ler.nextInt();
            
            switch(input)
            {
                case 1:
                    
                    ler.nextLine();// Esvazia Buffer
                    System.out.println("Digite o modelo do Carro: ");
                    nome = ler.nextLine();
                    System.out.println("Digite a placa do Carro: ");
                    placa = ler.nextLine();
                    System.out.println("O carro é de idoso (0 para não e 1 para sim)?: ");
                    ano = ler.nextInt();
                    if (ano == 1)
                    {
                        prioridade = true;
                    }
                    else prioridade = false;
                    ler.nextLine();// Esvazia Buffer
                    System.out.println("Digite o ano do Carro: ");
                    ano = ler.nextInt();
                    
                    Carro carro = new Carro(nome, placa, ano, prioridade);
                    pedro.estacionaCarro(carro, pareAqui);
                    break;
                case 2:
                    ler.nextLine(); // Esvazia Buffer
                    System.out.println("Digite a placa do carro que deseja retirar: ");
                    placa = ler.nextLine();
                    
                    Carro carroParaRetirar = pareAqui.getCarroPorPlaca(placa);
                    
                    pedro.retiraCarro(carroParaRetirar, pareAqui);
                    break;
                case 3:
                    pareAqui.listaVagas();
            }
        }
        System.out.println("\nObrigado!");
    }
    
    public Funcionario(String nome)
    {
        this.nome = nome;
    }
    
    // Tenta estacionar o carro, se tiver sucesso retorna TRUE;
    public Boolean estacionaCarro(Carro carro, Estacionamento estacionamento) 
    {
        int i;
        // Verifica se o carro é de idoso
        if(carro.getPrioridade())
        {
            for (i=0; i<estacionamento.getCapacidade(); i++)
            {
                if(!estacionamento.ConsultarVaga(i))
                {
                    estacionamento.entrarVeículo(carro, i);
                    if(estacionamento.ConsultarPrioridadeVaga(i))
                    {
                        System.out.println( carro.getNome()+" estacionado com sucesso na vaga " + i + " (com prioridade).");
                    }
                    else
                    {
                        System.out.println( "Vagas com prioridade preenchidas, porém o "+carro.getNome()+" foi estacionado com sucesso na vaga " + i + " (sem prioridade).");
                    }
                    return true;
                }
            }
            if(i==estacionamento.getCapacidade())
            {
                System.out.println("Não existem mais vagas no estacionamento. " + carro.getNome()+ " não estacionado.");
            }
            return false;
        }
        else
        {
            for (i=0; i<estacionamento.getCapacidade(); i++)
            {
                // Se a vaga estiver livre e não for preferencial, ele estaciona
                if(!estacionamento.ConsultarVaga(i) && !estacionamento.ConsultarPrioridadeVaga(i))
                {
                    estacionamento.entrarVeículo(carro, i);
                    System.out.println( carro.getNome()+" estacionado com sucesso na vaga " + i + " (sem prioridade).");
                    return true;
                }
            }
            if(i==estacionamento.getCapacidade())
            {
                System.out.println("Não existem mais vagas sem prioridade no estacionamento. "  + carro.getNome()+ " não estacionado.");
            }
            return false;
        }
    }
    
    // retira carro e Retorna valor do estacionamento, -1 caso o carro não seja encontrado
    public float retiraCarro(Carro carro, Estacionamento estacionamento)
    {
        int vaga = estacionamento.getVagaPorCarro(carro);
        if(vaga!=-1)
        {
            float valor = estacionamento.sairVeiculo(vaga);
            System.out.println(carro.getNome() + " retirado da vaga "+ vaga +", o valor de sua conta é de R$"+valor+".");
            return valor;
        }
        else return -1;
        
    }
}
