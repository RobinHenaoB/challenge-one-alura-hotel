package model;

import java.sql.Date;

public class Reserva {
	private Integer id;

	private Date FechaEntrada;

	private Date fechaSalida;

	private String valor;

	private String FormaPago;
	
	
	public Reserva(Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		super();
		FechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		FormaPago = formaPago;
	}

	public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		super();
		this.id = id;
		FechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		FormaPago = formaPago;
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getFechaEntrada() {
		return FechaEntrada;
	}



	public void setFechaEntrada(Date fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}



	public Date getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public String getFormaPago() {
		return FormaPago;
	}



	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"{ id: %d, fechaEntrada: %s, fechaSalida: %s, valor: %s, formaPago: %s}",
				this.id, this.FechaEntrada, this.fechaSalida, this.valor, this.FormaPago);
	}
}	