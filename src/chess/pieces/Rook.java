package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook  extends ChessPiece{//torre extendes peça de xadrez

	public Rook(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	
	public String toString() {
		return "R";
	}

}
