package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;;

public class DAOSportivo {

	private final String DBUrl = "jdbc:mysql://localhost/Sportivi?serverTimezone=UTC";
	private String user;
	private String passw;
	private Connection c=null;
	
	public DAOSportivo(String user, String passw) {
		this.user = user;
		this.passw = passw;
		//connectDB();
	}
	private void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			if (c==null) c=DriverManager.getConnection(DBUrl,user,passw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDB() {
		try {
			c.close();
			c=null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

	public List<Sportivo> getSportivi() {
		List<Sportivo> lp=new ArrayList<Sportivo>();
		connectDB();
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT Nome, Cognome, Codice, Disciplina FROM sportivi");
			while (rs.next()) {
				Sportivo p=new Sportivo(rs.getString("Nome"),rs.getString("Cognome"),rs.getString("Codice"),rs.getString("Disciplina"));
				lp.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeDB();
		return lp;
}
	
	public List<String> getSport() {
		List<String> lp=new ArrayList<String>();
		connectDB();
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT Nome FROM sport");
			while (rs.next()) {
				lp.add(rs.getString("Nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeDB();
		return lp;
	}





}
