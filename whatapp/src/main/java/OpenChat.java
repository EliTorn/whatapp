import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class OpenChat {


    public OpenChat(ChromeDriver driver) throws FileNotFoundException {
        final int towSeconds = 2000;
        driver.manage().window().maximize();
        String phoneNumber = readFile();
        driver.get(phoneNumber);
        WebElement click = driver.findElement(By.id("action-button"));
        click.click();
        try {
            Thread.sleep(towSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement chat = driver.findElement(By.cssSelector("#fallback_block > div > div > h4:nth-child(2) > a"));
        chat.click();//מעבר לדף של איש הקשר

        while (true) {

            List<WebElement> linkedList = driver.findElements(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div.p3_M1 > div > div._13NKt.copyable-text.selectable-text"));

            if (!(linkedList.size() == 0)) {//בדיקה האם הדף נטען
                SendMessage sendMessage = new SendMessage(driver);
                break;
            }
        }

    }

    public static String readFile() throws FileNotFoundException {
        File path = new File("textBoxNum.txt");
        Scanner scanner = new Scanner(path);
        String text = scanner.nextLine();
        return "https://api.whatsapp.com/send?phone=972" + text;
    }
}
