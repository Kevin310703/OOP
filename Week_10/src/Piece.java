public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Constructor 1.
     * */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * Constructor 2.
     * */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * Phương thức trừu tượng getSymbol()
     * Trả về dữ liệu kiểu String là ký hiệu quốc tế của mỗi loại quân cờ.
     * */
    public abstract String getSymbol();

    /**
     * Phương thức trừu tượng canMove
     * Trả về kiểu dữ liệu boolean để kiểm tra xem quân cờ có thể đi đến
     * vị trí x, y trên bàn cờ board hay không. Mỗi loại quân cờ có cách đi
     * khác nhau nên các phép xử lý logic trong phương thức này là khác nhau.
     * */
    public abstract boolean canMove(Board board, int coordinatesX, int coordinatesY);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean checkPosition(Piece piece) {
        return true;
    }
}
