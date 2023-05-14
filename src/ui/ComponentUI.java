package ui;

import java.awt.*;

public interface ComponentUI {
    int GWIDTH = (int) Toolkit.getDefaultToolkit()
            .getScreenSize()
            .getWidth();

    int GHEIGHT = (int) Toolkit.getDefaultToolkit()
            .getScreenSize()
            .getHeight();
}
