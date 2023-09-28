package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaController {

	private ReservaDAO reservaDao;

	public ReservaController() {
		Connection con = new ConnectionFactory().recuperaConexion();
		this.reservaDao = new ReservaDAO(con);
	}
	
	public void registerReserva(Reserva reserva) {
		reservaDao.saveReserva(reserva);
	}
	
	public List<Reserva> listReservas() {
		return this.reservaDao.listReservas();
	}
	
	public List<Reserva> searchIdReserva(String id) {
		return this.reservaDao.searchIdReserva(id);
	}
	
	public void updateReserva(Date fechaEntrada, Date fechaSalida, String valor, String formaPago, Integer id) {
		this.reservaDao.updateReserva(fechaEntrada, fechaSalida, valor, formaPago, id);
	}
	
	public void deleteReserva(Integer id) {
		this.reservaDao.deleteReserva(id);
	}
	
}
