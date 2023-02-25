import javax.swing.*;

public class OpenWindow extends JFrame {

    public static final int StartAt = 0;

    public OpenWindow (int Window_Width, int Window_Height){
        this.setLayout(null);
        this.setBounds(StartAt, StartAt, Window_Width, Window_Height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
