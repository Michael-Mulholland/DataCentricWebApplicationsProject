package manageProducts;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import manageStores.Stores;

public class ProductDAO {
	
	DataSource mysqlDS;

	public ProductDAO() throws Exception {
		// gets all the collections together
		// pool of collections
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	public ArrayList<Products> loadProductDetails() throws Exception {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		// Query
		String sql = "select * from product";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		// ArrayList to store all Products
		ArrayList<Products> product = new ArrayList<>();
		
		// process result set
		while (myRs.next()) {
			// new instance of Product
			Products p = new Products();
			
			// store prodid and productDescrip
			p.setProductId(myRs.getInt("pid"));
			p.setStoreId(myRs.getInt("sid"));
			p.setProductName(myRs.getString("prodName"));
			p.setProductPrice(myRs.getDouble("price"));
						
			// add prodid and productDescrip to the ArrayList
			product.add(p);
		}	
		
		// return the products
		return product;
	}
	
	// Adds a product to the database
	public void addProduct(Products products) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into product (sid, prodName, price) values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, products.getStoreId());
		myStmt.setString(2, products.getProductName());
		myStmt.setDouble(3, products.getProductPrice());
		// syso for error checking
		// prints out in console - Then copy and try in mySQL
		myStmt.execute();			
	}

	public void delete(int productID) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from product where pid = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, productID);
		myStmt.execute();			
	}
}
