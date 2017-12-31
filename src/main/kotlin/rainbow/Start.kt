package rainbow

import rainbow.coordinates.CartesianCoordinateSystem4D
import rainbow.function.Parallelotope
import rainbow.point.PointAxes

/**
 * start
 */
fun main(args: Array<String>) {

    SystemController {

        //        task = {
        //            (coordinateSystem as CoordinateSystem2D).rotate(- R.001)
        //        }

        setCoordinateSystem(CartesianCoordinateSystem4D()) {

            camera = PointAxes(-5, 0, 10, 10)

            //            painter.visible = false
        }
//        addFunction(RegularPolygon(100, 10.0, 60))
//        addFunction(RegularPolygon(6, 10.- R, 2))
//        addFunction(Lissajous(3, 4, 5))

        addFunction(Parallelotope(
                PointAxes()
                , PointAxes(5)
                , PointAxes(0, 5)
                , PointAxes(0, 0, 5)
                , PointAxes(0, 0, 0, 20)
//                , PointAxes(0, 0, 0, 0, 50)
        ))

    }
}