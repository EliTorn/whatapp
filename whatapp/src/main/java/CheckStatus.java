import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class CheckStatus extends JFrame {
    

    public static final int Window_Width = 400, Window_Height = 250;
    ChromeDriver driver;

    OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
    final int x = 100, y = 60, width = 250 ;
    JLabel label = new JLabel();

    public CheckStatus(ChromeDriver driver) {
        this.driver = driver;

        initWindow();

        label.setText("V");
        openWindow.revalidate();

        waitSend();
    }

    public void initWindow() {

        label.setBounds(x, y, width, Window_Height / 5);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        openWindow.add(label);
        openWindow.setVisible(true);
    }

    public void waitSend() {
        Thread thread = new Thread(() -> {
            while (true) {
                boolean oneCheck = driver.getPageSource().contains(" נשלחה ");

                if (!oneCheck) {

                    label.setText("V V");
                    openWindow.revalidate();
                    waitRead();

                    break;
                }
            }
        });
        thread.start();
    }

    public void waitRead() {//בדיקה האם ההודעה נקראה
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (!driver.getPageSource().contains(" נמסרה ")) {
                    label.setText("ההודעה נקראה!");
                    openWindow.revalidate();
                    driver.close();
                    break;

                }

            }
        });
        thread1.start();


    }


}