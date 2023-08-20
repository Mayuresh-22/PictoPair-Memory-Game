import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.*;
import external.*;

// Devang App Changed - 04

class App {
    JFrame app = new JFrame("PictoPair - Memory Game");
    LoadingLayout loadingLayout = new LoadingLayout();
    HomeLayout homeLayout = new HomeLayout();
    GameLayout gameLayout = new GameLayout();
    MusicPlayerThread soundEffect = new MusicPlayerThread();
    MusicPlayerThread musicPlayer = new MusicPlayerThread();

    App(){
        appConfig();
        app.add(loadingLayout.getLoadingPanel(), BorderLayout.CENTER);
        soundEffect.filePath = "assets/sounds/intro.wav";
        soundEffect.loop = false;
        soundEffect.start();

        // Remove LoadingPanel after 5 seconds
        Timer timer = new Timer(4900, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.remove(loadingLayout.getLoadingPanel());
                app.add(gameLayout.getGamePanel(), BorderLayout.CENTER);
                app.revalidate();
                app.repaint();
                musicPlayer.filePath = "assets/sounds/bgm.wav";
                musicPlayer.loop = true;
                musicPlayer.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        app.setVisible(true);
    }

    // app configuration
    public void appConfig(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setMinimumSize(screenSize);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new BorderLayout(100, 100));
        app.setIconImage(new ImageIcon("assets/images/card-back.png").getImage());
    }

}


class PictoPair {
    public static void main(String[] args) {
        new App();
    }
}
