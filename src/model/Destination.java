package model;

public class Destination {
	private int id;
    private String name;
    private String description;
    private int city_id;
    private int category;
    private String cost_level;
    private String imagePath;
    
    public Destination(int id, String name, String description, int city_id, int category, String cost_level,
			String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.city_id = city_id;
		this.category = category;
		this.cost_level = cost_level;
		this.imagePath = imagePath;
	}
  
    public int getCity_id() {
		return city_id;
	}

	public String getCost_level() {
		return cost_level;
	}

	public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

