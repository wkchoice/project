package db.entity;

public class Department {
	private int id;
	private String name;
	private Integer manager_id;
	private Integer location_id;
	
	public Department() { }
	
	public Department(int id, String name, Integer manager_id, Integer location_id) {
		super();
		this.id = id;
		this.name = name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
}
