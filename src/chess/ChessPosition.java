package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		// Char aceita comparativos column < 'a'.
		// o if faz uma checagem da coluna e linha que foram digitadas, se elas
		// estiverem dentro dos padroes do tabuleiuro que vai de
		// (a ate h e de 1 ate 8), se alguma
		// dessas condições forem contrariadas o if lança uma ChessException.
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating chess`psotion. Validation! ");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// este medotodo ira converter a posição digitada (EX:coluna a, linha 8), que
	// seria a posição zero da matriz.
	// e pra fazer isso basta pegar o o numero da linha e subtrair por ele mesmo
	// 8-8 da a posição 0 da matriz, 7-8 da a posição 1 da matriz e assim por
	// diante.
	// De forma mais especifica e pego a linha da matrix_row - a linha do chess_row
	// do mesmo jeito a coluna, você pega o codigo unicold do caracter 'a' e subtrai
	// pelo codigo unicod do 'a' vai dar 1
	// se for o 'a'-'b', vai dar 1, se for 'a'-'b' vai dar 2.....

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	// este metodo faz a conversão do calculo da coluna e linha digitados na matriz
	// para a posição do xadrez
	protected static ChessPosition fromPosition(ChessPosition position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
	}
}
