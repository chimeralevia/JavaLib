package entities;

public class VideoGame extends Article {
	private static ArticleStorage<VideoGame> storage = new ArticleStorage<>(Integer.MAX_VALUE);
	private int ageRestriction;
	private Genre genre;

	public VideoGame(String name, int ageRestriction, Genre genre) {
		super(name);
		this.ageRestriction = ageRestriction;
		this.genre = genre;
	}

	public static ArticleStorage<VideoGame> getStorage() {
		return storage;
	}

	public int getAgeRestriction() {
		return this.ageRestriction;
	}

	public Genre getGenre() {
		return this.genre;
	}

	@Override
	public String toString() {
		return super.toString() + ", Genre: " + this.genre + ", Altersfreigabe: " + this.ageRestriction;
	}
}
