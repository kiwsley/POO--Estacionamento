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
public class Estacionamento {
    
    private int capacidadeDeCarros;
    private int nVagasDePrioridade;
    private Relatorio relatorio;
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Boolean> vagas = new ArrayList<>();   // TRUE se a vaga está ocupada, FALSE caso contrário
    private ArrayList<Boolean> prioridades = new ArrayList<>(); // TRUE se a vaga é prioritária, FALSE caso contrário
    
    public Estacionamento(int capacidade, int nVagasDePrioridade)
    {
        this.relatorio = new Relatorio();
        this.capacidadeDeCarros = capacidade;
        this.nVagasDePrioridade = nVagasDePrioridade;
        int i;
        for (i=0;i<capacidadeDeCarros;i++)
        {
            vagas.add(Boolean.FALSE);
            Conta conta = new Conta();
            contas.add(conta);
        }
        for (i=0;i<nVagasDePrioridade;i++)
        {
            prioridades.add(Boolean.TRUE);  // primeiras n vagas serão de prioridade
        }
        for (;i<capacidadeDeCarros;i++)
        {
            prioridades.add(Boolean.FALSE);  // ultima m vagas não serão de prioridade
        }
        
    }
    
    // Vaículo entra no estacionamento
    void entrarVeículo(Automovel carro, int vaga)
    {
        
        LocalDateTime dataCadastro = LocalDateTime.now();
        relatorio.adicionarRelatorio(carro, Boolean.TRUE, dataCadastro, vaga, 0);
        contas.get(vaga).abrirConta(dataCadastro, carro);
        vagas.set(vaga, Boolean.TRUE);
        
    }
    
    // Vaículo sai do estacionamento
    float sairVeiculo(int vaga)
    {
        float ret = contas.get(vaga).calculaConta(LocalDateTime.now());
        relatorio.adicionarRelatorio(contas.get(vaga).getCarro(), Boolean.FALSE, LocalDateTime.now(), vaga, ret);
        contas.get(vaga).fecharConta();
        vagas.set(vaga, Boolean.FALSE);
        return ret;
    }
    
    // Verifica se a vaga está ocupada
    public boolean ConsultarVaga(int vaga)
    {
        return this.vagas.get(vaga);
    }
    
    // Verifica se a vaga está ocupada
    public boolean ConsultarPrioridadeVaga(int vaga)
    {
        return this.prioridades.get(vaga);
    }
    
    // Retorna capacidade do estacionamento
    public int getCapacidade()
    {
        return this.capacidadeDeCarros;
    }
    
    // Retorna a vaga que está um determinado carro
    public int getVagaPorCarro(Automovel carro) 
    {
        int i;
        for(i=0;i<this.capacidadeDeCarros;i++)
        {
            //System.out.println("carro =  " +carro.getPlaca());
            if(vagas.get(i))//Se a vaga estiver ocupada verifica se o carro esta lá 
            {
                if(carro.getPlaca().equals(contas.get(i).getCarro().getPlaca()))
                {
                    return i;
                }
            }
        }   
        System.out.println(carro.getNome()+" não encontado.");
        return -1;
    }
    
    public Automovel getCarroPorPlaca(String placa)
    {
        int i;
        for(i=0;i<this.capacidadeDeCarros;i++)
        {
            //System.out.println("CARRO: "+contas.get(i).getCarro().getPlaca());
            if(vagas.get(i))//Se a vaga estiver ocupada verifica se o carro esta lá 
            {
                if(placa.equals(contas.get(i).getCarro().getPlaca()))
                {
                    
                    return contas.get(i).getCarro();
                }
            }
        }   
        System.out.println("Automóvel com placa "+placa+" não encontado.");
        return null;
    }
    
    public Relatorio getRelatorio()
    {
        return this.relatorio;
    }
    
    public void listaVagas()
    {
        int i;
        for(i=0;i<capacidadeDeCarros;i++)
        {
            if(!vagas.get(i))
            {
                if(prioridades.get(i))
                    System.out.println("Vaga com prioridade " + i +" vazia");
                else
                    System.out.println("Vaga sem prioridade " + i +" vazia");
            }
            else
            {
                if(prioridades.get(i))
                {
                    System.out.print("Vaga com prioridade " + i + ": ");
                    if(contas.get(i).getCarro().carroOuMoto().equals("Carro"))
                    {
                        System.out.println("Tem um carro "+ contas.get(i).getCarro().
                                getNome() + " com placa " + contas.get(i).getCarro().getPlaca());
                    }
                    else{
                        Moto moto = (Moto)(contas.get(i).getCarro());
                        System.out.println("Tem uma moto "+ contas.get(i).getCarro().
                                getNome() + " "+moto.getCilindradas()+"cc com placa " + contas.get(i).getCarro().getPlaca());
                    }
                }
                else
                {
                    System.out.print("Vaga sem prioridade " + i + ": ");
                    
                    if(contas.get(i).getCarro().carroOuMoto().equals("Carro"))
                    {
                        System.out.println("Tem um carro "+ contas.get(i).getCarro().
                                getNome() + " com placa " + contas.get(i).getCarro().getPlaca());
                    }
                    else{
                        Moto moto = (Moto)(contas.get(i).getCarro());
                        System.out.println("Tem uma moto "+ contas.get(i).getCarro().
                                getNome() + " "+moto.getCilindradas()+"cc com placa " + contas.get(i).getCarro().getPlaca());
                    }
                }
            }
        }
        
    }
}

