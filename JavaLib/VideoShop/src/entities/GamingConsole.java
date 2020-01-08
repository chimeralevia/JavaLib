package entities;

public class GamingConsole extends Article {
	private static ArticleStorage<GamingConsole> storage = new ArticleStorage<>(10);
	private Manufacturer manufacturer;

	public GamingConsole(String name, Manufacturer manufacturer) {
		super(name);
		this.manufacturer = manufacturer;
	}

	public static ArticleStorage<GamingConsole> getStorage() {
		return storage;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	@Override
	public String toString() {
		return super.toString() + ", Hersteller: " + this.manufacturer;
	}
}
