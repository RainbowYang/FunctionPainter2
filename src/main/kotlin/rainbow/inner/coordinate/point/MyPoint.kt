package rainbow.inner.coordinate.point

/**
 * 用于表示坐标系上的一个点
 * 所有子类的所有操作均不应修改其本身
 * @author Rainbow Yang
 */
interface MyPoint {
    //所有的点都应该能够转换成PointForAxes
    fun toPointForAxes(): PointForAxes

    operator fun times(times: Double): MyPoint
    operator fun unaryMinus() = times(-1.0)
}