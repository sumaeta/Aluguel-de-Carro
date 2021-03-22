package model.services;

import model.entities.AlugarCarro;
import model.entities.Fatura;

public class ServicoAluguel {
	private Double valorHora;
	private Double valorDia;
	
	private TaxaServico taxa;

	public ServicoAluguel(Double valorHora, Double valorDia, TaxaServico taxa) {
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.taxa = taxa;
	}

	
	public void processoFatura(AlugarCarro alugarCarro) {
		long t1 = alugarCarro.getRetirada().getTime();
		long t2 = alugarCarro.getRetorno().getTime();
		
		double horas = (double)(t2-t1) / 1000 / 60 /60;
		
		double pagamento;
		
		if(horas <= 12.0) {
			pagamento = Math.ceil(horas) * valorHora;
		}else {
			pagamento = Math.ceil(horas/ 24)  * valorDia;
		}
		
		double tax = taxa.taxa(pagamento);
		
		alugarCarro.setFatura(new Fatura(pagamento, tax));
	}
}
