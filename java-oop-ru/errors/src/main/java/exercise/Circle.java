package exercise;

// BEGIN
class Circle {
    private Point point;
    private int r;

    public Circle(Point point, int r) {
        this.point = point;
        this.r = r;
    }

    public int getRadius() {
        return r;
    }

    public double getSquare() throws NegativeRadiusException {
        if (r < 0) {
            throw new NegativeRadiusException();
        } else {
            return Math.PI * r * r;
        }
    }

}
// END
