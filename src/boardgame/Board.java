package boardgame;

public class Board {

	public int rows;
	public int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		// este if server para quando o tabuleiro foi criado, ele ter pelo menos uma
		// linha e uma coluna
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}
	// o metodo setRows foi retirado para que depois que o tabuleiro e formado, a
	// quantidade de
	// linhas não pode ser alterado.
	// public void setRows(int rows) {
	// this.rows = rows;
	// }

	public int getColumns() {
		return columns;
	}

	// da mesma forque o setColumns foi retirado para que depois que o tabuleiro e
	// formado, a quantidade de
	// colunas não pode ser alterado.
	// public void setColumns(int columns) {
	// this.columns = columns;
	// }

	// O metodo Piece piece acessa uma dada peça em uma dada coluna
	public Piece piece(int row, int column) {
		// este if testa se a linha e coluna esxiste nessa posição
		// se a posição não existir, e lançado o BoardException
		if (!positionExists(row, column)) {
			throw new BoardException("Position not the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	// placePice (Piece piece, Position position) coloca uma peça em uma dada posição
	public void placePice(Piece piece, Position position) {// colocar peça
		// o if olha se antes de colocar uma peça na posição, ja existe outra peça na posição
		// se ja existe uma peça em Position position, não e permitido colocaroutra peça Piece piece, na posição
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;

		// pieces e a matriz de peças[position.getRow()][position.getColumn()] = piece;
		// essa
	}
	
	public Piece removePiece(Position position) {
		// if faz uma analise defensiva, checand se a posição da peça existe
		if(!positionExists(position)) {
			throw new BoardException("Position not the board");
		}
		// se a peça na posição for igual a nulo, significa que não tem nem uma peça nessa posição
		if(piece(position) == null) {
			//se não tem peça na posição retorna nulo.
			return null;
		}
		//se a posição não retornar nulo, ai sera feira a retirada da peça do tabuleiro
		// a variavel aux aponta para a peça 
		Piece aux = piece(position);
		// Aqui a variavel aux recebe a posição nula e e retirada do tabuleiro.
		aux.position = null;
		//essa matriz de peças pieces[] na linha position.getRow() na posição position.getColoumn()vai receber nulo
		//então a peça no tabuileiro e colocada como nula, e depois e direcionada para as posições da matriz.
		pieces[position.getRow()][position.getColumn()] = null;
		// agora a variavel aux retorna a peça que foi retirada;
		return aux;
	}
	
	// este metodo pega um linha e uma coluna no tabuleiro e checa se ela e valida
	// ou não!
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
		// rows e a altura e columns e a quantidade de colunas
	}
	// este metodo pega um aposição no tabuleiro e checa se ela e valida ou não!

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
		// depois de ter checados as posições no metodo
		// public boolean positionExists(int row, int column) {
		// return row >= 0 && row < rows && column >=0 && column < columns;
		// e assim que e testado se uma posição existe
	}

	public boolean thereIsAPiece(Position position) {
		// quando o there IsAPiece for chamado, ele ja vai testar se a posição existe
		// se não existir ele ja para e lança uma exception
		if (!positionExists(position)) {
			throw new BoardException("Position not the board");
		}
		return piece(position) != null;

		// Se esta pessa que esta em piece(position for diferente != de null
		// então vai ter uma peça na posição trereIsApiece(Position position)
	}

}
