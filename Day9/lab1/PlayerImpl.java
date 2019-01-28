package lab_10_01;

public class PlayerImpl extends Player {
	private ReversiMediator mediator;

	public PlayerImpl(int number, ReversiMediator mediator) {
		super(mediator, number);
	}

	@Override
	public void place(int x, int y) {
		if (mediator.place(this, x, y)) {
			setScore(getScore() + 1);
		}
	}

	@Override
	public boolean canPlace(int x, int y) {
		return mediator.canPlace(this, x, y);
	}

	@Override
	public boolean isStuck() {
		for (int i = 0; i < ReversiMediator.ROWS; i++) {
			for (int j = 0; j < ReversiMediator.COLS; j++) {
				if (mediator.canPlace(this, i, j)) {
					return true;
				}
			}
		}
		return true;
	}

}
