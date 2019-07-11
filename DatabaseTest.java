package NewspaperApp;
import junit.framework.TestCase;

public class DatabaseTest extends TestCase {

	// Test #:1 
	// Objective : valid data base connection software should still run 
	// input(s) : correct    
	// expected : return true
	public void TestDatabase0001()
	{
		
		Database Data = new Database();
		String password = "ronnie123"; 
		String url="jdbc:mysql://localhost:3306/newspaper";
		assertEquals(Database.init_db(url,password),true);		
	}	
	
	
	// Test #:2
	// Objective : invalid data base connection software should still run 
	// input(s) : correct password
	// expected : return false
	public void TestDatabase0002()
	{
		Database Data = new Database();
		
		String password = "ronnie12"; 
		String url="jdbc:mysql://localhost:3306/newspaper";
		assertEquals(Database.init_db(url,password),false);		
	}	
	
	// Test #:3
	// Objective : invalid data base connection software should still run 
	// input(s) : correct url Link   
	// expected : return false
	public void TestDatabase0003()
	{
		Database Data = new Database();
		
		String password = "ronnie123"; 
		String url="jdbc:mysql://localhost:3306/newspapers";
		assertEquals(Database.init_db(url,password),false);		
	}
		
	// Test #:4 
	// Objective : fail to store a SQL execution command  
	// input(s) :  "INSERT INTO customer VALUES (NULL, 'John', 'Doe', , '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00)";
	// expected : false
	// method : CreateCustomerRecord(DatabaseInputString)
	public void TestDatabase0004()
	{
		Database Data = new Database();
		
		String password = "ronnie123"; 
		String url="jdbc:mysql://localhost:3306/newspaper";
		String Str="INSERT INTO customer VALUES (NULL, 'John', 'Doe', , '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00)"; 
		Database.init_db(url,password);	
		boolean result = Database.CreateCustomerRecord(Str);
		assertEquals(result,false);	
	}
	
	// Test #:5 
	// Objective : store a SQL execution command  
	// input(s) : "INSERT INTO customer VALUES (NULL, 'John', 'Doe', 'Mr', '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00)"; 
	// expected : false
	// method : CreateCustomerRecord(DatabaseInputString)
	public void TestDatabase0005()
	{
		Database Data = new Database();
		
		String password = "admin"; 
		String url="jdbc:mysql://localhost:3306/newspaper";
		String Str="INSERT INTO customer VALUES (NULL, 'John', 'Doe', , '7 Monksfield Park', 'Monksland', 'Athlone', 'Co.Roscommon', 'N37Y0X3', 0.00)"; 
		Database.init_db(url,password);	
		boolean result = Database.CreateCustomerRecord(Str);
		assertEquals(result,false);	
	}
	
	// Test #:6
	// Objective :  display prices   
	// input(s) :  "SELECT * from publication";
	// expected : false
	public void TestDatabase006()
	{
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/newspaper";
		String str = "SELECT * from publication";
		Database.init_db(url, password);
		boolean result = Database.DisplayPrices();
		assertEquals(result,false); 		
	}
	
	// Test #:7
	// Objective :  display prices   
	// input(s) :  "SELECT * from publication";
	// expected : true
	public void TestDatabase007()
	{
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/newspaper";
		String str = "SELECT * from publication";
		Database.init_db(url, password);
		boolean result = Database.DisplayPrices();
		assertEquals(result,true); 		
	}
}