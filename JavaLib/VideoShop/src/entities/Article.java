package entities;

public class Article {
	public static int idCounter = 1;
	private int id;
	private String name;

	public Article(String name) {
		this.name = name;
		this.id = Article.idCounter++;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + ',' + "Name: " + this.name;
	}
}
