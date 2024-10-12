package model;

public class Carro extends Veiculo {
    private int NumPortas;

    public Carro(String placa, String marca, int ano, String cor, int NumPortas) {
        super(placa, marca, ano, cor);
        this.NumPortas = NumPortas;
    }

    public int getNumPortas() {
        return NumPortas;
    }

    public void setNumPortas(int numPortas) {
        NumPortas = numPortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "Número de Portas: " + NumPortas + "\n" +
                "}";
    }
}
