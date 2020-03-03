import driver.MobileDriver;
import org.junit.Test;

public class EnterToDevice {

    MobileDriver mobileDriver =new MobileDriver();

    @Test
    public void enterToGoogleTest() throws InterruptedException {
        mobileDriver.enterToGoogleInDevice();
    }


}
