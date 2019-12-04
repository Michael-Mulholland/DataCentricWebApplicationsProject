package manageHeadOffice;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StoreHeadOffice {
	
	int id;
	String location;
	
	@Override
	public String toString() {
		return "Head Office ID: " + id + " head office location " + location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
