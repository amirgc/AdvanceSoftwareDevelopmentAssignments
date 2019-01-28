package lab_08_03;

import java.io.IOException;
import java.util.Stack;

import lab_08_03.utils.FileUtils;

public class TextCareTaker {

	private Stack<TextMemento> mementoStack;

	private static int MAX_SIZE = 32;

	public TextCareTaker() {
		mementoStack = new Stack<>();
	}

	public TextMemento load(String fileName) {
		try {
			String text = FileUtils.loadFromFile(fileName);
			return new TextMemento(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new TextMemento("");
	}

	public void save(String fileName, TextMemento m) {
		try {
			FileUtils.saveToFile(fileName, m.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addAction(TextMemento memento) {
		if (mementoStack.size() == MAX_SIZE) {
			mementoStack.remove(0);
		}
		mementoStack.push(memento);
	}

	public TextMemento undo() {
		if (!mementoStack.isEmpty()) {
			return mementoStack.pop();
		}
		return null;
	}

}
