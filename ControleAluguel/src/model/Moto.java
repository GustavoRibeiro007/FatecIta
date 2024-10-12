package model;

public class Moto extends Veiculo{
    private boolean TemBagageiro;
    public Moto(String placa, String marca, int ano, String cor, boolean TemBagagem) {
        super(placa, marca, ano, cor);
        this.TemBagageiro = TemBagagem;
    }

    public boolean isTemBagageiro() {
        return TemBagageiro;
    }

    public void setTemBagageiro(boolean temBagageiro) {
        TemBagageiro = temBagageiro;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "Tem Bagageiro: " + TemBagageiro + "\n" +
                "}";
    }
}
