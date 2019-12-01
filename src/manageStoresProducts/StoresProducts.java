package manageStoresProducts;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StoresProducts {
	
	// store variables
	int storeId;
	String storeName;
	String storeFounded;
	
	// product variables
	int productId;
	String productName;
	double productPrice;
	
	public int getStoreId() {
		return storeId;
	}
	
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getStoreFounded() {
		return storeFounded;
	}
	
	public void setStoreFounded(String storeFounded) {
		this.storeFounded = storeFounded;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
