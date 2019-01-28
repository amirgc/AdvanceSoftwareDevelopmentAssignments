package lab_10_01;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a Reversi game logic
 *
 */
public class ReversiMediatorImpl implements ReversiMediator, Subject {

	private Player firstPlayer;
	private Player secondPlayer;
	private int[][] boardData;

	/**
	 * Only need one observer
	 */
	private Observer observer;

	private static String DIRECTION_RIGHT = "right";
	private static String DIRECTION_LEFT = "left";
	private static String DIRECTION_UP = "up";
	private static String DIRECTION_DOWN = "down";
	private static String DIRECTION_UPPER_RIGHT = "upper_right";
	private static String DIRECTION_UPPER_LEFT = "upper_left";
	private static String DIRECTION_LOWER_RIGHT = "lower_right";
	private static String DIRECTION_LOWER_LEFT = "upper_right";

	private static int PLAYER_VALUE_1 = 1;
	private static int PLAYER_VALUE_2 = 2;
	private int turn;

	public ReversiMediatorImpl(Observer observer) {
		this.observer = observer;
		this.firstPlayer = new PlayerImpl(PLAYER_VALUE_1, this);
		this.secondPlayer = new PlayerImpl(PLAYER_VALUE_2, this);
		boardData = new int[ROWS][COLS];
	}

	public void setFirstPlayer(Player player) {
		this.firstPlayer = player;
	}

	public void setSecondPlayer(Player player) {
		this.secondPlayer = player;
	}

	@Override
	public boolean place(Player player, int row, int col) {
		if (boardData[row][col] == 0) {
			Point placingPoint = new Point(row, col);
			Map<String, Point> flipPoints = getFlipPoints(player.getNumber(), placingPoint);
			if (!flipPoints.isEmpty()) {
				if (player.equals(firstPlayer)) {
					boardData[row][col] = STONE_FIRST_PLAYER;
					turn = secondPlayer.getNumber();
				} else {
					boardData[row][col] = STONE_SECOND_PLAYER;
					turn = firstPlayer.getNumber();
				}
				flip(player.getNumber(), flipPoints, placingPoint);
				firstPlayer.setScore(calculateScore(firstPlayer.getNumber()));
				secondPlayer.setScore(calculateScore(secondPlayer.getNumber()));

				notifyObservers();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private int calculateScore(int number) {
		int score = 0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (boardData[i][j] == number) {
					score++;
				}
			}
		}
		return score;
	}

	private int flip(int myNumber, Map<String, Point> flipPoints, Point placingPoint) {
		Point endPoint;
		int i, j;
		int total = 0;
		/**
		 * right
		 */
		if (flipPoints.containsKey(DIRECTION_RIGHT)) {
			endPoint = flipPoints.get(DIRECTION_RIGHT);
			i = placingPoint.getRow();
			j = placingPoint.getCol() + 1;
			for (; j < endPoint.getCol(); j++) {
				boardData[i][j] = myNumber;
				total++;
			}
		}

		/**
		 * up
		 */
		if (flipPoints.containsKey(DIRECTION_UP)) {
			endPoint = flipPoints.get(DIRECTION_UP);
			i = placingPoint.getRow() - 1;
			j = placingPoint.getCol();
			for (; i > endPoint.getRow(); i--) {
				boardData[i][j] = myNumber;
				total++;
			}
		}

		/**
		 * left
		 */
		if (flipPoints.containsKey(DIRECTION_LEFT)) {
			endPoint = flipPoints.get(DIRECTION_LEFT);
			i = placingPoint.getRow();
			j = placingPoint.getCol() - 1;
			for (; j > endPoint.getCol(); j--) {
				boardData[i][j] = myNumber;
				total++;
			}
		}

		/**
		 * down
		 */
		if (flipPoints.containsKey(DIRECTION_DOWN)) {
			endPoint = flipPoints.get(DIRECTION_DOWN);
			i = placingPoint.getRow() - 1;
			j = placingPoint.getCol();
			for (; i < endPoint.getRow(); i++) {
				boardData[i][j] = myNumber;
				total++;
			}
		}

		/**
		 * upper-right
		 */
		if (flipPoints.containsKey(DIRECTION_UPPER_RIGHT)) {
			endPoint = flipPoints.get(DIRECTION_UPPER_RIGHT);
			i = placingPoint.getRow() - 1;
			j = placingPoint.getCol() + 1;

			while (i > endPoint.getRow() && j < endPoint.getCol()) {
				boardData[i][j] = myNumber;
				i--;
				j++;
				total++;
			}
		}

		/**
		 * upper-left
		 */
		if (flipPoints.containsKey(DIRECTION_UPPER_LEFT)) {
			endPoint = flipPoints.get(DIRECTION_UPPER_LEFT);
			i = placingPoint.getRow() - 1;
			j = placingPoint.getCol() - 1;

			while (i > endPoint.getRow() && j > endPoint.getCol()) {
				boardData[i][j] = myNumber;
				i--;
				j--;
				total++;
			}
		}

		/**
		 * lower-left
		 */
		if (flipPoints.containsKey(DIRECTION_LOWER_LEFT)) {
			endPoint = flipPoints.get(DIRECTION_LOWER_LEFT);
			i = placingPoint.getRow() + 1;
			j = placingPoint.getCol() - 1;

			while (i < endPoint.getRow() && j > endPoint.getCol()) {
				boardData[i][j] = myNumber;
				i++;
				j--;
				total++;
			}
		}

		/**
		 * lower-right
		 */
		if (flipPoints.containsKey(DIRECTION_LOWER_RIGHT)) {
			endPoint = flipPoints.get(DIRECTION_LOWER_RIGHT);
			i = placingPoint.getRow() + 1;
			j = placingPoint.getCol() + 1;

			while (i < endPoint.getRow() && j < endPoint.getCol()) {
				boardData[i][j] = myNumber;
				i++;
				j++;
				total++;
			}
		}

		return total;
	}

	private Map<String, Point> getFlipPoints(int playerNumber, final Point currentPoint) {
		Map<String, Point> flipPoints = new HashMap<>();
		int i, j;

		i = currentPoint.getRow();
		j = currentPoint.getCol() + 1;
		boolean move = false;
//		right
		while (j < COLS && boardData[i][j] != 0 && boardData[i][j] != playerNumber) {
			j++;
			move = true;
		}

		if (move && j < COLS && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_RIGHT, new Point(i, j));
		}

//		left
		i = currentPoint.getRow();
		j = currentPoint.getCol() - 1;
		move = false;
		while (j > 0 && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			j--;
			move = true;
		}

		if (move && j >= 0 && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_LEFT, new Point(i, j));
		}

//		up
		i = currentPoint.getRow() - 1;
		j = currentPoint.getCol();
		move = false;
		while (i > 0 && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i--;
			move = true;
		}

		if (move && i >= 0 && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_UP, new Point(i, j));
		}

//		down
		i = currentPoint.getRow() + 1;
		j = currentPoint.getCol();
		move = false;
		while (i < ROWS && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i++;
			move = true;
		}

		if (move && i < ROWS && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_DOWN, new Point(i, j));
		}

//		upper right
		i = currentPoint.getRow() - 1;
		j = currentPoint.getCol() + 1;

		while (i >= 0 && j < COLS && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i--;
			j++;
			move = true;
		}

		if (move && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_UPPER_RIGHT, new Point(i, j));
		}

//		upper left
		i = currentPoint.getRow() - 1;
		j = currentPoint.getCol() - 1;
		move = false;
		while (i >= 0 && j >= 0 && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i--;
			j--;
			move = true;
		}

		if (move && i >= 0 && j >= 0 && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_UPPER_LEFT, new Point(i, j));
		}

//		lower left
		i = currentPoint.getRow() + 1;
		j = currentPoint.getCol() - 1;
		move = false;
		while (i < ROWS && j >= 0 && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i++;
			j--;
			move = true;
		}

		if (move && i < ROWS && j >= 0 && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_LOWER_LEFT, new Point(i, j));
		}

//		lower right
		i = currentPoint.getRow() + 1;
		j = currentPoint.getCol() + 1;
		move = false;
		while (i < ROWS && j < COLS && boardData[i][j] != playerNumber && boardData[i][j] != 0) {
			i++;
			j++;
			move = true;
		}

		if (move && i < ROWS && j < COLS && boardData[i][j] != 0) {
			flipPoints.put(DIRECTION_LOWER_RIGHT, new Point(i, j));
		}
		return flipPoints;
	}

	@Override
	public boolean canPlace(Player player, int row, int col) {
		Map flipPoints = getFlipPoints(player.getNumber(), new Point(row, col));
		return !flipPoints.isEmpty();
	}

	@Override
	public Player getWinner() {
		return null;
	}

	@Override
	public Player getFirstPlayer() {
		return this.firstPlayer;
	}

	@Override
	public Player getSecondPlayer() {
		return this.secondPlayer;
	}

	@Override
	public void attach(Observer observer) {
		this.observer = observer;
	}

	@Override
	public void detach(Observer observer) {
		this.observer = null;
	}

	@Override
	public void notifyObservers() {
		this.observer.update();
	}

	@Override
	public void newGame() {
		turn = firstPlayer.getNumber();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				boardData[i][j] = 0;
			}
		}
		// init board
		boardData[3][3] = firstPlayer.getNumber();
		boardData[3][4] = secondPlayer.getNumber();
		boardData[4][3] = secondPlayer.getNumber();
		boardData[4][4] = firstPlayer.getNumber();
		firstPlayer.setScore(2);
		secondPlayer.setScore(2);
		notifyObservers();
	}

	@Override
	public boolean place(int row, int col) {
		Player currentPlayer;
		if (this.getTurn() == firstPlayer.getNumber()) {
			currentPlayer = this.firstPlayer;
		} else {
			currentPlayer = this.secondPlayer;
		}
		return place(currentPlayer, row, col);
	}

	@Override
	public int getTurn() {
		return this.turn;
	}

	@Override
	public int getBoardValue(int row, int col) {
		return boardData[row][col];
	}

}
