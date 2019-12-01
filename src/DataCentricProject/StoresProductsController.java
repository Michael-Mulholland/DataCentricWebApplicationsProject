package DataCentricProject;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StoresProductsController {
	
	// stores products returned from DAO class
	ArrayList<StoresProducts> storesProducts;
	
	// instance of DAO
	StoresProductsDAO dao;

	public StoresProductsController() {
		super();
		
		try {
			// new instance of DAO class
			dao = new StoresProductsDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loadStoreProductDetails() {
		
		// pass call onto dao in the StoresDAO class
		try {
			// dao returns an ArrayList of stores and saves them to stores which is created above
			storesProducts = dao.loadStoreProductDetails();			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public ArrayList<StoresProducts> getStoresProducts() {
		return storesProducts;
	}

}
