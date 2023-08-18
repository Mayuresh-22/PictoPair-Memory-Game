package Layout;

import javax.swing.*;
import java.awt.*;

public class LoadingLayout {
    JPanel LoadingPanel = new JPanel(null), bg = new JPanel(new BorderLayout()), logo = new JPanel(new BorderLayout());
    JLabel bg;
    
    public LoadingLayout(){
        bg = new JLabel();
        bg.setBounds(100, 100, 100, 100);
        bg.setBackground(Color.red);
        LoadingPanel.add(bg);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }
}
