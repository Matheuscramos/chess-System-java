package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {// torre extendes peça de xadrez

	public Rook(Board board, Color color) {
		super(board, color);

	}

	@Override

	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		// A matriz de booleans com a mesma dimensão do tabuleiro.
		// mais suas posições valendo falso.
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		// verificando as posições da matriz.
		Position p = new Position(0, 0);
		// ACIMA
		// pega a posição da peça -1 porque esta sendo analisado acima da peça
		p.setValues(position.getRow() - 1, position.getColumn());
		// enquanto a posição positionExists(position) existir e não tiver uma peça la
		// thereIsAPiece(position),ou seja enquanto a posição estiver vaga, a posição
		// será marcada como verdadeira
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			// a posição da matriz mat linha e coluna vai receber verdadeiro, indicando que
			// a peça podera ser movida para a posição da mat.
			mat[p.getRow()][p.getColumn()] = true;
			// aqui isso será repetido enquanto tiver casas vazias para cima
			p.setRow(p.getRow() - 1);
		}
		// aqui será testado se a ultima posição existe e se ela e de uma peça
		// adversária, se for ela será substituida.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Esquerda da peça.
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;
			// aqui isso será repetido enquanto tiver casas vazias para cima
			p.setColumn(p.getColumn() - 1);
		}

		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Direita da peça
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;
			// aqui isso será repetido enquanto tiver casas vazias para cima
			p.setColumn(p.getColumn() + 1);
		}

		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Baixo

		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;
			// aqui isso será repetido enquanto tiver casas vazias para cima
			p.setRow(p.getRow() + 1);
		}

		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// toda vez que eu chamar o rei ele vai retornar uma matriz boolean falsa, e
		// como se o rei estivesse preso
		return mat;
	}

}
