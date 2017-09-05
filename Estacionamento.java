package projeto;

public class Estacionamento {
    
   
    private boolean prioridade;
    private int [] capacidadeVeiculo=new int[10];
 
    
    public void EntrarVeiculo(){
        int i=0;
        if (null==this.getCapacidadeVeiculo()){
            System.out.println("pode estacionar"+this.capacidadeVeiculo[i]);              
        }else{
            System.out.println("não pode estacionar");
        }
         i++; 
    }

    public boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public int[] getCapacidadeVeiculo() {
        return capacidadeVeiculo;
    }

    public void setCapacidadeVeiculo(int[] capacidadeVeiculo) {
        this.capacidadeVeiculo = capacidadeVeiculo;
    }

   
}

