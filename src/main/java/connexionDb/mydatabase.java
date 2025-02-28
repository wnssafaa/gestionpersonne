package connexionDb;

import java.sql.Connection;
import java.sql.DriverManager;

public class mydatabase {
	public static Connection getConnextion() {
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/personne";
		String user = "root";
		String passwd = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.print("Driver ok");
			connection = DriverManager.getConnection(url,user,passwd);
			System.out.print("Connextion effective");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
