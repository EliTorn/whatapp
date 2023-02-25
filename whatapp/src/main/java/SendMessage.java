import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SendMessage {


    public SendMessage(ChromeDriver driver) {


        String massage;
        try {
            massage = readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        WebElement putMassage = driver.findElement(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div.p3_M1 > div > div._13NKt.copyable-text.selectable-text"));
        putMassage.sendKeys(massage);//הדבקת ההודעה בשורת הטקסט

        WebElement element = driver.findElement(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div._3HQNh._1Ae7k"));
        element.click();//שליחתת ההודעה


        while (true) {//בדיקה האם יש V אחד וקריאה לפונקציה
            if (driver.getPageSource().contains(" נשלחה ")) {
                CheckStatus checkStatus = new CheckStatus(driver);
                break;
            }
        }


    }

    public static String readFile() throws FileNotFoundException {
        File path = new File("textBoxMas.txt");
        Scanner scanner = new Scanner(path);
        return scanner.nextLine();
    }

}
