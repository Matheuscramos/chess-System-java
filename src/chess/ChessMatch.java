package chess;

import boardgame.Board;
import boardgame.Piece;
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
				// aqui acontece o downCasting para (ChessPiece) assim,
				// o programa interpreta a peça cuma uma peça de xadrez e não como uma peça
				// comun.
				mat[i][j] = (ChessPiece) board.piece(i, j);

			}
		}

		return mat;// aqui retorna as peças da partida de xadrez
	}

	// este método ira ter uma posição de origem( sourcePosition), uma posição de
	// destino(ChessPosition targetPosition ) , eeste método podera retornar uma
	// posição capturada.
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		// a posição de origem e de destinos seram convertidas em posições da matriz.
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		// Antes de fazer o movimento tem que ser feita a validação se nas posições de
		// origem avia uma peça.
		validateSourcePosition(source);
		//validar a posição de destino.
		validateTargetPosition(source, target);
		// esta operação será responsavel por fazer o movimento da peça.
		Piece capturedPiece = makeMove(source, target);
		// agora e retornada a peça capturada.
		// e é feito um
		return (ChessPiece) capturedPiece;
	}

	// este metodo faz o movimento das peças de xadrez no tabuleiro
	private Piece makeMove(Position source, Position target) {
		// removeu a peça de origem.
		Piece p = board.removePiece(source);
		// será removido a peça na posição de destino
		Piece capturedPiece = board.removePiece(target);
		// agora a posição que estava na origem sera colocada na de destino.
		board.placePice(p, target);

		return capturedPiece;
	}

	// este método faz a validação da posição de origem.
	private void validateSourcePosition(Position position) {
		// Se não existir uma peça nessa posição, será lançada uma exceção.
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position!");
		}
		// Se não existe movimentos possivéis para a peça, será lançada uma excessão.
		//
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");

		}

	}
	//Este método olha se a posição target(destino) e valida em relação a posição de de origen(source)
	private void validateTargetPosition(Position source, Position target ) {
		//target e um movimento possivel em relação a source?
		//Se para a peça de origem piece(source), a posição de destino NÂO(!)possibleMove(target), não e um movimento possivel
		//significa que eu não posso mexer para lá.
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("the chosen piece can't move to target position");
		}
	}

	// este metodo ira informar a posição das peça no xadrez usando o toPosition da
	// classe chessPosition
	// ele recebe as coordenadas do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		// o metodo chama o board
		board.placePice(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		// com base no metodo private void placNewPoece()
		// vai ser substituido o new position pelas posições do xadrez

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
