package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Aluguel {
    private int idAluguel;
    private Veiculo veiculo;
    private LocalDate dataAluguel;
    private LocalDateTime horaAluguel;
    private LocalDateTime horaDevolucao;

    public Aluguel(int idAluguel, Veiculo veiculo, LocalDate dataAluguel, LocalDateTime horaAluguel) {
        this.idAluguel = idAluguel;
        this.veiculo = veiculo;
        this.dataAluguel = dataAluguel;
        this.horaAluguel = horaAluguel;
    }

    // Método para calcular custo
    public double calcularCusto() {
        if (veiculo instanceof Carro) {
            return 100.0; // Custo para carro
        } else if (veiculo instanceof Moto) {
            return 80.0; // Custo para moto
        } else if (veiculo instanceof Caminhao) {
            return 150.0; // Custo para caminhão
        }
        return 0.0;
    }

    public String apresentarRegistroAluguel() {
        StringBuilder registro = new StringBuilder();
        registro.append("ID do Aluguel: ").append(idAluguel).append("\n")
                .append("Veículo: ").append(veiculo).append("\n")
                .append("Data do Aluguel: ").append(dataAluguel).append("\n")
                .append("Hora do Aluguel: ").append(horaAluguel).append("\n");

        if (horaDevolucao != null) {
            registro.append("Hora de Devolução: ").append(horaDevolucao).append("\n");
        } else {
            registro.append("Hora de Devolução: Pendente\n");
        }

        return registro.toString();
    }


    public class AluguelCarro extends Aluguel {
        public AluguelCarro(int idAluguel, Veiculo veiculo, LocalDate dataAluguel, LocalDateTime horaAluguel) {
            super(idAluguel, veiculo, dataAluguel, horaAluguel);
        }
    }

    public class AluguelMoto extends Aluguel {
        public AluguelMoto(int idAluguel, Veiculo veiculo, LocalDate dataAluguel, LocalDateTime horaAluguel) {
            super(idAluguel, veiculo, dataAluguel, horaAluguel);
        }
    }

    public class AluguelCaminhao extends Aluguel {
        public AluguelCaminhao(int idAluguel, Veiculo veiculo, LocalDate dataAluguel, LocalDateTime horaAluguel) {
            super(idAluguel, veiculo, dataAluguel, horaAluguel);
        }
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getHoraAluguel() {
        return horaAluguel;
    }

    public void setHoraAluguel(LocalDateTime horaAluguel) {
        this.horaAluguel = horaAluguel;
    }

    public LocalDateTime getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(LocalDateTime horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }
}
