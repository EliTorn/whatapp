import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CheckUserData extends JFrame {

    public static final int Window_Width = 400, Window_Height = 250;

    File mas = new File("textBoxMas.txt");
    File num = new File("textBoxNum.txt");

    public CheckUserData(String message, String number, ChromeDriver driver) {   // Checks whether all data entered is valid
        final int x = 70, y = 50, width = 400, height = 100, sizeColor = 20;
        boolean bMas = true, bNum = true;

        if (message.length() == 0) {
            OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
            JLabel label = new JLabel("You didn't enter massage!");
            label.setBounds(x, y, width, height);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            openWindow.add(label);
            openWindow.setVisible(true);


            bMas = false;

        } else if (number.length() == 0) {
            OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
            JLabel label = new JLabel("You didn't enter number!");
            label.setBounds(x, y, width, height);
            label.setFont(new Font("Arial", Font.BOLD, sizeColor));
            openWindow.add(label);
            openWindow.setVisible(true);

            bNum = false;

        } else {
            try {
                FileWriter writerMas = new FileWriter(mas);
                FileWriter writerNum = new FileWriter(num);

                writerNum.write(number);
                writerNum.close();

                writerMas.write(message);
                writerMas.close();

                String strNum = readFromFile(num);
                bNum = checkNum(strNum);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        if (bNum && bMas) {
            try {
                OpenChat openChat = new OpenChat(driver);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static boolean checkNum(String str) {
        if (str.charAt(0) != '0' || str.charAt(1) != '5' || str.length() != 10) {
            OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
            JLabel label = new JLabel("Your number not proper!");
            label.setBounds(70, 50, 400, 100);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            openWindow.add(label);
            openWindow.setVisible(true);


            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (str.charAt(i) > 57 || str.charAt(i) < 48) {
                OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
                JLabel label = new JLabel("You can only enter numbers!");
                label.setBounds(70, 50, 400, 100);
                label.setFont(new Font("Arial", Font.BOLD, 20));
                openWindow.add(label);
                openWindow.setVisible(true);
                return false;
            }
        }
        return true;
    }

    public static String readFromFile(File file) {   // read the text that the user entered.
        String text;
        try {
            Scanner scanner = new Scanner(file);
            text = scanner.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
