package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {// chessMatch= partida de xadrez

	private Board board;// Board= tabuleiro

	public ChessMatch() {

		board = new Board(8, 8);
		initialSetup();
	}

	// este metodo vai percorre o board/tabuleiro, e para cada peça no board
	// ele vai fazer um downCasting para ChessPiece.
	public ChessPiece[][] getPieces() {// este metodo devolve uma matriz de peças
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				//aqui acontece o downCasting para (ChessPiece) assim,
				//o programa interpreta a peça cuma uma peça de xadrez e não como uma peça comun.
				mat[i][j] = (ChessPiece) board.piece(i, j);
				
			}
		}

		return mat;// aqui retorna as peças da partida de xadrez 
	}
	
	private void initialSetup() {
		board.placePice(new Rook(board,Color.WHITE),new Position(2,1) );
		board.placePice(new King(board, Color.BLACK),new Position(0,4));
		board.placePice(new King(board, Color.WHITE),new Position(7,4));
	}
}
