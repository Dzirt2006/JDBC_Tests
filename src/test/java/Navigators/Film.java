package Navigators;

public class Film {
	private int id;
	private String title;
	private String description;

	public Film(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
}
