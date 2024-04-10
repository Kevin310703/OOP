public class Rook extends Piece {
    /**
     * Constructor 1.
     * */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * Constructor 2.
     * */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    /**
     * getSymbol trả về ký hiệu quốc tế của quân Xe.
     * */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Phương thức canMove có chức năng là kiểm tra xem quân xe có di chuyển
     * đến được vị trí x, y trong bàn cờ hay không, trả về true nếu có,
     * ngược lại là false. Xe chỉ được đi thẳng hoặc đi ngang, trên đường đi
     * nếu gặp chướng ngại vật (quân cờ khác) thì không được di chuyển,
     * nếu tại vị trí x, y có quân cờ khác màu (ăn quân) thì coi là có thể di chuyển.
     * */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int startX = this.getCoordinatesX();
        int startY = this.getCoordinatesY();

        // Xác định hướng di chuyển
        if (x != startX && y != startY) {
            return false; // Xe chỉ được đi thẳng hoặc đi ngang
        }

        // Kiểm tra các ô trên đường di chuyển
        int deltaX = (x != startX) ? (x - startX) / Math.abs(x - startX) : 0;
        int deltaY = (y != startY) ? (y - startY) / Math.abs(y - startY) : 0;

        for (int i = startX + deltaX, j = startY + deltaY; i != x
                || j != y; i += deltaX, j += deltaY) {
            if (board.getAt(i, j) != null) {
                return false; // Không thể di chuyển qua ô có quân cờ khác
            }
        }

        // Kiểm tra ô đích
        Piece destPiece = board.getAt(x, y);
        return destPiece == null || !destPiece.getColor().equals(this.getColor());
    }
}