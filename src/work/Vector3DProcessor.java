package work;

public class Vector3DProcessor {

    public static Vector3D sum(Vector3D first, Vector3D second) {
        return new Vector3D(
                first.getX() + second.getX(),
                first.getY() + second.getY(),
                first.getZ() + second.getZ()
        );
    }

    public static double scalarMult(Vector3D first, Vector3D second) {
        return first.getX() * second.getX() + first.getY() * second.getY() + first.getZ() * second.getZ();
    }

    public static Vector3D vectorMult(Vector3D first, Vector3D second) {
        return new Vector3D(
                first.getY() * second.getZ() - first.getZ() * second.getY(),
                first.getZ() * second.getX() - first.getX() * second.getZ(),
                first.getX() * second.getY() - first.getY() * second.getX()
        );
    }

    public static boolean isCollinear(Vector3D first, Vector3D second) {
        Vector3D vectorMult = vectorMult(first, second);
        return vectorMult.getX() == 0 && vectorMult.getY() == 0 && vectorMult.getZ() == 0;
    }
}
