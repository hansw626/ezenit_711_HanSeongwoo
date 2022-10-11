package lms;

public class Subject {
	private String title;
	private int score;
	
	Subject(String title){
		this.title = title;
	}
	
	Subject(String title, int score){
		this.title = title;
		this.score = score;
	}
	
	// Getter & Setter
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
