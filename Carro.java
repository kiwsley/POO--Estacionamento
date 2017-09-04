package estacionamento;

public class Carro {
    private  String Modelo;
    private String Placa;
    private int Horas;
    private int Minutos;
    private boolean Prioridade;
    
    int vaga[];
    
    
    

    public Carro(String Modelo, String Placa, int Horas, int Minutos) {
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.Horas = Horas;
        this.Minutos = Minutos;
    }
   
    //get e set

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    public int getMinutos() {
        return Minutos;
    }

    public void setMinutos(int Minutos) {
        this.Minutos = Minutos;
    }

    public boolean getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(boolean Prioridade) {
        this.Prioridade = Prioridade;
    }
    
    public void EntrarCarro(){
       
            if (this.Prioridade){
            
            System.out.println("quantidades de vagas para Prioridades: " );
            System.out.println("quantidades de vagas sem prioridades: "  );
            
       
            }else{
            
            System.out.println("quantidades de vagas para Prioridades: " );
            System.out.println("quantidades de vagas sem prioridades: " );
        }
        
    }
    
    public void SairCarro(){
        if (this.Prioridade){
            
            System.out.println("O carro de placa: " +this.getPlaca()+ " saiu as " );
            System.out.println("Atualizando a quantidade de vagas prioritarias: " );
        }else{
            
            System.out.println("O carro de placa: " +this.getPlaca()+ " saiu as " );
            System.out.println("Atualizando a quantidade de vagas: " );
            
            
        }
        
    }}

   
    


