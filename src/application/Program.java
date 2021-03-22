package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AlugarCarro;
import model.entities.Veiculo;
import model.services.BrasilTaxaServico;
import model.services.ServicoAluguel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:ss");
		
		System.out.println("Dados do Aluguel ");
		System.out.print("Modelo do Carro: ");
		String veiculo = sc.nextLine();
		System.out.print("Retirada(dd/MM/yyyy hh:ss): ");
		Date retirada = sdf.parse(sc.nextLine());
		System.out.print("Retorno(dd/MM/yyyy hh:ss): ");
		Date retorno = sdf.parse(sc.nextLine());
		
		AlugarCarro ac = new AlugarCarro(retirada, retorno, new Veiculo(veiculo));
		
		System.out.print("Preço por Hora: ");
		double valorHora = sc.nextDouble();
		System.out.print("Preço por Dia: ");
		double valorDia = sc.nextDouble();
		
		ServicoAluguel aluguel = new ServicoAluguel(valorHora, valorDia, new BrasilTaxaServico());
		
		aluguel.processoFatura(ac);
		
		System.out.println("Fatura");
		System.out.println("Pagamento: " + String.format("%.2f", ac.getFatura().getPagamento()));
		System.out.println("Taxa: " + String.format("%.2f", ac.getFatura().getTaxa()));
		System.out.println("Pagamento com Taxa: " + String.format("%.2f", ac.getFatura().valorTotal()));
		
		sc.close();
	}

}
