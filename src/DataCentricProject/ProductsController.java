package DataCentricProject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	
	
	
	
}
