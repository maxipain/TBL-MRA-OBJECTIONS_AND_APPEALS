package StepDefinitions;


import Utils.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public Actions actions;
    public JavascriptExecutor jse;
    public String attachment = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";


    public static sharedatastep sharedata;


    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("MRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.xpath("//button[span='Login']")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();
    }

    public void switchToFrameBackoffice() {
        WebElement frame = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to backoffice frame")
    public void switchToBoFrame() {
        switchToFrameBackoffice();
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @And("Click on Taxpayer services > Certificate Types > Create certificate request")
    public void clickOnTaxpayerServicesCertificateTypesCreateCertificateRequest() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Services']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Certificate Types']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a"))).click();
    }


    @When("User navigates to Objections and Appeals > Lodge objection")
    public void userNavigatesToObjectionsAndAppealsLodgeObjection() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Objections and Appeals']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Lodge Objection Application']"))).click();
    }

    @Then("Searches for taxpayer tin {string}")
    public void searchesForTaxpayerTin(String tin) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[span='Search']")).click();
    }


    @Then("Enter attachment schedule {string}")
    public void enterAttachmentSchedule(String docType) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("LodgeObjection:objectionAttachmentsHandler:AddAttachment")).click();
        switchToFrameBackoffice();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ObjectionAppealAttachmentDetails:DocType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + docType + "')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ObjectionAppealAttachmentDetails:Reference")).sendKeys(getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.id("ObjectionAppealAttachmentDetails:AttachmentPath_input")).sendKeys(attachment);
        Thread.sleep(600);
        driver.findElement(By.id("ObjectionAppealAttachmentDetails:Ok")).click();
        switchToDefault();

    }

    @Then("Enter disputed amount {string} and summary of objection")
    public void enterDisputedAmountAndSummaryOfObjection(String amount) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("LodgeObjection:lodgeObjectionDisputed_input"))).sendKeys(amount);
        Thread.sleep(1000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("LodgeObjection:lodgeObjectionSummary"))).sendKeys("SUMMARY : " + getRandom(7));
        Thread.sleep(1000);
    }

    @Then("Submit Objection Application")
    public void submitObjectionApplication() throws InterruptedException {
        Thread.sleep(3000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("LodgeObjection:lodgeObjectionSubmit"))).click();
    }


    @Then("Obtain Objection Case number {string}")
    public void obtainObjectionCaseNumber(String SuccessMessage) {
        String FullMessage = driver.findElement(By.xpath("//span[contains(text(),'" + SuccessMessage + "')]")).getText();
        System.out.println(FullMessage);
        //Objection lodged successfully with reference number OBJ/00000040/2021
        sharedatastep.ObjectionRefNumber = FullMessage.substring(52);

        System.out.println(sharedatastep.ObjectionRefNumber);
    }

    @Given("Open CRM URL Module as {string}")
    public void openCRMURLModuleAs(String username) {
        driver.get("https://" + username + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("Close Popup Window")
    public void closePopupWindow() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebElement specificframe = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("Click on Case management dropdown")
    public void clickOnCaseManagementDropdown() throws Throwable {
        switch_to_frame0();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Active Cases in Progress Overview')]"))).isDisplayed();
        switchToDefault();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
        Thread.sleep(1000);
    }

    @And("click on Queues")
    public void clickOnQueues() {
        driver.findElement(By.xpath("//*[text()='Queues']")).click();
    }

    @And("enters service request reference number in search results")
    public void entersServiceRequestReferenceNumberInSearchResults() throws InterruptedException {
        WebElement search = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(1000);

//        search.sendKeys("*OBJ/00000113/2022");
        search.sendKeys("*" + sharedatastep.ObjectionRefNumber);
        Thread.sleep(1000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @And("tick case checkbox")
    public void tickCaseCheckbox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement pickCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        actions.click(pickCheckBox).perform();
        driver.switchTo().defaultContent();
    }

    @And("pick the case from dropdown")
    public void pickTheCaseFromDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement pickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick")));
        pickButton.click();
    }

    @And("^pick the case$")
    public void pick_the_case() throws Throwable {
        WebElement pickButton = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Pick ']")));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.doubleClick(pickButton).perform();
    }

    @Then("Click on reference number")
    public void clickOnReferenceNumber() {
        WebElement elementLocator = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @And("wait for plan to load {string}")
    public void waitForPlanToLoad(String arg0) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 250);

        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_ObjectionAppealApplicationAngular")));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + arg0 + "']")));

        //close error alert
        switchToDefault();
        Thread.sleep(7000);
        if(driver.findElements(By.id("InlineDialog_Iframe")).size()>0){
            driver.switchTo().frame("InlineDialog_Iframe");
            driver.findElement(By.id("butBegin")).click();
            switchToDefault();
        }
        switch_to_frame1();

    }

    @And("Select status as accepted for review")
    public void selectStatusAsAcceptedForReview() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("header_process_tbg_ordreviewresults_c")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("Select status as rejected for review")
    public void selectStatusAsRejectedForReview() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("header_process_tbg_ordreviewresults_c")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Save objection application")
    public void saveObjectionApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_objectionappealapplication|NoRelationship|Form|Mscrm.Form.tbg_objectionappealapplication.Save")).click();
    }

    @Then("Case status should be {string}")
    public void caseStatusShouldBe(String status) throws InterruptedException {
        driver.switchTo().frame("contentIFrame1");
        Thread.sleep(3000);
        String text = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + status + "']"))).getText();
        Assert.assertEquals(status, text);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }

    @And("Select status as accepted for finalization")
    public void selectStatusAsAcceptedForFinalization() throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("header_process_tbg_orreviewresults")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
    }

    @Then("Enter Approval note")
    public void enterApprovalNote() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("tbg_orrejectionnotes")).click();
        actions.sendKeys("Rejection notes : " + getRandom(6)).perform();
    }

    @Then("Select review results as decreased and amount discharged as {string}")
    public void selectReviewResultsAsDecreasedAndAmountDischargedAs(String amount) throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("header_process_tbg_foreviewresults")).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_foamountdischarge")).click();
        actions.sendKeys(amount).sendKeys(Keys.TAB).perform();

        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_fodateoffinalisation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_fodateoffinalisation_iDateInput")).sendKeys(todaysDate());

        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_fofinalisationnotes")).click();
        actions.sendKeys(getRandom(7)).sendKeys(Keys.TAB).perform();

    }

    @When("User navigates to Objections and Appeals > Lodge appeal")
    public void userNavigatesToObjectionsAndAppealsLodgeAppeal() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Objections and Appeals']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Lodge Appeal']"))).click();
    }

    @Then("Search for previous objection case")
    public void searchForPreviousObjectionCase() throws InterruptedException {
//        sharedatastep.ObjectionRefNumber = "OBJ/00000113/2022";
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:caseNo"))).sendKeys(sharedatastep.ObjectionRefNumber);
        Thread.sleep(700);
        driver.findElement(By.xpath("//button[span='Search']")).click();
    }

    @Then("Submit Appeal application")
    public void submitAppealApplication() {
        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("LodgeAppeal:submitLodgeAppeal"))).click();
    }

    @Then("Fill in appeal details with appeal amount {string}")
    public void fillInAppealDetailsWithAppealAmount(String amount) throws InterruptedException {
        Thread.sleep(3000);
        sixty.until(ExpectedConditions.visibilityOfElementLocated(By.id("LodgeAppeal:lodgeAppealAmount_input"))).sendKeys(amount);
        Thread.sleep(700);
        driver.findElement(By.id("LodgeAppeal:lodgeAppealReason")).sendKeys("Reason : " + getRandom(7));
        Thread.sleep(700);
        driver.findElement(By.xpath("//*[@id=\"LodgeAppeal:lodgeAppealMinAmt\"]/div[2]/span")).click();
        Thread.sleep(700);
        driver.findElement(By.id("LodgeAppeal:lodgeAppealReceiptNo")).sendKeys(String.valueOf(timestamp.getTime()));
    }


    @Then("Select review type and tick check payment receipt numbers")
    public void selectReviewTypeAndTickCheckPaymentReceiptNumbers() throws InterruptedException {
        driver.switchTo().frame("WebResource_ObjectionAppealApplicationAngular");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-objection-and-appeal/app-appeal-detail/div/form/div[1]/div[1]/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/label")).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[label='Check Payment Receipt Numbers?']/following-sibling::div/div/p-checkbox/div/div[2]")).click();
    }

    @Then("Select appeal stage 1 status as approved")
    public void selectAppealStatusAsApproved() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("header_process_tbg_appealreviewresultsstage1")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Save appeal application")
    public void saveAppealApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_objectionappealapplication|NoRelationship|Form|Mscrm.Form.tbg_objectionappealapplication.Save")).click();
    }


    @Then("Select appeal stage two status as approved")
    public void selectAppealStageTwoStatusAsApproved() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("header_process_tbg_appealreviewresultsstage2")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Select appeal stage three status as approved")
    public void selectAppealStageThreeStatusAsApproved() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("header_process_tbg_appealreviewresultsstage3")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Enter approval note for stage three")
    public void enterApprovalNoteForStageThree() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.id("tbg_appealrejectionnotesstage3_d")).click();
        actions.sendKeys("Approval notes : " + getRandom(6)).perform();
    }

    @Then("Enter finalization decision and amount discharge as {string}")
    public void enterFinalizationDecisionAndAmountDischargeAs(String amount) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("header_process_tbg_appealfinalizationdecision")).click();
       // actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_appealamountdischarge")).click();
        actions.sendKeys(amount).sendKeys(Keys.TAB).perform();

        Thread.sleep(1000);
        driver.findElement(By.id("header_process_tbg_appealfinalizationnote_i")).click();
        actions.sendKeys(amount).sendKeys(Keys.TAB).perform();
    }

    @When("User navigates to Objections and Appeals > Search case status")
    public void userNavigatesToObjectionsAndAppealsSearchCaseStatus() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Objections and Appeals']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Search Case Status']"))).click();
    }

    @Then("Enter wrong case number")
    public void enterWrongCaseNumber() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:caseNo"))).sendKeys(getRandom(5));
        Thread.sleep(400);
        driver.findElement(By.xpath("//button[span='Search']")).click();
    }

    @Then("Search for valid case")
    public void searchForValidCase() throws InterruptedException {
        Thread.sleep(3000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:caseNo"))).clear();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:caseNo"))).sendKeys(sharedatastep.ObjectionRefNumber);
        Thread.sleep(400);
        driver.findElement(By.xpath("//button[span='Search']")).click();
    }

    @Then("Verify case status as {string}")
    public void verifyCaseStatusAs(String status) {
        String currentStatus = seventy.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + status + "']"))).getText();
        Assert.assertEquals(status, currentStatus);
    }

    @And("Click reporting > reports")
    public void clickReportingReports() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        driver.findElement(By.xpath("//a[span='Reports']")).click();
    }

    @Then("Select report to print {string}")
    public void selectReportToPrint(String reportType) {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();
    }

    @Then("Select report file type {string}")
    public void selectReportFileType(String reportFormat) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("Select start date as today")
    public void selectStartDateAsToday() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:StartDate_input"))).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("Click run report")
    public void clickRunReport() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("frmReportDetails:RunReport")).click();
    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(10000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }

    @Given("User navigates to portal")
    public void userNavigatesToPortal() {
        driver.get(Pro.getProperty("MRA_Portal_URL"));
        driver.manage().window().maximize();
    }

    @Then("Enters the username {string} and password {string} to login to portal")
    public void entersTheUsernameAndPasswordToLoginToPortal(String username, String password) {

        twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_userName"))).sendKeys(username);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_password"))).sendKeys(password);
        driver.findElement(By.id("btnSubmit")).click();

    }

    @And("Navigate to my tax > Submit an Objection")
    public void navigateToMyTaxSubmitAnObjection() {
        WebElement mytax = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnMyTax")));
        jse.executeScript("arguments[0].click()", mytax);
        WebElement certRequest = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnSubmitAnObjectionAppeal")));
        jse.executeScript("arguments[0].click()", certRequest);
    }

    @Then("CLick next to proceed to disputed amount screen")
    public void clickNextToProceedToDisputedAmountScreen() {
        WebElement element = fourty.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next ']")));
        jse.executeScript("arguments[0].click()", element);
    }

    @Then("Enter disputed amount and Objection summary in taxpayer portal")
    public void enterDisputedAmountAndObjectionSummaryInTaxpayerPortal() throws InterruptedException {
        WebElement field1 = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_disputedAmount")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field1);
        field1.sendKeys("8000");
        Thread.sleep(900);

        WebElement field2 = fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_objectionSummary")));
        jse.executeScript("arguments[0].scrollIntoView(true);", field2);
        field2.sendKeys("Summary - " + getRandom(5));
        Thread.sleep(900);
    }

    @Then("Search for disputed transaction details")
    public void searchForDisputedTransactionDetails() throws InterruptedException {
        driver.findElement(By.id("btnAdd")).click();

        //search for transaction
        WebElement search = seventy.until(ExpectedConditions.elementToBeClickable(By.id("btnSearch")));
        jse.executeScript("arguments[0].scrollIntoView(true);", search);
        search.click();

        //pick first one
        WebElement checkbox = seventy.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[span=' Manual Penalty ']/preceding-sibling::td/preceding-sibling::td/span[2]/div/p-tablecheckbox/div/div[2]")));
        Thread.sleep(5000);
        checkbox.click();

        Thread.sleep(3000);
        thirty.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd"))).click();

        fifty.until(ExpectedConditions.elementToBeClickable(By.id("id_disputedAmount"))).isDisplayed();

        //click next
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Next ']")).click();

    }


    @Then("Add attachment {string}")
    public void addAttachment(String type) throws InterruptedException {
        WebElement add = seventy.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New']")));
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click()", add);

        Thread.sleep(1000);
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"id_attachmentForm\"]/div/div/tb-dropdown/div/div[2]/p-dropdown/div/div[3]"));
        jse.executeScript("arguments[0].click()", dropdown);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[span='" + type + "']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"id_reference\"]")).sendKeys(getRandom(8));
        Thread.sleep(1000);
        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
        driver.findElement(By.xpath("//*[@id=\"id_fileChoose\"]/div/div[2]/div/div/div[1]/span/input")).sendKeys(path);
        Thread.sleep(1000);
        driver.findElement(By.id("id_notes")).sendKeys("Notes " + getRandom(5));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }

    @Then("Submit portal application")
    public void submitPortalApplication() throws InterruptedException {
        WebElement checkbox = fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_objection_summary_form\"]/div/div/div/div/div/div/tb-checkbox/div/div[2]/p-checkbox/div/div[2]")));
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click()", checkbox);

        Thread.sleep(800);
        driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
    }

    @Then("Verify portal success message {string}")
    public void verifyPortalSuccessMessage(String success) {
        WebElement message = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]")));
        Assert.assertTrue(message.isDisplayed());
    }

    @Then("Obtain portal objection ref number {string}")
    public void obtainPortalObjectionRefNumber(String success) throws InterruptedException {
        String message = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + success + "')]"))).getText();
        //Your Objection request has been submitted successfully. Your reference number is: OBJ/00000056/2021
        System.out.println(message);
        System.out.println("Portal Objection Case Reference Number is " + message.substring(82));
        sharedatastep.ObjectionRefNumberPortal = message.substring(82);
        Thread.sleep(1000);
    }

    @Then("Navigate to my tax > view an objection or appeal")
    public void navigateToMyTaxViewAnObjectionOrAppeal() {
        WebElement mytax = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnMyTax")));
        jse.executeScript("arguments[0].click()", mytax);
        WebElement certRequest = fourty.until(ExpectedConditions.elementToBeClickable(By.id("id_btnViewAnObjectionAppeal")));
        jse.executeScript("arguments[0].click()", certRequest);
    }

    @Then("Confirm case status")
    public void confirmCaseStatus() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[span='"+sharedatastep.ObjectionRefNumberPortal+"']")));
    }

    @Then("Click next in attachments screen")
    public void clickNextInAttachmentsScreen() {
        WebElement next = fourty.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next ']")));
        jse.executeScript("arguments[0].click()", next);
    }

    @When("User navigates to Objections and Appeals > Withdraw objection")
    public void userNavigatesToObjectionsAndAppealsWithdrawObjection() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Objections and Appeals']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Withdraw Objection']"))).click();
    }

    @Then("Verify case number")
    public void verifyCaseNumber() {
        String current = seventy.until(ExpectedConditions.visibilityOfElementLocated(By.id("WithdrawObjection:withdrawObjectionCaseNo"))).getAttribute("value");
        Assert.assertEquals(current,sharedatastep.ObjectionRefNumber);
    }

    @Then("Select reason for withdrawal as {string}")
    public void selectReasonForWithdrawalAs(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"WithdrawObjection:WithdrawObjectionReason\"]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + arg0 + "')]")).click();
        Thread.sleep(1000);
    }

    @Then("Submit objection withdrawal application")
    public void submitObjectionWithdrawalApplication() {
        driver.findElement(By.id("WithdrawObjection:WithdrawObjectionNoteSubmit")).click();
    }

    @When("User navigates to Objections and Appeals > Withdraw appeal")
    public void userNavigatesToObjectionsAndAppealsWithdrawAppeal() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Objections and Appeals']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Withdraw Appeal']"))).click();
    }

    @Then("Verify case number for appeal")
    public void verifyCaseNumberForAppeal() {
        String current = seventy.until(ExpectedConditions.visibilityOfElementLocated(By.id("WithdrawAppeal:WithdrawAppealCaseNo"))).getAttribute("value");
        Assert.assertEquals(current,sharedatastep.ObjectionRefNumber);
    }

    @Then("Select reason for appeal withdrawal as {string}")
    public void selectReasonForAppealWithdrawalAs(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"WithdrawAppeal:WithdrawAppealReason\"]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + arg0 + "')]")).click();
        Thread.sleep(1000);
    }

    @Then("Submit appeal withdrawal application")
    public void submitAppealWithdrawalApplication() {
        driver.findElement(By.id("WithdrawAppeal:WithdrawAppealSubmit")).click();
    }


    @Then("Enter Approval note and select reason")
    public void enterApprovalNoteAndSelectReason() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.id("tbg_ordrejectionnotes_i")).click();
        actions.sendKeys("Rejection notes : " + getRandom(6)).perform();

        switchToDefault();
        switch_to_frame1();
        WebElement reasonFrame = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_ObjectionAppealRejectionDataReferenceResource")));
        driver.switchTo().frame(reasonFrame);
        driver.findElement(By.id("viewoption")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i\"]/option[2]"))).click();
        Thread.sleep(2000);
    }

    @Then("Select objection type as {string}")
    public void selectObjectionTypeAs(String arg0) throws InterruptedException {
         WebElement objectionType = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/label[text()='"+arg0+"']/preceding-sibling::div")));
         Thread.sleep(1000);
         objectionType.click();

    }

    @Then("Select portal objection type as {string}")
    public void selectPortalObjectionTypeAs(String arg0) throws InterruptedException {
        WebElement objectionType = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_objection_application_form\"]/div/div/div/div[2]/tb-checkbox[1]/div/div[2]/p-checkbox/div/div[2]")));
        Thread.sleep(1000);
        objectionType.click();
    }

    @Then("Add disputed transaction details with document reference {string}")
    public void addDisputedTransactionDetailsWithDocumentReference(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("LodgeObjection:disputedTransactionHandler:AddDisputed")).click();
        switchToFrameBackoffice();
        WebElement docRef = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:DocumentReference")));
        Thread.sleep(1000);
        docRef.sendKeys(arg0);
        driver.findElement(By.xpath("//button[span='Search']")).click();
        switchToDefault();
        sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+arg0+"']"))).isDisplayed();
        Thread.sleep(1000);
    }


}



