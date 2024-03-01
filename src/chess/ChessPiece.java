package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { //ChessPiece=peças de xadrez

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	//Este método vai ser reaproveitado em outras peças.
	// O método e protected porque ele so pode ser acessado pelas classes do mesmo pacote ou pelas sub classes chess.piece
	protected boolean isThereOpponentPiece(Position Position) {
		// o Método descobre se tem uma peça adversaria na posição que a peça percorre.
		//aqui e pego a peça que esta na posição e do tabuleiro, e verifico se essa peça e adversaria
		ChessPiece p = (ChessPiece)getBoard().piece(Position);
		// aqui será testado se a peça p que tem a peça da posição tem a cor diferente das peças aliadas
		// se  a cor for diferente da cor aliada, então e uma peça adversária
		return p != null && p.getColor() != color;
	}
}
