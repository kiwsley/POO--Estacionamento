package estacionamento;

public class Estacionamento {

    public static void main(String[] args) {
        
        Carro c[]= new Carro[2];
        
        c[0]=new Carro("Celta", "MNZ 9087", 13,40);
        c[1]=new Carro("Celta", "XJL 5432", 20,10);
        c[0].setPrioridade(false);
        c[0].EntrarCarro();
        
        
        
    }
    
}
