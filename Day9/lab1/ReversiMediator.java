package lab_10_01;

public interface ReversiMediator {
	public static int ROWS = 8;
	public static int COLS = 8;
	public static int STONE_FIRST_PLAYER = 1;
	public static int STONE_SECOND_PLAYER = 2;

	public int getTurn();

	public boolean place(int row, int col);

	public boolean place(Player player, int row, int col);

	public boolean canPlace(Player player, int row, int col);

	public Player getWinner();

	public void newGame();

	public int getBoardValue(int row, int col);

	public Player getFirstPlayer();

	public Player getSecondPlayer();
}
