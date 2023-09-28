package controller;

import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaController {

	private ReservaDAO reservaDao;

	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.recuperaConexion());
	}
	
	public void registrarReserva(Reserva reserva) {
		reservaDao.saveReserva(reserva);
	}
	
	public List<Reserva> buscar() {
		return this.reservaDao.listReserva();
	}
	
	public List<Reserva> buscarId(String id) {
		return this.reservaDao.searchIdReserva(id);
	}
	
	public void actualizar(Date fechaEntrada, Date fechaSalida, String valor, String formaPago, Integer id) {
		this.reservaDao.updateReserva(fechaEntrada, fechaSalida, valor, formaPago, id);
	}
	
	public void Eliminar(Integer id) {
		this.reservaDao.deleteReserva(id);
	}
	
}
