package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
		
	}
	@Override
	public String toString() {
		return "K";
	}
	@Override
	public boolean[][] possibleMoves() {
		// A matriz de booleans com a mesma dimensão do tabuleiro.
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()]; 
		//toda vez que eu chamar o rei ele vai retornar uma matriz boolean falsa, e como se o rei estivesse preso
		return mat;
	}

}
