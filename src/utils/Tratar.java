package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tratar {

	public static List<Automovel> carros = new ArrayList<>();
	private static Scanner dado = new Scanner(System.in);
	public void UI() throws InterruptedException {
		do {
			System.out.println("|=====================|");
			carros.forEach(x -> System.out.println(x.toString()));
			System.out.print("| Digite a placa do carro que você deseja dirigir: ");
			Automovel carroEscolhido = (Automovel) verificarPlacaCarro(carros);
			String op;
			do {
				System.out.println("|===============================|");
				System.out.println("|        PAINEL DO CARRO        |");
				System.out.println("|===============================|");
				System.out.println("| [1] Ligar/Desligar            |");
				System.out.println("| [2] Velocidade atual          |");
				System.out.println("| [3] Marcha atual              |");
				System.out.println("| [4] Acelerar veiculo          |");
				System.out.println("| [5] Frear                     |");
				System.out.println("| [6] Situação                  |");
				System.out.println("| [0] Trocar de carro           |");
				System.out.println("|===============================|");
				 op = dado.next();
				switch (op) {
				case "1":
					System.out.println("Para ligar ou desligar, digite [Ligar || Desligar]: ");
					String ligOrDesl = dado.next();
					carroEscolhido.ligarDesligarVeiculo(ligOrDesl);
					break;
				case "2":
					System.out.println(carroEscolhido.getVelocidade_atual() + " Km/h");
					break;
				case "3":
					System.out.println("Seu carro esta na: " + carroEscolhido.marchaAtual() + " marcha!");
					break;
				case "4":
					if (!carroEscolhido.getEstado() == false) {
						System.out.println("Digite quanto você deseja acelerar: ");
						Integer aumVeloc = Tratar.verificarInteiro();
						carroEscolhido.acelerarVeiculo(aumVeloc);
						System.out.println("Voce acelerou " + aumVeloc + "Km/h sua velocidade atual é: "
								+ carroEscolhido.getVelocidade_atual() + "Km/h");
					} else {
						System.out.println("Seu carro está desligado, não é possivel acelerar!");
					}

					break;
				case "5":
					if (!carroEscolhido.getEstado() == false) {
						System.out.println("Digite quanto você deseja frear: ");
						Integer dimVeloc = Tratar.verificarInteiro();
						carroEscolhido.frearVeiculo(dimVeloc);
						System.out.println("Voce freou " + dimVeloc + "Km/h sua velocidade atual é: "
								+ carroEscolhido.getVelocidade_atual() + "Km/h");
					} else {
						System.out.println("Seu carro está desligado, não é possivel frear!");
					}
					break;
				case "6":
					carroEscolhido.situacaoVeiculo();
					break;
				default:
					break;
				}
			
			}while(!op.equals("0"));

		} while (true);

	}

	public Tratar() {
		carros.add(new Automovel("Preto", "HB20", 0, "ICE3923"));
		carros.add(new Automovel("Prata", "Corola", 0, "DCJ1974"));
		carros.add(new Automovel("Branco", "Punto", 0, "IRO2383"));
		carros.add(new Automovel("Azul", "Parati", 0, "WCC2254"));
		carros.add(new Automovel("Grafit", "SW4", 0, "NCR2671"));
		carros.add(new Automovel("Vermelho", "Uno", 0, "PZQ4791"));
		carros.add(new Automovel("Preto", "A4", 0, "UWE2893"));
	}

	public static Automovel verificarPlacaCarro(List<Automovel> lista) throws InterruptedException {
		String placa = dado.next();
		dormirSegundos(400L, "Verificando placa");
		for (Automovel veiculo : lista) {
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		return null;
	}

	public static void dormirSegundos(long dormindoPor, String texto) throws InterruptedException {
		System.out.print(texto);
		for (int i = 0; i < 2; i++) {
			Thread.sleep(dormindoPor);
			System.out.print(".");
		}
		Thread.sleep(dormindoPor);
		System.out.println(".");
	}

	public static Integer verificarInteiro() {
		Integer numero = null;
		do {
			try {
				String nome = dado.next();
				dado.nextLine();
				numero = Integer.parseInt(nome);
			} catch (Exception e) {
				System.err.print("Numero invalido, digite novamente : ");
			}
		} while (numero == null);
		return numero;
	}

	boolean listaVazia(List<?> lista) {
		return lista.size() == 0 || lista == null;
	}

}
