package action_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static action_pages.NewAccountAdd.getAccountNo;

public class Deposit extends BasePage{

    @FindBy(linkText = "Deposit")
    WebElement deposit_option_from_dashboard;
    @FindBy(name="accountno")
    WebElement acc_no;

    @FindBy(name="ammount")
    WebElement deposit_amount;

    @FindBy(name="desc")
    WebElement deposit_desc;

    @FindBy(name="AccSubmit")
    WebElement acc_no_submit_btn;
    public Deposit(WebDriver driver) {
        super(driver);
    }

    public void depositAmount() throws InterruptedException {
        deposit_option_from_dashboard.click();
        Thread.sleep(2000);

        String Acc_No =getAccountNo();
        System.out.println("Acc No in Deposit Option : "+Acc_No);
        acc_no.sendKeys(Acc_No);
        Thread.sleep(2000);

        deposit_amount.sendKeys("1500");
        Thread.sleep(2000);

        deposit_desc.sendKeys("deposit");
        Thread.sleep(2000);

        acc_no_submit_btn.click();
        Thread.sleep(2000);

        //  Alert Case handle
        try {
            Alert alert = driver.switchTo().alert();
            //alert.dismiss();
            alert.accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("Alert was not present: " + e.getMessage());
        }
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);


        System.out.println("Deposit in New Account.");
    }
}
