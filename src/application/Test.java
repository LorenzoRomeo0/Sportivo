package application;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		DAOSportivo dao=new DAOSportivo("root","");
		List<String> sport=new ArrayList<String>();
		sport=dao.getSport();
		for(String s:sport)
			System.out.println(s);
		System.out.println("------");
		List<Sportivo> sportivo=new ArrayList<Sportivo>();
		sportivo=dao.getSportivi();
		for(Sportivo s:sportivo)
			System.out.println(s.toString());
	}

}
