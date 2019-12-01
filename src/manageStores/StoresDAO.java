package manageStores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StoresDAO {
	
	DataSource mysqlDS;
	
	public StoresDAO() throws Exception {
		// gets all the collections together
		// pool of collections
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
		
	public ArrayList<Stores> loadStoreDetails() throws Exception {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		// Query
		String sql = "select * from store";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		// ArrayList to store all Products
		ArrayList<Stores> stores = new ArrayList<>();
		
		// process result set
		while (myRs.next()) {
			// new instance of Product
			Stores s = new Stores();
			
			// store prodid and productDescrip
			s.setStoreId(myRs.getInt("id"));
			s.setStoreName(myRs.getString("name"));
			s.setStoreFounded(myRs.getString("founded"));
			
			// add prodid and productDescrip to the ArrayList
			stores.add(s);
		}	
		
		// return the products
		return stores;
	}
	
	// Adds a store to the database
	public void addStore(Stores store) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store (name, founded) values (?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, store.getStoreName());
		myStmt.setString(2, store.getStoreFounded());
		// syso for error checking
		// prints out in console - Then copy and try in mySQL
		System.out.println(myStmt);
		myStmt.execute();			
	}
	
	public void delete(int storeID) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from store where id = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, storeID);
		System.out.println(myStmt);
		myStmt.execute();			
	}
	
}
