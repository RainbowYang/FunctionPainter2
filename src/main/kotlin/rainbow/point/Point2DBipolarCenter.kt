package rainbow.point

import java.lang.Math.*

/**
 * 二维双心坐标点
 * @author Rainbow Yang
 */
class Point2DBipolarCenter(val r1: Double, val r2: Double, val a: Double) : Point2D {

    operator fun component1() = r1
    operator fun component2() = r2

    override fun toPointForAxes(): PointForAxes {
        val d = (r1 * r1 - r2 * r2)
        val x = d / (4 * a)
        val y = sqrt(16 * a * a * r1 * r1 - pow((d + 4 * a * a), 2.0)) / (4 * a)
        return PointForAxes(x, y)
    }
}