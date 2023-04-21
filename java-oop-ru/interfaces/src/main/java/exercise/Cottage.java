package exercise;

// BEGIN
class Cottage implements Home {
    double area;
    int floorCount;


    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home flat) {
        if (area > flat.getArea()) {
            return 1;
        } if (area < flat.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
