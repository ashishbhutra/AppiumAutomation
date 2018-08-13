package utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ExtractCode {
    private final static String SMS_POPUP_CLASSPATH = "C:\\Users\\ashish.bhutra\\workspace\\TubbrAutomation\\src\\test\\resources\\apps";
    private final static String SMS_POPUP_APP_NAME = "SMSPopup.apk";
    private final static String SMS_POPUP_PACKAGE_NAME = "net.everythingandroid.smspopup";
   // private final static String DEVICE_ID = "your_device_id";

    private final static String ADB_INSTALL_COMMAND = "adb -s %s install -r %s";
    private final static String ADB_UNINSTALL_COMMAND = "adb -s %s uninstall %s";
    private final static String ADB_START_ACTIVITY = "adb -s %s shell am start -n net.everythingandroid.smspopup/.ui.SmsPopupConfigActivity";
    private final static String ADB_GO_BACK = "adb -s %s shell input keyevent 4";

   // private final static String TYPE_SEARCH_TEXT_STARTSWITH = "IM-NOTICE";
   // private final static String TYPE_SEARCH_TEXT_CONTAINS = "tubbr verification code";
    private final static String TYPE_SEARCH_TEXT = "text";

    private WebDriverWait wait60;
    private Wait<WebDriver> fluentWait30;
    private AndroidDriver<MobileElement> localDriver;

    public ExtractCode(AndroidDriver<MobileElement> driver) {
 
        localDriver = driver;
        wait60 = new WebDriverWait(driver, 90);
        fluentWait30 = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }
    
    public void installSMSAPK(String DEVICE_ID) throws Exception {
        /*
        If you do not always want to install SMS APK then
        check if package already exists in device:
        adb shell pm list packages net.everythingandroid.smspopup
        it will reply
        package:[your.package.name]
        if it is installed already or anything otherwise
        FOR NOW I'll junst uninstall it always or else current configureSMSAPK() would fail
        */
        this.uninstallSMSAPK(DEVICE_ID);

        runADBCommand(String.format(ADB_INSTALL_COMMAND, DEVICE_ID, new File(SMS_POPUP_CLASSPATH, SMS_POPUP_APP_NAME).getAbsolutePath()));
        Thread.sleep(6000); //--> This can be replaced by checking if package is already installed. In slower devices this sleep may not be enough
    }

    public void uninstallSMSAPK(String DEVICE_ID) throws Exception {
        runADBCommand(String.format(ADB_UNINSTALL_COMMAND, DEVICE_ID, SMS_POPUP_PACKAGE_NAME));
        Thread.sleep(2000);
    }

    public void configureSMSAPK(String DEVICE_ID) throws Exception {

        runADBCommand(String.format(ADB_START_ACTIVITY, DEVICE_ID));
        waitForIDwithText("android:id/button1","Accept",TYPE_SEARCH_TEXT).click();
        runADBCommand(String.format(ADB_GO_BACK, DEVICE_ID));
    }

    public String returnSMS(String DEVICE_ID) throws Exception {
        String SMS;

        waitForID("net.everythingandroid.smspopup:id/popupMessageMainlayout");
        SMS = waitForID("net.everythingandroid.smspopup:id/messageTextView").getText();
        runADBCommand(String.format(ADB_GO_BACK, DEVICE_ID));
        return SMS;
    }



    /*
    * PRIVATE METHODS
    * */

    private void runADBCommand(String command) throws Exception {
        Runtime.getRuntime().exec(command);
    }

    /*
    * @parameter id Indicates the id of Element to be searched
    * @parameter value Indicates the text in Element to be searched
    * @parameter typeSearch Indicates the type of search [textStartsWith|textContains|text]
    * */
    private MobileElement waitForIDwithText(String id, String value, String typeSearch) throws Exception {
        try {
          //  String query = "new UiSelector().resourceId(\"" + id + "\")." + typeSearch + "(\"" + value + "\")";
            return fluentWait30.until(webDriver -> (localDriver).findElementById(id));
        } catch (Exception ex) {
            throw new Exception("The following id was not found: "+id);
        }
    }

    /*
    * @parameter id Indicates the id of Element to be searched
    * */
    private WebElement waitForID(String id) throws Exception {
        try {
            return wait60.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch (Exception ex) {
            throw new Exception("The following id was not found: "+id);
        }
    }
}
