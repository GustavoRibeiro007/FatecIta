import model.Aluguel;
import model.Caminhao;
import model.Carro;
import model.Moto;
import model.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarControleAluguel {
    private List<Veiculo> veiculosDisponiveis;
    private List<Aluguel> alugueisRealizados;
    private int contadorAlugueis;

    public GerenciarControleAluguel() {
        veiculosDisponiveis = new ArrayList<>();
        alugueisRealizados = new ArrayList<>();
        contadorAlugueis = 0;
        inicializarVeiculos();
    }

    private void inicializarVeiculos() {
        veiculosDisponiveis.add(new Carro("ABC-1234", "BMW", 2023, "Roxo", 2));
        veiculosDisponiveis.add(new Moto("DEF-5678", "Kawasaki", 2017, "Preta", false));
        veiculosDisponiveis.add(new Caminhao("GHI-9101", "Mercedes-Benz", 2006, "Vermelho", 1000));
    }

    public void listarVeiculos() {
        System.out.println("Veículos disponíveis para aluguel:");
        for (Veiculo veiculo : veiculosDisponiveis) {
            System.out.println(veiculo);
        }
    }

    public void realizarAluguel(String placa) {
        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo.getPlaca().equals(placa)) {
                contadorAlugueis++;
                LocalDateTime dataHoraRetirada = LocalDateTime.now();
                Aluguel aluguel = new Aluguel(contadorAlugueis, veiculo, LocalDate.now(), dataHoraRetirada);

                System.out.println("Veículo alugado: " + veiculo);
                System.out.println("Custo do aluguel: " + aluguel.calcularCusto());
                System.out.println(aluguel.apresentarRegistroAluguel());

                // Espera de 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                veiculosDisponiveis.remove(veiculo);
                alugueisRealizados.add(aluguel);
                return;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado.");
    }

    public void realizarDevolucao(int idAluguel) {
        for (Aluguel aluguel : alugueisRealizados) {
            if (aluguel.getIdAluguel() == idAluguel) {
                LocalDateTime dataHoraDevolucao = LocalDateTime.now();
                aluguel.setHoraDevolucao(dataHoraDevolucao);
                veiculosDisponiveis.add(aluguel.getVeiculo());

                System.out.println("Veículo devolvido: " + aluguel.getVeiculo());
                System.out.println("Data e hora de devolução: " + dataHoraDevolucao);

                // Espera de 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return;
            }
        }
        System.out.println("Aluguel com ID " + idAluguel + " não encontrado.");
    }

    public void listarAlugueisRealizados() {
        System.out.println("Aluguéis realizados:");
        for (Aluguel aluguel : alugueisRealizados) {
            System.out.println(aluguel.apresentarRegistroAluguel());
        }
    }

    public static void main(String[] args) {
        GerenciarControleAluguel controleAluguel = new GerenciarControleAluguel();
        Scanner scanner = new Scanner(System.in);

        // Listar veículos disponíveis
        controleAluguel.listarVeiculos();

        // Realizar aluguel
        System.out.print("Digite a placa do veículo que deseja alugar: ");
        String placa = scanner.nextLine();
        controleAluguel.realizarAluguel(placa);

        // Listar veículos novamente após o aluguel
        controleAluguel.listarVeiculos();

        // Realizar devolução
        System.out.print("Digite o ID do aluguel que deseja devolver: ");
        int idAluguel = scanner.nextInt();
        controleAluguel.realizarDevolucao(idAluguel);

        // Listar aluguéis realizados
        controleAluguel.listarAlugueisRealizados();
    }
}
