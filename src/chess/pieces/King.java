package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

	// Esté método olha se o rei pode mover para uma determinada posição.
	private boolean canMove(Position position) {
		// para isso pegue a peça p que esta na posição do tabuleiro getBorad() com a
		// peça da posição piece(position)
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		// agora tem que verificar se a peça p não e null e se ela e uma peça adversária
		// nesses 2 casos pode mover o rei para essas posições

		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		// A matriz de booleans com a mesma dimensão do tabuleiro.
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		// toda vez que eu chamar o rei ele vai retornar uma matriz boolean falsa, e
		// como se o rei estivesse preso
		// agora sera implementado os movimentos possiveis do rei canMove que ele pode
		// se mover.

		Position p = new Position(0, 0);

		// acima
		// pegue a posição acima do rei linha position.getRow()-1 e position.getColumn()
		p.setValues(position.getRow() - 1, position.getColumn());
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// direita
		p.setValues(position.getRow() , position.getColumn() + 1);
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// diagonal noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// diagonal nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// diagonal sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		// agora teste
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//diagonal sudeste
		
		p.setValues(position.getRow() +1, position.getColumn() + 1);
		// agora teste
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}

}
