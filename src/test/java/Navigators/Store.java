package Navigators;

public class Store {
	private int id;
	private int managerId;
	private int addressId;

	public Store(int id, int addressId, int managerId) {
		this.id = id;
		this.managerId = managerId;
		this.addressId = addressId;
	}

	public int getDescription() {
		return addressId;
	}

	public int getId() {
		return id;
	}

	public int getTitle() {
		return managerId;
	}
}
