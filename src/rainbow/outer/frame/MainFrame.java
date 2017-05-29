package rainbow.outer.frame;

import rainbow.inner.system.MySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import static rainbow.outer.frame.tool.FrameLocationSetter.center;

/**
 * 主界面
 *
 * @author Rainbow Yang
 */
public class MainFrame extends JFrame {
    private int x;
    private int y;

    public static MainFrame mainFrame;

    {
        MySystem.getSystem().getInformation().initStartLog(getClass().getSimpleName());
    }

    public MainFrame() throws HeadlessException {
        mainFrame = this;
        MySystem.getSystem().getVersion().setTitle(this);
        MySystem.getSystem().getSize().setSize(this);
        center(this);
        MySystem.getSystem().getListeners().setListeners(this);

        add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(MySystem.getSystem().getViews().getImage(), 0, 0, null);
            }
        });
        MySystem.getSystem().getViews().setRepaint(MainFrame.mainFrame::repaint);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension d = e.getComponent().getSize();

                MySystem.getSystem().getSize().setWidth(d.getWidth());
                MySystem.getSystem().getSize().setHeight(d.getHeight());

                repaint();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

        MySystem.getSystem().getInformation().initEndLog(getClass().getSimpleName());
    }
}
