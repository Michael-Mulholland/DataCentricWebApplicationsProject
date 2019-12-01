package manageProducts;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import manageStores.Stores;

@ManagedBean
@SessionScoped
public class ProductsController {
	
	// stores products returned from DAO class
	ArrayList<Products> products;
	
	// instance of DAO
	ProductDAO dao;

	public ProductsController() {
		super();
		
		try {
			// new instance of DAO class
			dao = new ProductDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loadProductDetails() {		
		// pass call onto dao in the ProductDAO class
		try {
			// dao returns an ArrayList of products and saves them to products which is created above
			products = dao.loadProductDetails();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	//???????????????????????????????????????????????????????????
	public ArrayList<Products> getProducts() {
		return products;
	}
	
	// sends product to a method in DAO
	public String addProduct(Products p) {
		//System.out.println(s.getStoreName() + " " + s.getStoreFounded());
		try {
			dao.addProduct(p);
			return "manageProducts"; // when ok button pressed on addStore page - returns to the index page
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			//FacesMessage message = new FacesMessage("Error: Product "+ p.getProductName() + " already exists");
			//FacesContext.getCurrentInstance().addMessage(null, message);
			return null; // if an exception, stays on the same page
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; // if an exception, stays on the same page
		}
	}
	
	// delete a product from the database
	public void delete(int productID){
		//System.out.println("Delete store with ID: " + storeId);
		
		try {
			dao.delete(productID);		
		} catch (Exception e) {
			//FacesMessage message = new FacesMessage("Error: Store "+ storeName + " has not been deleted from MySQL DB, it contains products");
			//FacesContext.getCurrentInstance().addMessage(null, message);
		}	
	}
	
}
