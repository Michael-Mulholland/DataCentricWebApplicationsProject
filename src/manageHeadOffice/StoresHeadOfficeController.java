package manageHeadOffice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mongodb.MongoWriteException;

import manageProducts.Products;
import manageStores.Stores;

@ManagedBean
@SessionScoped
public class StoresHeadOfficeController {
	// stores products returned from DAO class
	ArrayList<StoreHeadOffice> storeHeadOffice;
	
	// instance of DAO
	MongoDAO dao;
	
	public StoresHeadOfficeController() {
		super();
		
		try {
			// new instance of DAO class
			dao = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loadOfficeDetails() {		
		// pass call onto dao in the ProductDAO class
		try {
			// dao returns an ArrayList of products and saves them to products which is created above
			storeHeadOffice = dao.loadOfficeDetails();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<StoreHeadOffice> getStoreHeadOffice() {
		return storeHeadOffice;
	}
	
	public String addHeadOffice(StoreHeadOffice office, int id) {

		try {
			// if in mysql db then do below
			//boolean result = mysqlDao.checkMysqlId(id);
			dao.addHeadOffice(office);
	
			return "manageHeadOffices"; // when ok button pressed on addStore page - returns to the index page
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			//MySQL ERROR HERE=====================================================================================================
			//FacesMessage message = new FacesMessage("Error: Store ID "+ office.getId() + " does not exist");
			//FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
			return null; // if an exception, stays on the same page
		}
		catch (MongoWriteException e) {
			FacesMessage message = new FacesMessage("Error: Store ID: "+ office.getId() + " already has location");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.printStackTrace();
			return null; // if an exception, stays on the same page
		} 
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
