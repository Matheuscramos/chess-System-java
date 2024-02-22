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
	//este metodo ira informar a posição das peça no xadrez usando o toPosition da classe chessPosition
	// ele recebe as coordenadas do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		//o metodo chama o board
		board.placePice(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		// com base no metodo private void placNewPoece()
		//vai ser substituido o new position pelas posições do xadrez
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
