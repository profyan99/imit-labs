package work;

public class Vector3D {
    private double x, y, z;


    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D startPoint, Point3D endPoint) {
        this(
                endPoint.getX() - startPoint.getX(),
                endPoint.getY() - startPoint.getY(),
                endPoint.getZ() - startPoint.getZ()
        );
    }

    public Vector3D() {
        this(0, 0, 0);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public void multByNumber(double number) {
        x *= number;
        y *= number;
        z *= number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector = (Vector3D) o;
        return vector.x == x && vector.y == y && vector.z == z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
