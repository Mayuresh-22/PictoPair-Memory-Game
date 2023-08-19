package layout;

import javax.swing.*;
import interfaces.*;
import java.awt.*;

public class LoadingLayout implements ScreenStructure{
    JPanel LoadingPanel = new JPanel(null), bgPanel = new JPanel(new BorderLayout()), logoPanel = new JPanel(new BorderLayout());
    JLabel bg, logo;
    JLayeredPane layeredPane = new JLayeredPane();
    
    public LoadingLayout(){
        // LoadingPanel
        createLayeredPane();

        // bgPanel
        createBgPanel("assets/assets/LoadingScreen-bg.png");

        // logoPanel
        logo = new JLabel(new ImageIcon("assets/logogifclear.gif"));
        logoPanel.setBounds((width/2)-200, (height/2)-200, 400, 400);
        logoPanel.setOpaque(true);
        logoPanel.add(logo);

        // Add to LoadingPanel
        layeredPane.add(logoPanel, BorderLayout.CENTER);
        layeredPane.add(bgPanel);

        // Add to LoadingPanel
        LoadingPanel.add(layeredPane);
        LoadingPanel.setOpaque(true);
    }

    public JPanel getLoadingPanel() {
        return LoadingPanel;
    }

    public JLabel getBg() {
        return bg;
    }

    @Override
    public void createLayeredPane(){
        // layered pane
        layeredPane.setSize(ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        layeredPane.setBackground(Color.gray);
        layeredPane.setOpaque(true);
    }

    @Override
    public void createBgPanel(String imagePath){
        // bgPanel
        bg = new JLabel(new ImageIcon(imagePath));
        bgPanel.setBounds(0, 0, ScreenStructure.WIDTH, ScreenStructure.HEIGHT);
        bgPanel.setOpaque(true);
        bgPanel.add(bg);
    }
}
