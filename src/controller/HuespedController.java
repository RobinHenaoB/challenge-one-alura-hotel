package controller;

import java.sql.Date;
import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;

public class HuespedController {
	
	private HuespedDAO huespedDao;

	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.recuperaConexion());
	}
	
	
	public void registerHuesped(Huesped huesped) {
		huespedDao.saveHuesped(huesped);
	}
	
	public List<Huesped> listHuespedes() {
		return this.huespedDao.listHuespedes();
	}
	
	public List<Huesped> searchIdHuesped(String id) {
		return this.huespedDao.searchIdHuesped(id);
	}
	
	public void updateHuesped(String nombre, String apellido, Date fechaNacimineto, String nacionalidad, String telefono, Integer reservaId, Integer id) {
		this.huespedDao.updateHuesped(nombre, apellido, fechaNacimineto, nacionalidad, telefono, reservaId, id);
	}
	
	public void deleteHuesped(Integer id) {
		this.huespedDao.deleteHuesped(id);
	}
}
