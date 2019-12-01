package DataCentricProject;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Products {
	
	int productId;
	int storeId;
	String productName;
	double productPrice;
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getStoreId() {
		return storeId;
	}
	
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
