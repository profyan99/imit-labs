package work;

public class Vector3DArray {
    private Vector3D[] vectors;

    public Vector3DArray(int size) {
        vectors = new Vector3D[size];
        for (int i = 0; i < size; i++) {
            vectors[i] = new Vector3D();
        }
    }

    public int length() {
        return vectors.length;
    }

    public void change(int pos, Vector3D vector) {
        if (pos >= length()) {
            throw new RuntimeException("Invalid array position");
        }
        vectors[pos] = vector;
    }

    public double getMaxLengthVector() {
        double maxLength = 0;
        for (Vector3D v : vectors) {
            if (v.length() > maxLength) {
                maxLength = v.length();
            }
        }
        return maxLength;
    }

    public int getVectorPos(Vector3D vector) {
        int result = -1;
        for (int i = 0; i < vectors.length && result == -1; i++) {
            if (vectors[i] == vector) {
                result = i;
            }
        }
        return result;
    }

    public Vector3D getSummAllVectors() {
        Vector3D sum = new Vector3D();
        for (Vector3D v : vectors) {
            sum = Vector3DProcessor.sum(sum, v);
        }
        return sum;
    }

    public Vector3D getLinearCombination(double[] coeffs) {
        if (coeffs.length != vectors.length) {
            throw new RuntimeException("Array length doesn't corresponds to vectors length.");
        }

        Vector3D output = new Vector3D();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i].multByNumber(coeffs[i]);
            output = Vector3DProcessor.sum(output, vectors[i]);
        }
        return output;
    }

    public Point3D[] getShiftedPoints(Point3D point) {
        Point3D[] output = new Point3D[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            output[i] = new Point3D(
                    point.getX() + vectors[i].getX(),
                    point.getY() + vectors[i].getY(),
                    point.getZ() + vectors[i].getZ()
            );
        }
        return output;
    }

    public Vector3D getElement(int pos) {
        if (pos >= length()) {
            throw new RuntimeException("Invalid array position");
        }
        return vectors[pos];
    }
}
