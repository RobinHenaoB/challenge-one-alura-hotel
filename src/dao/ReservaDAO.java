package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO {
	
	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	
	
	public void saveReserva(Reserva reserva) {
		try {
			String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, reserva.getFechaEntrada());
				pstm.setDate(2, reserva.getFechaSalida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPago());

				pstm.executeUpdate();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Reserva> listReservas() {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.execute();
				reservas=changeResultSetReserva(pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> searchIdReserva(String id) {
		List<Reserva> reserva = new ArrayList<Reserva>();
		try {

			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();
				reserva=changeResultSetReserva(pstm);
			}
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteReserva(Integer id) {
		try (PreparedStatement stm = con.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateReserva(Date fechaEntrada, Date fechaSalida, String valor, String formaPago, Integer id) {
		try (PreparedStatement stm = con
				.prepareStatement("UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id = ?")) {
			stm.setDate(1, fechaEntrada);
			stm.setDate(2, fechaSalida);
			stm.setString(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
						
	private List<Reserva> changeResultSetReserva( PreparedStatement pstm) throws SQLException {
		List<Reserva> reservas = new ArrayList<Reserva>() ;
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva produto = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(produto);
			}
			
		}
		return reservas;
	}

}
