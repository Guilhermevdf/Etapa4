package aplicacao;

public class Automovel {

	private String cor;
	private String modelo;
	private int velocidade_atual;
	private String placa;

	public Automovel(String cor, String modelo, int velocidade_atual, String placa) {
		this.cor = cor;
		this.modelo = modelo;
		this.velocidade_atual = velocidade_atual;
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidade_atual() {
		return velocidade_atual;
	}

	public void setVelocidade_atual(int velocidade_atual) {
		this.velocidade_atual = velocidade_atual;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/*
	 * Situação (parado, em movimento), Velocidade atual, marcha atual (até 40 km/h
	 * 1º marcha, até 60 km/h 2º marcha, até 80 km/h 3º marcha, até 100 km/h 4º
	 * marcha, depois 5º marcha), acelerar (aumento da velocidade), frear (diminuir
	 * velocidade). Ligar ou Desligar (O carro só poderá ser ligado ou desligado na
	 * situação parado).
	 */

	void situacaoVeiculo() {
		if (velocidade_atual == 0) {
			System.out.println("O carro está parado!");
		} else {
			System.out.println("O carro está em movimento!");
		}
	}

	int marcha_atual() {
		if (velocidade_atual <= 40) {
			return 1;
		} else if (velocidade_atual <= 60) {
			return 2;
		} else if (velocidade_atual <= 80) {
			return 3;
		} else if (velocidade_atual <= 100) {
			return 4;
		}
		return 5;
	}

	void acelerarVeiculo(double acelerar) {
		if (acelerar >= 0) {
			velocidade_atual += acelerar;
		}
	}

	void frearVeiculo(double freio) {
		if (freio >= 0 && velocidade_atual >= freio) {
			velocidade_atual -= freio;
		}
	}

	@Override
	public String toString() {
		return "Automovel [cor=" + cor + ", modelo=" + modelo + ", velocidade_atual=" + velocidade_atual + ", placa="
				+ placa + "]";
	}

}
