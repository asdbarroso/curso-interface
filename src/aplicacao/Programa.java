package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Locadora;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date dataInicial;
		Date dataFinal;

		System.out.println("Entre com os dados da locação:");
		System.out.print("Modelo Veiculo: ");
		String modelo = sc.nextLine();
		Date entrada = null;
		Date saida = null;
		try {
			System.out.print("Saida: ");
			entrada = sdf.parse(sc.nextLine());
			System.out.print("Entrada: ");
			saida = sdf.parse(sc.nextLine());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		System.out.print("Informar o preço por horas: ");
		double valorHora = sc.nextDouble();
		System.out.print("Informar o preço por dias: ");
		double valorDia = sc.nextDouble();
		System.out.println();
		
		Locadora locadora = new Locadora(entrada, saida, modelo, valorHora, valorDia);
		System.out.println("DADOS VALOR LOCAÇÃO: ");
		System.out.println(locadora);

	}

}
