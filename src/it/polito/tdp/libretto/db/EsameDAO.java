package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	
	private final String jdbcURL = "jdbc:mysql://localhost/libretto?user=root&password=root"
			 + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


	public Esame find(String codice) {
		String sql = "SELECT codice, titolo, docente, superato, voto, data_superamento " + "FROM esame "
				+ "WHERE codice=?;";
//		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root&password=root"
//					 + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Esame result = null;
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, codice);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				Esame esame = new Esame(res.getString("codice"),
						res.getString("titolo"),
						res.getString("docente"));
				//TODO estrarre voto e data_superamento !!
				result = esame;
			}else {
				result = null;
			}
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean create(Esame e){
		String sql = "INSERT INTO `libretto`.`esame` (`codice`, `titolo`, `docente`) VALUES (?, ?, ?);";
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getCodice());
			ps.setString(2, e.getTitolo());
			ps.setString(3, e.getDocente());
			
			int result = ps.executeUpdate();
			conn.close();
			return true;
		} catch(SQLIntegrityConstraintViolationException sqlex) {
			return false;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
}
