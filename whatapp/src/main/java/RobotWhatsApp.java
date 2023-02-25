import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RobotWhatsApp {

    public static final int Window_Width = 400, Window_Height = 300;

    public static void main(String[] args) {
        run();
    }


    public static void run() {
        OpenWindow openWindow = new OpenWindow(Window_Width, Window_Height);
        JButton button = new JButton("Open WhatApp");
        button.setBounds(40, 100, Window_Height, Window_Height / 5);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        openWindow.add(button);
        openWindow.setVisible(true);
        button.addActionListener((even) -> {
            openWindow.dispose();
            openTheWhatsApp();
        });
    }


    public static void openTheWhatsApp() {  // this method open the WhatsApp
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\User\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");


        Thread thread = new Thread(() -> {
            while (true) {         //  it checks if the suer is in the WhatsApp window

                List<WebElement> linkedList = driver.findElements(By.cssSelector("#side > div.uwk68 > div > div > div._16C8p > div > div._13NKt.copyable-text.selectable-text"));

                if (!(linkedList.size() == 0)) {
                    UserInputWindow userInputWindow = new UserInputWindow(driver);
                    break;
                }


            }
        });
        thread.start();
    }

}

// eliyahu  ->  "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\Eli\\chromedriver.exe";
// yoni  -> "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
// eli -> "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe"