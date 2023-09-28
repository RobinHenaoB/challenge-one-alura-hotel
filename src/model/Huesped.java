package model;

import java.sql.Date;

public class Huesped {
	
	private Integer id;

	private String nombre;

	private String apellido;

	private Date nacimiento;

	private String nacionalidad;

	private String telefono;

	private int reservaId;

	


	public Huesped(String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono,
			int reservaId) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservaId = reservaId;
	}




	public Huesped(Integer id, String nombre, String apellido, Date nacimiento, String nacionalidad, String telefono,
			int reservaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservaId = reservaId;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public Date getNacimiento() {
		return nacimiento;
	}




	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public int getReservaId() {
		return reservaId;
	}




	public void setReservaId(int reservaId) {
		this.reservaId = reservaId;
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"{ id: %d, nombre: %s, apellido: %s, nacimiento: %s, nacionalidad: %s, telefono: %s, reservaId: %d }",
				this.id, this.nombre, this.apellido, this.nacimiento, this.nacionalidad, this.telefono, this.reservaId);
	}

}
