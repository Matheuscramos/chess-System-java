package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;

	public Piece(Board board) {

		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	// este método e abstrato porque a peça e generica,você não sabe qual peça esta
	// selecionada!
	// O método vai retornar uma matriz de posições boolean[][].
	public abstract boolean[][] possibleMoves();
	// Este método confirma se o movimento da peça e possivel, ele recebe uma
	// posição e confirma se a peça pode ir para essa dada posição.

	public boolean possibeMove(Position position) {
		// No retorno está sendo usado um metodo abstrato dentro de um metodo concreto.
		// onde e retornado a matriz boolean com uma posição e coluna.
		// essa ação e chamada de hookmetodo, e um método que faz um gancho com a sub
		// classe.
		// o método possibeMove pode ser concreto porque ele chama uma possivel
		// implementação concreta da sub classe Piece.
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		// Aqui e criado uma matriz boolean chamada mat que recebe , os movimentos
		// possiveis que e a chamada do método abstrato possibleMoves()
		boolean[][] mat = possibleMoves();
		// Agora a matriz que e retornada é percorrido através dos 2 fors...
		// para ver se a uma posição que e verdadeira
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				//se a matriz na linha i e na coluna j for verdadeira então existe um movimento possível, retorne true.
				if (mat[i][j]) {
					return true;
				}
			}
		}
		//Ee a varedura da matriz esgotar e em lugar nem um retornar true.
		//Significa que nem uma posição era verdadeira, e sera retornado false.
		return false;
	}

}
