package rainbow.inner.listener;

import rainbow.inner.coordinate.system.event.MoveEvent;
import rainbow.inner.coordinate.system.event.RotateEvent;
import rainbow.inner.coordinate.system.event.ZoomEvent;
import rainbow.inner.system.MySystem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * @author Rainbow Yang
 */
public class CoordinateSystemListener extends MouseAdapter {

    private MouseEvent first, last;

    @Override
    public void mousePressed(MouseEvent e) {
        first = e;
        last = e;
    }

    //坐标系移动
    @Override
    public void mouseDragged(MouseEvent e) {
        if (first.getButton() == MouseEvent.BUTTON1) {
            MySystem.INSTANCE.getCoordinateSystem().getEventListener().accept(new MoveEvent(last, e));
        } else if (first.getButton() == MouseEvent.BUTTON3) {
            MySystem.INSTANCE.getCoordinateSystem().getEventListener().accept(new RotateEvent(last, e));
        }

        last = e;
    }

    //缩放效果
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MySystem.INSTANCE.getCoordinateSystem().getEventListener().accept(new ZoomEvent(e));
    }
}
