package rainbow

import rainbow.inner.background.Background
import rainbow.inner.color.CoordinateSystemColors
import rainbow.inner.coordinate.system.CoordinateSystemForAxes
import rainbow.inner.function.MyFunction
import rainbow.inner.function.mathfunction.special.Lissajous
import rainbow.inner.function.pointfunction.RegularPolygon
import rainbow.inner.listener.CoordinateSystemListener
import rainbow.inner.painter.background.DefaultBackgroundPainter
import rainbow.inner.painter.coordinate_system.DefaultCoordinateSystemPainter
import rainbow.inner.painter.function.DefaultFunctionsPainter
import rainbow.inner.system.MySystem
import rainbow.inner.system.SystemListeners
import rainbow.inner.system.SystemPainters
import rainbow.inner.system.getColors
import rainbow.outer.frame.MainFrame
import rainbow.tools.CodeReader


/**
 * 这是FunctionPainter2，一个重新开始的版本
 * 没错，之前的版本最终被我放弃了
 * @author Rainbow Yang
 */

fun main(args: Array<String>) {
    readCode()

    addListeners()
    addPainters()
    addColors()

    coordinateSystemInit()
    functionsInit()
    showFrame()
}

fun addPainters() {

//    MySystem.background = Background(img = ImageIO.read(File(".//src//rainbow//星空.jpg")))
//    MySystem.background = Background("红")
    MySystem.background = Background("0X2B2B2B")
//    MySystem.background = Background("519872")
//    MySystem.background = Background("34252F")
//    MySystem.background = Background("DAB094")
//    MySystem.background = Background("94B0DA")
//    MySystem.background = Background("0F9D58")

    SystemPainters.painters.apply {
        add(DefaultBackgroundPainter())
        add(DefaultCoordinateSystemPainter())
        add(DefaultFunctionsPainter())
    }
}

fun addListeners() {
    SystemListeners.addMouseListener(CoordinateSystemListener())
}

fun addColors() {
    MySystem.getColors().colorsList.add(CoordinateSystemColors())
}

fun coordinateSystemInit() {
    MySystem.coordinateSystem = CoordinateSystemForAxes(3)
}

fun functionsInit() {
    MySystem.functions.apply {
        //        add(ExpFunction(1.0, Math.E))
//        add(LogFunction(1.0, Math.E))
//        add(PowerFunction("1*x^2"))
//
//        add(Sin(1.0, 1.0, 0.0))
//        add(Cos(1.0, 1.0, 0.0))
//        add(Tan(1.0, 1.0, 0.0))
//        add(Cot(1.0, 1.0, 0.0))
//        add(Sec(1.0, 1.0, 0.0))
//        add(Csc(1.0, 1.0, 0.0))
//
//        add(Ellipse(5.0, 5.0, X_TOWARDS))
//        add(Ellipse(5.0, 5.0, Y_TOWARDS))
//        add(Hyperbola(5.0, 5.0, X_TOWARDS))
//        add(Hyperbola(5.0, 5.0, Y_TOWARDS))
//        add(Parabola(5.0, X_TOWARDS))
//        add(Parabola(5.0, Y_TOWARDS))
//
//        add(Ellipsoid(6.0, 6.0, 6.0))
        add(Lissajous(13, 18, 27))
//        add(RegularPolygon(60, 5.0, 23))
//
//        add(FermatSpiral(100.0, 1.0))
//        add(IsometricSpiral(1.0, 0.5))
//        add(HyperbolicSpiral(1.0))
//        add(ArchimedeanSpiral(1.0))
//        add(LituusSpiral(1.0))
//
//        add(Cycloid())
//        add(Hypotrochoid(10.0, 4.0, 1.0))
//        add(Hypocycloid(10.0, 4.0))
//        add(Epitrochoid(6.0, 4.0, 4.0))
//        add(Epicycloid(10.0, 3.0))
//
//        add(Net { x: Double, y: Double -> -10 / Math.sqrt(0.000001 + (x * x) + (y * y)) })
//
//        add(Hypercube(10.0, 4))
    }
    MySystem.functions.forEach(MyFunction::calc)
}

fun showFrame() {
    MainFrame()
}

fun readCode() {
    CodeReader(".//src//rainbow").print(CodeReader.DETAILED)
}