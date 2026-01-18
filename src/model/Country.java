package model;

public class Country {
	private int id;
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}