package edu.rpi.legup.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ZoomWidget extends JLabel {
    private final ScrollView parent;
    private final PopupSlider palette = new PopupSlider();
    private final MouseAdapter open = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            palette.slider.setValue(parent.getZoom());
            palette.show(e.getComponent(), 0, 0);
        }
    };

    /**
     * ZoomWidget Constructor creates a zoom widget for a ScrollView object
     *
     * @param parent dynamicView to which to the ZoomWidget is applied to
     */
    public ZoomWidget(ScrollView parent) {
        super(new ImageIcon("zoom.png"));
        this.parent = parent;
        addMouseListener(open);
    }

    /**
     *
     */
    private class PopupSlider extends JPopupMenu implements ChangeListener {
        private static final long serialVersionUID = 8225019381200459814L;

        private final JSlider slider;

        public PopupSlider() {
            slider = new JSlider(SwingConstants.VERTICAL, 0, 400, 200);
            slider.setMajorTickSpacing(25);
            slider.setPaintTicks(true);

            add(slider);
            slider.addChangeListener(this);
        }

        public void stateChanged(ChangeEvent e) {
            if (slider.getValueIsAdjusting()) {
                parent.zoomTo((double) slider.getValue() / 100.0);
            }
        }
    }
}
