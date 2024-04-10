import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Constructor.
     * */
    public Board() {}

    /**
     * Phương thức addPiece
     * Chức năng thêm một quân cờ vào trong bàn cờ bằng cách
     * thêm phần tử mới vào thuộc tính pieces của lớp. Quân cờ piece
     * chỉ được thêm vào mảng pieces khi có tọa độ hợp lệ và tọa độ của nó
     * không trùng với quân cờ nào đã có trong danh sách.
     * */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();

        // Kiểm tra tọa độ hợp lệ và không trùng với quân cờ khác
        if (validate(x, y) && getAt(x, y) == null) {
            pieces.add(piece);
        }
    }

    /**
     * Phương thức validate
     * Sử dụng để kiểm tra tọa độ x, y có thỏa mãn 1 <= x, y <=8 hay không.
     * */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * Phương thức removeAt
     * Thực hiện chức năng xóa quân cờ tại vị trí x, y ra khỏi bàn cờ.
     * */
    public void removeAt(int x, int y) {
        // Xóa quân cờ tại vị trí x, y nếu có
        pieces.removeIf(piece -> piece.getCoordinatesX() == x && piece.getCoordinatesY() == y);
    }

    /**
     * Phương thức getAt
     * Trả về quân cờ đang ở vị trí x, y trên bàn cờ. Nếu không có, trả về null.
     * */
    public Piece getAt(int x, int y) {
        // Tìm và trả về quân cờ đang ở vị trí x, y trên bàn cờ
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null; // Không có quân cờ ở vị trí x, y
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}