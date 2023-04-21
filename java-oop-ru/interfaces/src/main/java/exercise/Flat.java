package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    double totalArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        totalArea = area + balconyArea;;
    }

    @Override
    public double getArea() {
        return totalArea;
    }

    @Override
    public int compareTo(Home flat) {
        if (totalArea > flat.getArea()) {
            return 1;
        } if (totalArea < flat.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров" +  " на " + floor +  " этаже";
    }
}
// END
