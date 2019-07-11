package NewspaperApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner in = new Scanner(System.in);

	/**opens the data base 
	 * 
	 * @param url - the SQL data base location 
	 * @param Password - the password to access the data base  
	 * @return false if it fails true if it passes 
	 */
	
	public static boolean init_db(String url,String  Password)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
 
			con = DriverManager.getConnection(url, "root", Password);

			stmt = con.createStatement();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * Closes the database when finished - joe Smith  
	 */
	public static void cleanup_resources()
	{
		try
		{
			con.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Error: failed to close the database");
		}
	}
	
/** creates a database entry to store a new record in database 
 * - Joe Smith 
 * @param DatabaseInputString  - the string to be entered into the command 
 * @return - @return false if it fails true if it passes 
 */
	public static Boolean CreateCustomerRecord(String DatabaseInputString)
	{
		try
		{		
			
			int rs = stmt.executeUpdate(DatabaseInputString);
	          
	          System.out.println("*** record updated ***");
	        } 
	        catch (SQLException sqle) 
	        { 
	            System.out.println("Error: failed to create the product record"); 
	        } 
		return false;	
	}


	public static int getTheLastRecordNumber() 
	{ 		
		try
		{
			 ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			 int cus_id = 0;
			 
			 while (rs.next()) {
				cus_id = rs.getInt(1);
			} 
			 if (cus_id==0)
			 {
				 return 1001;
			 }
			 else 
			 {
				 return  cus_id+1;
			 }
		}
		catch (SQLException sqle)
		{			
			System.out.println("Error: failed to get number of records ");
		}	
		return 1001;
	}
	
	/* public static void Staff_delivery_round(int Staff_main)
	{
		INSERT INTO customer VALUES (NULL, 'John', 'Doe', 'Mr', '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00);
	} */
	
	public static void Staff_main()
	{
		// return staff ref
	}


	public static boolean blockPaperFromCustomer(String customerId) {
		
		return false;
	}
	
	public static boolean DisplayPrices() 
	{
		String str = "SELECT * from publication";
		try{
			rs = stmt.executeQuery(str);
			while(rs.next())
			{
				 String newspaper = rs.getString(2);
				 double price = rs.getDouble(3);
				 System.out.println(newspaper+" "+price);
			}
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Exception occured" +e);
		}
		return false;
	}

}




