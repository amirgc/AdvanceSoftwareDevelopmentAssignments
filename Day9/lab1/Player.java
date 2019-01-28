package lab_10_01;

public abstract class Player {
	private ReversiMediator mediator;
	private int number;
	private int score;

	public abstract void place(int x, int y);

	public abstract boolean canPlace(int x, int y);

	public abstract boolean isStuck();

	public Player(ReversiMediator mediator, int number) {
		this.mediator = mediator;
		this.number = number;
		this.score = 0;
	}

	public int getNumber() {
		return number;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}

	public void updateScore(int total) {
		if (score + total >= 0 && score + total <= 64) {
			score += total;
		}
	}
}
