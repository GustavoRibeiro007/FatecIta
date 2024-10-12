package model;

public class Caminhao extends Veiculo {
    private int CapacidadeCarga;
    public Caminhao(String placa, String marca, int ano, String cor, int CapacidadeCarga) {
        super(placa, marca, ano, cor);
        this.CapacidadeCarga = CapacidadeCarga;
    }

    public int getCapacidadeCarga() {
        return CapacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        CapacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() {
        return "Caminhão{" +
                "Capacidade de Carga: " + CapacidadeCarga + "\n" +
                "}";
    }
}
