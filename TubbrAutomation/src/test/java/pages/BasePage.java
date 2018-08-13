package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * A base for all the pages within the suite
 */
public abstract class BasePage {

    /**
     * The driver
     */
    protected final AppiumDriver<?> driver;
    
    protected BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

}