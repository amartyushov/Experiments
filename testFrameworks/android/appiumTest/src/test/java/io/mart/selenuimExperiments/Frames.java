package io.mart.selenuimExperiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("http://fantasycricket.dream11.com/in/");
        //System.out.println(driver.findElement(By.className("loginTxt")));

        int number = findFrameNumber(driver, By.id("m_rtxtEmail1"));
        driver.switchTo().frame(number);
    }

    /**
     * In case you have several frames and not of them are visible all the time,
     * there is a workaround how to find particular frame and clink on element inside it
     * @param driver
     */
    static int findFrameNumber(WebDriver driver, By by){

        int frameCount = 5;
        int i;
        for (i = 0; i < frameCount; i++) {
            driver.switchTo().frame(i);

            int elementCount = driver.findElements(by).size();
            if (elementCount>0){
                driver.findElement(by).click();
                break; // in case you have found you element in second frame, save time and don`t loop other frames
            } else {
                System.out.println("Switching to another frame");
            }
        }

        //driver.switchTo().defaultContent(); //very important step while you are switching from frame to frame
        // and your frame are just independent frames, but not in parent-child relations
        // it is like you exit a frame and are back in main content

        // in case you deal with frame inside another frame, you cannot just switch to child frame,
        // you have to switch to parent first
        // and then switch to child frame

        return i;
    }
}
