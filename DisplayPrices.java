package NewspaperApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class DisplayPrices 
{
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner in = new Scanner(System.in);
	
	public static boolean DisplayPrices()
	{
		String str = "SELECT * from publication";
		try{
			 rs = stmt.executeQuery(str);
			while(rs.next())
			{
				 String newspaper = rs.getString("newspaper");
				 double price = rs.getDouble("price");
				 System.out.println(newspaper+" "+price);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception occured" +e);
		}
		return false;
	}
	
/*	public static void main(String [] args)
	{
		DisplayPrices();
	} */
}
