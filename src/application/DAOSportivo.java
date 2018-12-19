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
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
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

	
	public boolean setSport(String sport) {
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("INSERT INTO sport(nome) VALUES (?)");
			s.setString(1, sport);
			s.executeUpdate();
			closeDB();
			return true;
		} catch (SQLException e) {
			System.out.println("Errore inserimento sport");
			e.printStackTrace();
			closeDB();
			return false;
		}
}

	public boolean setSportivo(Sportivo sportivo) {
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("INSERT INTO sportivi(nome, cognome, codice, disciplina) VALUES (?,?,?,?)");
			s.setString(1, sportivo.getNome());
			s.setString(2, sportivo.getCognome());
			s.setString(3, sportivo.getCodiceFiscale());
			s.setString(4, sportivo.getDisciplina());
			s.executeUpdate();
			closeDB();
			return true;
		} catch (SQLException e) {
			System.out.println("Errore inserimento sportivo");
			e.printStackTrace();
			closeDB();
			return false;
		}
}
	public boolean delSport(String sport) {
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("DELETE FROM sport WHERE nome=?");
			s.setString(1, sport);
			s.executeUpdate();
			closeDB();
			return true;
		} catch (SQLException e) {
			System.out.println("Errore eleminiazione sport");
			e.printStackTrace();
			closeDB();
			return false;
		}
}
	
	public boolean delSportivo(String codiceFiscale) {
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("DELETE FROM sportivi WHERE codice=?");
			s.setString(1, codiceFiscale);
			s.executeUpdate();
			closeDB();
			return true;
		} catch (SQLException e) {
			System.out.println("Errore eliminazione sportivo");
			e.printStackTrace();
			closeDB();
			return false;
		}
}
	
	public List<Sportivo> getSportivi(String disciplina) {
		List<Sportivo> lp=new ArrayList<Sportivo>();
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("SELECT Nome, Cognome, Codice, Disciplina FROM sportivi WHERE disciplina=?");
			s.setString(1, disciplina);
			ResultSet rs=s.executeQuery();
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


}
