package entities;

public enum ArticleType {
	VIDEO_GAME("Video Spiele"), 
	CONSOLE("Konsolen");

	private String label;

	ArticleType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}

}
