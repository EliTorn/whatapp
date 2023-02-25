import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class UserInputWindow extends JFrame {

    public final int Window_Width = 500, Window_Height = 400;

    public UserInputWindow(ChromeDriver driver) {
        OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
        JLabel label = new JLabel();
        label.setText("ההתחברות בוצעה בהצלחה");
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setBounds((Window_Width / 5), Window_Height / 10, Window_Width, Window_Height / 8);
        openWindow.add(label);

        JLabel number = new JLabel();
        number.setText("please write your number: ");
        number.setBounds(Window_Width / 15, label.getY() + label.getHeight() + Window_Height / 10, Window_Width / 3, Window_Height / 10);
        number.setFont(new Font("Arial", Font.BOLD, 12));
        openWindow.add(number);

        JLabel message = new JLabel();
        message.setText("please write your message: ");
        message.setFont(new Font("Arial", Font.BOLD, 12));
        message.setBounds(Window_Width / 2 + Window_Width / 20, label.getY() + label.getHeight() + Window_Height / 10, Window_Width / 3, Window_Height / 10);
        openWindow.add(message);

        JTextField textBoxNum = new JTextField(0);
        textBoxNum.setBounds(Window_Width / 15, number.getY() + number.getHeight(), Window_Width / 3, Window_Height / 10);
        openWindow.add(textBoxNum);

        JTextField textBoxMas = new JTextField(5);
        textBoxMas.setBounds(Window_Width / 2 + Window_Width / 20, message.getY() + message.getHeight(), Window_Width / 3, Window_Height / 10);
        openWindow.add(textBoxMas);

        JButton button = new JButton("Send");
        button.setBounds(Window_Width / 3 - 10, (textBoxMas.getY() + textBoxMas.getHeight() + Window_Height / 7), Window_Width / 3, Window_Height / 10);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        openWindow.add(button);

        button.addActionListener((event) -> {
            String saveMas = textBoxMas.getText();
            String saveNum = textBoxNum.getText();
            openWindow.dispose();
            CheckUserData files = new CheckUserData(saveMas, saveNum, driver);

        });

        openWindow.setVisible(true);
    }
}
