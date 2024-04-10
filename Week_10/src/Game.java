import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Constructor.
     * */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Phương thức movePiece: di chuyển quân cờ piece đến vị trí x, y nếu hợp lệ.
     * Nếu di chuyển được, tạo đối tượng Move và thêm vào mảng moveHistory.
     * Làm tương tự với trường hợp nước đi hạ một quân cờ khác, đồng thời thực hiện
     * xóa quân cờ đó khỏi bàn cờ board.
     * */
    public void movePiece(Piece piece, int x, int y) {
        // Kiểm tra nước đi hợp lệ
        if (piece.canMove(board, x, y)) {
            // Nếu tại vị trí đích có quân cờ, lưu lại quân cờ bị ăn
            Piece destPiece = board.getAt(x, y);
            if (destPiece != null) {
                moveHistory.add(
                        new Move(piece.getCoordinatesX(), x,
                                piece.getCoordinatesY(), y, piece, destPiece)
                );
                board.removeAt(x, y);
            } else {
                moveHistory.add(new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece));
            }

            // Di chuyển quân cờ
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}