package application.model;

public class Entry {
	private String word;
	private String hint;
	public Entry(String word, String hint) {
		this.word = word;
		this.hint = hint;
	}
	@Override
	public String toString() {
		String str =  word + " hint=" + hint + "";
		return str;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
}