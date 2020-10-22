package utils;

public class Automovel {

	private boolean estado;
	private String cor;
	private String modelo;
	private int velocidade_atual;
	private String placa;

	public Automovel() {

	}

	public Automovel(String cor, String modelo, int velocidade_atual, String placa) {
		this.estado = false;
		this.cor = cor;
		this.modelo = modelo;
		this.velocidade_atual = velocidade_atual;
		this.placa = placa;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public void situacaoVeiculo() {
		if (velocidade_atual == 0) {
			System.out.println("O carro está parado!");
		} else {
			System.out.println("O carro está em movimento!");
		}
	}

	public int marchaAtual() {
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

	public void acelerarVeiculo(Integer acelerar) {
		if (acelerar >= 0) {
			this.velocidade_atual += acelerar;
		}
	}

	public void frearVeiculo(Integer freio) {
		if (freio >= 0 && this.velocidade_atual >= freio) {
			this.velocidade_atual -= freio;
		}
	}

	public void ligarDesligarVeiculo(String op) throws InterruptedException {
		if (op.equalsIgnoreCase("ligar")) {
			if (this.velocidade_atual == 0) {
				Tratar.dormirSegundos(400L, "Ligando veiculo");
				System.out.println("Carro ligado! Vrum-vrum 🚘🚘");
				this.estado = true;
			} else {
				System.out.println("O carro ja esta ligado!");
				this.estado = true;
			}
		} else if(op.equalsIgnoreCase("desligar")) {
			if (this.velocidade_atual == 0) {
				Tratar.dormirSegundos(400L, "Desligando veiculo");
				System.out.println("Vrum... O Carro esta desligado");
				this.estado = false;
			} else {
				System.out.println("O carro ainda está em movimento!");
				this.estado = true;
			}
		}
	}

	@Override
	public String toString() {
		return "| Cor: " + getCor() + " | Modelo: " + getModelo() + " | Velocidade atual: " + getVelocidade_atual()
				+ " | Placa: " + getPlaca();
	}

}
