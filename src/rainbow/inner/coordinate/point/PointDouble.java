package rainbow.inner.coordinate.point;

import static java.lang.Math.*;

/**
 * 用于表示屏幕上的位置
 *
 * @author Rainbow Yang
 */
public class PointDouble {
    private double x;
    private double y;

    public PointDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public PointDouble spin(double angle) {
        return new PointDouble(x * cos(angle) - y * sin(angle), x * sin(angle) + y * cos(angle));
    }

    @Override
    public String toString() {
        return "PointDouble{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
