package DataCentricProject;

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

}
