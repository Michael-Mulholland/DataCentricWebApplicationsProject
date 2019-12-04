package manageStoresProducts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@ManagedBean
@SessionScoped
public class StoresProductsDAO {
	
	DataSource mysqlDS;
	
	public StoresProductsDAO() throws Exception {
		// gets all the collections together
		// pool of collections
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
		
	public ArrayList<StoresProducts> loadStoreProductDetails() throws Exception {
		
		StoresProducts s = new StoresProducts();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		// Query
		String sql = "select s.id, s.name, s.founded, p.pid, p.prodName, p.price from store s inner join product p on s.id = p.sid where s.id";

		System.out.println(sql);
		
		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		// ArrayList to store all Products
		ArrayList<StoresProducts> storesProducts = new ArrayList<>();
		
		// process result set
		while (myRs.next()) {
			// new instance of Product
			StoresProducts sp = new StoresProducts();
						
			sp.setStoreId(myRs.getInt("id"));
			sp.setStoreName(myRs.getString("name"));
			sp.setStoreFounded(myRs.getString("founded"));
			sp.setProductId(myRs.getInt("pid"));
			sp.setProductName(myRs.getString("prodName"));
			sp.setProductPrice(myRs.getDouble("price"));
			
			// add prodid and productDescrip to the ArrayList
			storesProducts.add(sp);
		}	
		
		// return the products
		return storesProducts;
	}
}
