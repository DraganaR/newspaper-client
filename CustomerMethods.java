package NewspaperApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class CustomerMethods 
{
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner in = new Scanner(System.in);
	
	public void removeCustomer() throws CustomerExceptionHandler
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Choose a customer ID to remove: ");
		int answer = in.nextInt();
		
		String str = "SELECT count(*) from customer where cus_id = '" +answer+"'";
        try
        { 
	        ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
	        
        	int cus_id = 0;
            rs = stmt.executeQuery(str); 
            while (rs.next()) 
            { 
                cus_id = rs.getInt(1); 
            }             	    
            
            if(cus_id > 0)
            {
            	str = "Delete * from customers where cus_id  = '" +answer+"'";
            	try
            	{
            		stmt.executeUpdate(str);
            	}
                catch (SQLException sqle) 
                { 
                    System.out.println("Error: failed to display all customers."); 
                    System.out.println(sqle.getMessage());
                    System.out.println(str);
                } 
            }
            else 
            {
             System.out.println("You put an invalid number in. ");
            }
        } 
        catch (SQLException sqle) 
        { 
            System.out.println("Error: failed to display all products."); 
            System.out.println(sqle.getMessage());
            System.out.println(str);
        } 
	}
	
	public static void displayCustomerRecords() throws CustomerExceptionHandler
	{
		/*try 
		{
			Class.forName("jdbc:mysql://localhost:3306/newspaper");
	    } 
		  catch(ClassNotFoundException e) 
		  {
	         System.out.println("Class not found "+ e);
	      }*/
		 String str = "Select * from customer";
		 try 
		 {
	         // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newspaper","username", "admin");
	         // Statement stmt = (Statement) con.createStatement();
	         // ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

			 rs = stmt.executeQuery(str);

	         while (rs.next()) 
	         {
	             int cus_id = rs.getInt("cus_id");
	             String first_name = rs.getString("first_name");
	             String last_name = rs.getString("last_name");
	             String title = rs.getString("title");
	             String address1  = rs.getString("address1");
	             String address2 = rs.getString("address2");
	             String town = rs.getString("town");
	             String county = rs.getString("county");
	             String eircode = rs.getString("eircode");
	             double balance = rs.getDouble("balance");
	             System.out.println(cus_id+"   "+first_name+"    "+last_name+"   "+title+"   "+address1+"   "+address2+"   "
	            		 +town+"   "+county+"   "+eircode+"   "+balance);
	         }
         }
         catch(SQLException e)
         {
        	 System.out.println("Exception occured" +e);
         }
	}
	
	public void modifyCustomer() throws CustomerExceptionHandler, SQLException
	{
		Scanner in = new Scanner (System.in);
		System.out.println("Choose a customer ID to modify: ");
		int answer = in.nextInt();
		
		String str = "SELECT count(*) from customer where cus_id = '" +answer+"'";
		
		System.out.println("Enter line 1 of new Address");
		String address1 = in.nextLine();
		String a = "Updating address..";
		stmt.executeUpdate(a);
		System.out.println("Enter line 2 of new Address");
		String address2 = in.nextLine();
		String ad = "Updating address..";
		stmt.executeUpdate(ad);
		System.out.println("Enter new town");
		String town = in.nextLine();
		String t = "Updating address..";
		stmt.executeUpdate(t);
		System.out.println("Enter new county");
		String county = in.nextLine();
		String c = "Updating address..";
		stmt.executeUpdate(c);
		System.out.println("Enter new eircode");
		String eircode = in.nextLine();
		String e = "Updating address..";
		stmt.executeUpdate(e);

	}
}
