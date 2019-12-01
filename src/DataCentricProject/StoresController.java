package DataCentricProject;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StoresController {
	// stores products returned from DAO class
	ArrayList<Stores> stores;
	
	// instance of DAO
	StoresDAO dao;

	public StoresController() {
		super();
		
		try {
			// new instance of DAO class
			dao = new StoresDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loadStoreDetails() {
		
		// pass call onto dao in the StoresDAO class
		try {
			// dao returns an ArrayList of stores and saves them to stores which is created above
			stores = dao.loadStoreDetails();			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public ArrayList<Stores> getStores() {
		return stores;
	}
	
	// sends product to a method in DAO
	public String addStore(Stores s) {
		System.out.println(s.getStoreName() + " " + s.getStoreFounded());
		try {
			dao.addStore(s);
			return "index"; // when ok button pressed on addStore page - returns to the index page
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage("Error: Store name already exists");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null; // if an exception, stays on the same page
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; // if an exception, stays on the same page
		}
	}
	
	// delete a product from the database
	public void delete(int storeId){
		System.out.println("Delete store with ID: " + storeId);
		
		try {
			dao.delete(storeId);		
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
