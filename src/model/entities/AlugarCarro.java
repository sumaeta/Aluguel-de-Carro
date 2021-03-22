package model.entities;

import java.util.Date;

public class AlugarCarro {

	private Date retirada;
	private Date retorno;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AlugarCarro() {
	}

	public AlugarCarro(Date retirada, Date retorno, Veiculo veiculo) {
		this.retirada = retirada;
		this.retorno = retorno;
		this.veiculo = veiculo;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getRetorno() {
		return retorno;
	}

	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
}
