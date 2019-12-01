package manageHeadOffice;

public class StoreHeadOffice {
	
	int _id;
	String location;
	
	@Override
	public String toString() {
		return "Head Office ID: " + _id + " head office location " + location;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
