package rainbow.inner.system;

import rainbow.inner.coordinate.system.CoordinateSystem;
import rainbow.inner.coordinate.system.CoordinateSystemForAxes;
import rainbow.inner.function.MyFunction;
import rainbow.inner.function.mathfunction.simple._2D.ExpFunction;
import rainbow.inner.function.mathfunction.simple._2D.LogFunction;
import rainbow.inner.function.mathfunction.simple._2D.PowerFunction;
import rainbow.inner.function.mathfunction.simple._2D.spiral.*;
import rainbow.inner.function.mathfunction.simple._2D.trigonometric_function.*;
import rainbow.inner.function.mathfunction.simple._3D.Ellipsoid;
import rainbow.inner.function.mathfunction.special.Lissajous;
import rainbow.inner.function.mathfunction.special._2D.conic_section.Ellipse;
import rainbow.inner.function.mathfunction.special._2D.conic_section.Hyperbola;
import rainbow.inner.function.mathfunction.special._2D.conic_section.Parabola;
import rainbow.inner.function.mathfunction.special._2D.cycloid.*;
import rainbow.inner.function.pointfunction.Hypercube;
import rainbow.inner.function.pointfunction.RegularPolygon;
import rainbow.inner.listener.Listeners;
import rainbow.inner.scalable.ComponentScalable;
import rainbow.inner.view.BackgroundView;
import rainbow.inner.view.CoordinateSystemView;
import rainbow.inner.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类采用单例模式
 * 用于获取一些对象
 * 并存储所有的CoordinateSystem
 *
 * @author Rainbow Yang
 * @see rainbow.inner.system.MySystem.Version
 * @see rainbow.inner.system.MySystem.Size
 * @see rainbow.inner.system.MySystem.Views
 * @see rainbow.inner.system.MySystem.Information
 * @see rainbow.inner.system.MySystem.Registry
 */
public class MySystem extends ComponentScalable<SystemComponent> {

    private static MySystem system = new MySystem();

    private ArrayList<CoordinateSystem> CoordinateSystems = new ArrayList<>();
    private int index = -1;//目前使用的CoordinateSystem的索引

    private MySystem() {
        setComp(new Information(), new Version(), new Size(), new Listeners(), new Views(), new Registry());
        getInformation().initEndLog("System");
    }


    public CoordinateSystem getCoordinateSystem() {
        return CoordinateSystems.get(index);
    }

    public void setCoordinateSystem(CoordinateSystem cs) {
        if (CoordinateSystems.contains(cs)) {
            index = CoordinateSystems.indexOf(cs);
        } else {
            CoordinateSystems.add(cs);
            index = CoordinateSystems.size() - 1;
        }
    }

    public ArrayList<CoordinateSystem> getCoordinateSystems() {
        return CoordinateSystems;
    }

    //start-getComp

    public Version getVersion() {
        return (Version) getComp(Version.staticGetKeyName());
    }

    public Listeners getListeners() {
        return (Listeners) getComp(Listeners.staticGetKeyName());
    }

    public Size getSize() {
        return (Size) getComp(Size.staticGetKeyName());
    }

    public Views getViews() {
        return (Views) getComp(Views.staticGetKeyName());
    }

    public Information getInformation() {
        return (Information) getComp(Information.staticGetKeyName());
    }

    public Registry getRegistry() {
        return (Registry) getComp(Registry.staticGetKeyName());
    }
    //end-getComp

    public static MySystem getSystem() {
        return system;
    }

    // inner class

    /**
     * 本类用于存储所要显示的大小。
     *
     * @author Rainbow Yang
     */
    public static class Size implements SystemComponent {
        public static final double DEFAULT_WIDTH = 1300, DEFAULT_HEIGHT = 800;

        private double width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;

        public double getWidth() {
            return width;
        }

        public void setWidth(double newWidth) {
            width = newWidth;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double newHeight) {
            height = newHeight;
        }

        public void setSize(JFrame f) {
            f.setSize((int) getWidth(), (int) getHeight());
        }

        @Override
        public String getKeyName() {
            return staticGetKeyName();
        }

        public static String staticGetKeyName() {
            return "Size";
        }
    }

    /**
     * 本类用于存储版本信息。
     *
     * @author Rainbow Yang
     */
    public static class Version implements SystemComponent {
        private String name = "FunctionPainter";
        private String version = "V2.0";
        private String author = "Rainbow Yang";

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public String getAuthor() {
            return author;
        }

        public void setTitle(JFrame f) {
            f.setTitle(getName() + getVersion() + "  Author:" + getAuthor());
        }

        @Override
        public String getKeyName() {
            return staticGetKeyName();
        }

        public static String staticGetKeyName() {
            return "Version";
        }
    }

    /**
     * 本类用于存储界面
     */
    public static class Views implements SystemComponent {
        private Runnable repaint;

        private ArrayList<View> views = new ArrayList<>();

        {
            addView(new BackgroundView());
            addView(new CoordinateSystemView());
        }

        public void setRepaint(Runnable repaint) {
            this.repaint = repaint;
        }

        public Image getImage() {
            BufferedImage image = new BufferedImage((int) MySystem.getSystem().getSize().getWidth(),
                    (int) MySystem.getSystem().getSize().getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            Graphics g = image.getGraphics();
            //抗锯齿
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            views.forEach(view -> view.paint(g));
            return image;
        }

        public void addView(View view) {
            views.add(view);
        }

        public void repaint() {
            repaint.run();
        }

        @Override
        public String getKeyName() {
            return staticGetKeyName();
        }

        public static String staticGetKeyName() {
            return "Views";
        }

    }

    /**
     * 本类用于存储信息
     */
    public static class Information implements SystemComponent {
        private List<String> informations = new ArrayList<>();

        private long start;

        {
            System.out.println();
            System.out.println("Time\tProcess");
            start = System.currentTimeMillis();
            initStartLog("System");
        }

        public void log(String information) {
            informations.add((System.currentTimeMillis() - start) + "\t\t" + information);
            System.out.println(informations.get(informations.size() - 1));
        }

        public void initStartLog(String information) {
            log("Start initing " + information + "...");
        }

        public void initEndLog(String information) {
            log("Finish initing " + information + "...");
        }

        @Override
        public String getKeyName() {
            return staticGetKeyName();
        }

        public static String staticGetKeyName() {
            return "Information";
        }
    }

    /**
     * 本类静态存储所有可创建的坐标系和函数的Class文件
     *
     * @author Rainbow Yang
     */
    public static class Registry implements SystemComponent {

        private List<Class<? extends MyFunction>> functions = new ArrayList<>();
        private List<Class<? extends CoordinateSystem>> coordinateSystems = new ArrayList<>();

        {
            coordinateSystems.add(CoordinateSystemForAxes.class);


            functions.add(PowerFunction.class);
            functions.add(ExpFunction.class);
            functions.add(LogFunction.class);

            functions.add(Cos.class);
            functions.add(Tan.class);
            functions.add(Cot.class);
            functions.add(Sin.class);
            functions.add(Csc.class);
            functions.add(Sec.class);

            functions.add(Ellipse.class);
            functions.add(Parabola.class);
            functions.add(Hyperbola.class);

            functions.add(Lissajous.class);

            functions.add(Epitrochoid.class);
            functions.add(Hypotrochoid.class);
            functions.add(Hypocycloid.class);
            functions.add(Epicycloid.class);
            functions.add(Cycloid.class);

            functions.add(ArchimedeanSpiral.class);
            functions.add(IsometricSpiral.class);
            functions.add(LituusSpiral.class);
            functions.add(FermatSpiral.class);
            functions.add(HyperbolicSpiral.class);

            functions.add(Ellipsoid.class);
            functions.add(Hypercube.class);
            functions.add(RegularPolygon.class);

            // functions.add(Net.class);

        }

        public List<Class<? extends MyFunction>> getFunctions() {
            return functions;
        }

        public List<Class<? extends CoordinateSystem>> getCoordinateSystems() {
            return coordinateSystems;
        }

        @Override
        public String getKeyName() {
            return staticGetKeyName();
        }

        public static String staticGetKeyName() {
            return "Registry";
        }
    }
}
