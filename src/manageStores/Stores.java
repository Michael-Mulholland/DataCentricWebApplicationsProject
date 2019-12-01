package manageStores;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Stores {
	
	int storeId;
	String storeName;
	String storeFounded;
	
	public Stores() {
	}
	
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


}
