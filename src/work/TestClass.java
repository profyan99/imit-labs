package work;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void Vector3DArrayTest_willCreateZeroVectors() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        assertEquals(3, vector3DArray.length());
    }

    @Test
    public void Vector3DArrayTest_willChangeVectors() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        Vector3D expectedVector = new Vector3D(1, 2, 3);
        vector3DArray.change(0, expectedVector);
        Vector3D actual = vector3DArray.getElement(0);
        assertEquals(expectedVector, actual);
    }

    @Test(expected = RuntimeException.class)
    public void Vector3DArrayTest_invalidPosExpectedException() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        vector3DArray.change(-1, new Vector3D(1, 2, 3));
    }

    @Test
    public void Vector3DArrayTest_willReturnMaxLengthOfVectors() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        Vector3D expectedVector = new Vector3D(4, 4, 4);
        vector3DArray.change(0, new Vector3D(2, 2, 2));
        vector3DArray.change(1, new Vector3D(3, 3, 3));
        vector3DArray.change(2, expectedVector);
        double expected = vector3DArray.getMaxLengthVector();
        assertEquals(expectedVector.length(), expected, 0.01f);
    }

    @Test
    public void Vector3DArrayTest_willReturnPositionOfVector() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        Vector3D expectedVector = new Vector3D(4, 4, 4);
        vector3DArray.change(0, new Vector3D(1, 2, 5));
        vector3DArray.change(1, new Vector3D(3, 3, 2));
        vector3DArray.change(2, expectedVector);
        int pos = vector3DArray.getVectorPos(expectedVector);
        assertEquals(2, pos);
    }

    @Test
    public void Vector3DArrayTest_vectorNotFound_willReturnNegativeValue() {
        Vector3DArray vector3DArray = new Vector3DArray(2);
        vector3DArray.change(0, new Vector3D(1, 8, 5));
        vector3DArray.change(1, new Vector3D(5, 3, 2));
        int pos = vector3DArray.getVectorPos(new Vector3D(4, 4, 4));
        assertEquals(-1, pos);
    }

    @Test(expected = RuntimeException.class)
    public void Vector3DArrayTest_invalidSizeExpectedException() {
        double[] arr = new double[1];
        Vector3DArray vector3DArray = new Vector3DArray(3);
        vector3DArray.getLinearCombination(arr);
    }

    @Test
    public void Vector3DArrayTest_willReturnVector3D() {
        double[] arr = {2f, 2f, 2f};
        Vector3DArray vector3DArray = new Vector3DArray(3);
        vector3DArray.change(0, new Vector3D(1, 1, 1));
        vector3DArray.change(1, new Vector3D(2, 2, 2));
        vector3DArray.change(2, new Vector3D(1, 2, 3));

        Vector3D output = vector3DArray.getLinearCombination(arr);
        assertEquals(8f, output.getX(), 0.1f);
        assertEquals(10f, output.getY(), 0.1f);
        assertEquals(12f, output.getZ(), 0.1f);
    }

    @Test
    public void Vector3DArrayTest_willReturnSumOfVectors() {
        Vector3DArray vector3DArray = new Vector3DArray(3);
        vector3DArray.change(0, new Vector3D(1, 1, 1));
        vector3DArray.change(1, new Vector3D(1, 1, 1));
        vector3DArray.change(2, new Vector3D(1, 1, 1));

        Vector3D vector3D = vector3DArray.getSummAllVectors();
        assertEquals(3f, vector3D.getX(), 0.1f);
        assertEquals(3f, vector3D.getY(), 0.1f);
        assertEquals(3f, vector3D.getZ(), 0.1f);
    }

    @Test
    public void Vector3DArrayTest_willReturnZeroVector() {
        double[] arr = {0f, 0f};
        Vector3DArray vector3DArray = new Vector3DArray(2);
        vector3DArray.change(0, new Vector3D(4, 1, 1));
        vector3DArray.change(1, new Vector3D(2, 7, 2));

        Vector3D output = vector3DArray.getLinearCombination(arr);
        assertEquals(0f, output.getX(), 0.1f);
        assertEquals(0f, output.getY(), 0.1f);
        assertEquals(0f, output.getZ(), 0.1f);
    }

    @Test
    public void Vector3DArrayTest_willReturnPoint3D() {
        Vector3DArray vector3DArray = new Vector3DArray(2);
        vector3DArray.change(0, new Vector3D(4, 1, 1));
        vector3DArray.change(1, new Vector3D(2, 7, 2));

        Point3D[] expectedPoints = {
                new Point3D(6, 3, 3),
                new Point3D(4, 9, 4)
        };

        Point3D[] output = vector3DArray.getShiftedPoints(new Point3D(2, 2, 2));
        assertEquals(2, output.length);
        assertEquals(expectedPoints[0].getX(), output[0].getX(), 0.1f);
        assertEquals(expectedPoints[1].getY(), output[1].getY(), 0.1f);
        assertEquals(expectedPoints[1].getZ(), output[1].getZ(), 0.1f);
    }

}
