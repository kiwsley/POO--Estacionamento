package projeto;


public class Carro {
    private String Modelo;
    private String Placa;
    private String Cor;

    public Carro(String Modelo, String Placa, String Cor) {
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.Cor = Cor;
    }
    

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

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }
    
    
    
}
