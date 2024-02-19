package boardgame;

public class Board {

	public int rows;
	public int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	// placePice recebe uma peça(Piece piece, Position position) e uma posição
	public void  placePice(Piece piece, Position position) {//colocar peça
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
		//pieces e a matriz de peças[position.getRow()][position.getColumn()] = piece;
		// essa 
	}
}	
