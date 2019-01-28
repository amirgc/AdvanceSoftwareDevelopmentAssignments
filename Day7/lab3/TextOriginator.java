package lab_08_03;

public class TextOriginator {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void loadFromMemento(TextMemento memento) {
		this.text = memento.getText();
	}

}
