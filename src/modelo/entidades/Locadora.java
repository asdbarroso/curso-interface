package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locadora {

	private Date dataEntrada;
	private Date dataSaida;
	private String modeloCarro;
	private Double valorHora;
	private Double ValorDia;

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Locadora(Date dataEntrada, Date dataSaida, String modeloCarro, Double valorHora, Double valorDia) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.modeloCarro = modeloCarro;
		this.valorHora = valorHora;
		ValorDia = valorDia;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Double getValorDia() {
		return ValorDia;
	}

	public void setValorDia(Double valorDia) {
		ValorDia = valorDia;
	}

	public long duracaoAluguel() {
		long diff = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public double pagamentoBasico() {

		if (duracaoAluguel() < 12) {
			return (duracaoAluguel() + 1) * valorHora;
		} else {
			return (duracaoAluguel()/24 + 1) * ValorDia;
		}

	}

	public double taxa() {

		if (pagamentoBasico() < 100.00) {
			return pagamentoBasico() * 0.20;
		} else {
			return pagamentoBasico() * 0.15;
		}

	}

	public double pagamentoTotal() {

		return pagamentoBasico() + taxa();

	}

	@Override
	public String toString() {
		return "Pagamento Basico: " 
				+ String.format("%.2f\n", pagamentoBasico())
				+ "Taxa: "
				+ String.format("%.2f\n", taxa())
				+ "Pagamento Total: "
				+ String.format("%.2f", pagamentoTotal());
	}
}
