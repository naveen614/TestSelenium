package com.untd.testscripts;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;

public class NZnew_ISPSignupAndUpgrade extends TestNgIntegration {

	String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	private Properties runConfigProperties = null;
	private Properties envConfigProperties = SystemConfig.envConfigProperties;
	GeneralFunctions gf = new GeneralFunctions();
	FileOperations fo = new FileOperations();
	String VisaCcNum, ACH_RoutingNumber, ACH_AccountNumber;

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");
		
		//SeleniumDriver.webobj.deleteAllVisibleCookies();
		
		
		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);
		// ***********************
		// Read runconfig.properties file.
		runConfigProperties = new Properties();
		try {
			runConfigProperties.load(new FileInputStream(System
					.getProperty("user.dir")
					+ "/src/resources/config/nz_runconfig.properties"));

			// System.out.println("!!!!!:" + System.getProperty("user.dir") +
			// "/src/resources/config/ju_runconfig.properties");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		// **********************

		/*// ***********************
		// Read envconfig.properties file.
		envConfigProperties = new Properties();
		try {
			envConfigProperties.load(new FileInputStream(System
					.getProperty("user.dir")
					+ "/src/resources/config/envconfig.properties"));
			// System.out.println("Envconfig!!!!!:" +
			// System.getProperty("user.dir") +
			// "/src/resources/config/envconfig.properties");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}*/

		// **********************

		String env = runConfigProperties.getProperty("Env");
		System.out.println("Env:" + env);

		VisaCcNum = (envConfigProperties.getProperty(env + ".VisaCcNum"));
		ACH_AccountNumber = (envConfigProperties.getProperty(env
				+ ".ACHAccountNumber"));
		ACH_RoutingNumber = (envConfigProperties.getProperty(env
				+ ".ACHRoutingNumber"));
	}

	
	// /////Front Door Signups /////////

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Accelerator_Signup_CC_SUN() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();

	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		//gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click ("css=a.r16 > img"); //("link=SIGN UP NOW »");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// Verify Confirmation page
		gf.VerifyPageLoad(180, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Accelerator_Signup_ACH_MI() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click More Info link for Accelerated Dial-up plan
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("link=MORE INFO »");

		// Click Order Now button
		gf.VerifyPageLoad(60, "HiSpeed Accelerated Dial-Up",
				"Unable to find NetZero Accelerator Product page");
		gf.VerifyPageLoad(60, "Order Now",
				"Unable to find \"Order Now\" button on Product Page.");
		SeleniumDriver.webobj.click("css=span.fontU");

		// Fill Out Customer Information and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// Verify Confirmation Page
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Platinum_Signup_CC_SUN() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now button for Basic Dial-Up
		gf.VerifyPageLoad(60, "Basic  Dial-Up",
				"Unable to find Basic  Dial-Up plan on WWW page.");
		SeleniumDriver.webobj.click("//div[@id='top-center']/div[4]/a");

		// Fill out Customer Information page and submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Platinum_Signup_ACH_MI() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Basic Dial-Up More Info button
		gf.VerifyPageLoad(60, "Basic  Dial-Up",
				"Unable to find Basic  Dial-Up plan on WWW page.");
		SeleniumDriver.webobj.click("css=a.sss");

		// Click Order Now button
		gf.VerifyPageLoad(60, "Unlimited Internet Service at a Great Price",
				"Unable to find Basic Dial-Up Product Page.");
		gf.VerifyPageLoad(60, "Order Now",
				"Unable to find Basic Dial-Up Product Page.");
		SeleniumDriver.webobj.click("css=span.fontU");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// Verify Confirmation Page
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_FreeIsp_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click More Info link for Free Dial-Up Plan
		gf
				.VerifyPageLoad(
						60,
						"Enjoy reliable connections, plus Free NetZero Email. Easy signup, no obligation.",
						"Unable to find Accelerator Free Dial-Up Plan on WWW page.");
		SeleniumDriver.webobj.click("css=#freedialup > #moreinfo > a.u");

		// Verify the page and click Get Started button
		gf.VerifyPageLoad(60, "Free Dial-Up Internet Access",
				"Unable to find Free Dial-Up product page.");
		SeleniumDriver.webobj.click("css=nowrap");

		// Fill out Customer Information page and Submit
		String uid = WebRegFunctions.ISP_Free_EnterBasicInfo();

		// Verify Confirmation Page
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeIspConfirmationVerification");
			service = "FreeIsp";
			paytype = "Free";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free ISP Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Free ISP SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_FreeEmail_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click More Info link for Free Email Plan
		gf.VerifyPageLoad(60, "Free Email (with Video Mail)",
				"Unable to find Accelerator Free Email Plan on WWW page.");
		SeleniumDriver.webobj.click("css=#freeemail > #moreinfo > a.u");

		// Verify the page and click Get Started button
		gf.VerifyPageLoad(60, "Free Email with Video Mail & Video Chat",
				"Unable to find Free Email product page.");
		SeleniumDriver.webobj.click("css=nowrap");

		// Fill Out Customer Information form and Submit
		String uid = WebRegFunctions.ISP_Free_EnterBasicInfo();

		// Verify Confirmation Page
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("FreeIspConfirmationVerification");
			service = "FreeEmail";
			paytype = "Free";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free Email Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Free Email SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Accelerator_YearlyPlan_Signup_CC() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadFrontDoorPage");

		// Click Dial-Up tab
		gf.VerifyElementLoad(10, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click More Info link for Accelerator Yearly Plan
		gf
				.VerifyPageLoad(
						60,
						"Get the same accelerated dial-up service for only $9.95 a month with an annual payment.",
						"Unable to find Accelerator Yearly Plan on WWW page.");
		SeleniumDriver.webobj.click("css=a.u");

		// Verify the page and click Order Now button
		gf.VerifyPageLoad(60, "Only $9.95 a month",
				"Unable to find Accelerator Yearly Plan product page.");
		gf.VerifyPageLoad(60, "Order Now",
				"Unable to find Accelerator Yearly Plan product page.");
		gf
				.VerifyPageLoad(
						60,
						"$119.40 pre-paid annual plan renews at the then current price unless canceled",
						"Unable to find Accelerator Yearly Plan product page.");
		SeleniumDriver.webobj.click("css=span.fontU");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// Verify Confirmation page
		gf.VerifyPageLoad(180, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	// // Store Signups //////////

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		 WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		 
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreAccelSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_CC_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		 WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		
		
		 
		 driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreAccelSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
		// ACH_AccountNumber);
		// driver.runStep("AcceptingAndSubmitting");
		// regFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		//WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			//	"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		 WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		 
		 driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreAccelSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		//WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		//		"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_LEC_Signup() {

		 SeleniumDriver.webobj.deleteAllVisibleCookies();
		 WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreAccelSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "LEC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ACCELERATOR LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
	//	WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		//		"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StorePlatSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_CC_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StorePlatSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
		// ACH_AccountNumber);
		// driver.runStep("AcceptingAndSubmitting");
		// regFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StorePlatSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StorePlatSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "LEC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PLATINUM LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PLATINUM LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_EPack_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreEPSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyEPackConfirmationPage");
			service = "Epack";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Epack CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Epack CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_LearningEdge_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreLESignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyLEConfirmationPage");
			service = "Learningedge";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("LearningEdge ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("LearningEdge ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
	}

	@Test(groups = { "ISPSignup" })
	public void A_PCTuneUp_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StorePCTuneUpSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPCTuneUpConfirmationPage");
			service = "Pctuneup";
			paytype = "LEC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PC Tune Up LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PC Tune Up LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_ValuePack_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreVPSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyVPConfirmationPage");
			service = "Valuepack";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("ValuePack CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("ValuePack CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_MegaMail_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreMMSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMConfirmationPage");
			service = "Megamail";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MegaMail ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MegaMail ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
	}

	@Test(groups = { "ISPSignup" })
	public void A_MegaMailPlus_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreMMPlusSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMPlusConfirmationPage");
			service = "Mmplus";
			paytype = "LEC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Mega Mail Plus LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Mega Mail Plus LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Games_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreGamesSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("VerifyEPackConfirmationPage");
			service = "Games";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Games CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Games CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_Norton360_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_Store_Norton360_Signup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("VerifyEPackConfirmationPage");
			service = "Norton360";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Norton 360 CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Norton 360 CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_NAV_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreNAVSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("VerifyEPackConfirmationPage");
			service = "NAV";
			paytype = "ACH";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("NAV ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("NAV ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_NIS_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreNISSignup();
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("VerifyEPackConfirmationPage");
			service = "NIS";
			paytype = "LEC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("NIS LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("NIS LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_FreeISP_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreFreeDialUpSignup();
		String uid = WebRegFunctions.ISP_Free_EnterBasicInfo();
		// regFunctions.ISP_EnterBasicInfo();
		// regFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeIspConfirmationVerification");
			service = "FreeIsp";
			paytype = "Free";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free ISP Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Free ISP SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_FreeEmail_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadStorePage");

		WebRegFunctions.NZ_StoreFreeEmailSignup();
		String uid = WebRegFunctions.ISP_Free_EnterBasicInfo();
		// regFunctions.ISP_EnterBasicInfo();
		// regFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// SeleniumDriver.webobj.pause("50000");
		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// driver.runStep("FreeIspConfirmationVerification");
			service = "FreeEmail";
			paytype = "Free";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free Email Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("Free Email SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	// ///// Toll Free Signups /////

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_SOLP_MeteringOn_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadSOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("SolpTollFreeSignup");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Single Offer Landing Page TollFree CC Signup With Metering On  is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" SINGLE OFFER LANDING PAGE TOLLFREE CC SIGNUP WITH METERING ON IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_SOLP_MeteringOff_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadSOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SolpTollFreeSignup");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Single Offer Landing Page TollFree CC Signup With Metering Off  is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" SINGLE OFFER LANDING PAGE TOLLFREE CC SIGNUP WITH METERING OFF IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_DOLP_MeteringOn_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpTollFreeSignup");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Dual Offer Landing Page TollFree CC Signup With Metering On  is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" DUAL OFFER LANDING PAGE TOLLFREE CC SIGNUP WITH METERING ON IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_DOLP_MeteringOff_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpTollFreeSignup");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Dual Offer Landing Page TollFree CC Signup With Metering Off is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" DUAL OFFER LANDING PAGE TOLLFREE CC SIGNUP WITH METERING OFF IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFreeDOLP_Accel1495_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpAccel1495Signup");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Dual Offer Landing Page Accelerator 14.95 CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" DUAL OFFER LANDING PAGE ACCELERATOR 14.95 CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_Accessnumbers_MeteringOn_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadAccessNumbersTollFreeOfferPage");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Access Numbers Page TollFree CC Signup With Metering On is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" ACCESS NUMBERS PAGE TOLLFREE CC SIGNUP WITH METERING ON IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_Accessnumbers_MeteringOff_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		driver.runStep("LoadAccessNumbersTollFreeOfferPage");
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		// regFunctions.ISP_Toll_Free_Metering_On();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// driver.runStep("TFMeteringOn");
		// driver.runStep("AcceptingAndSubmitting");

		gf.VerifyPageLoad(120, "Order Details",
				"Unable to find Confirmation page.");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Access Numbers Page TollFree CC Signup With Metering Off is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" ACCESS NUMBERS PAGE TOLLFREE CC SIGNUP WITH METERING OFF IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	

	}


///////  Upgrades ///////
	// ISP to ISP
	@Test(groups = { "ISPUpgrades" })
	public void B_Platinum_CC_To_Accel_CC_Upgrade() {

		String filename = brand + "_Platinum_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;



		String uid = fo.doReadTextFile(filepath);
		
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		driver.runStep("LoadStartPage");
		
		//Login to Start page
		gf.VerifyElementLoad(60, "memberId", "Unable to find MemberID field on the Start Page");
		SeleniumDriver.webobj.type("memberId", uid);
		SeleniumDriver.webobj.type("password", pwd);
		Logger.info("Logged in with the member id: " + uid);

		driver.runStep("ClickingSigninButton");
		
		//Verify if Start page is loaded
		gf.VerifyPageLoad(120, "Sign Out", "Unable to find START PAGE");
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Select Product to Upgrade
		WebRegFunctions.NZ_StoreAccelSignup ();

		//If payment method is the same as original,  Submit the form
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		//Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
		"Unable to find Confirmation page.");
		
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_Platinum_CC_Accounts.txt";
			String dstnfilename = brand + "_Accel_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Platinum CC To Accel CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Logger
					.error("PLATINUM CC TO ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");


	}

	@Test(groups = { "ISPUpgrades" })
	public void B_Pctuneup_LEC_To_Accel_CC_Upgrade() {

		String filename = brand + "_Pctuneup_LEC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;



		String uid = fo.doReadTextFile(filepath);
		
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		driver.runStep("LoadStartPage");
		
		//Login to Start page
		gf.VerifyElementLoad(60, "memberId", "Unable to find MemberID field on the Start Page");
		SeleniumDriver.webobj.type("memberId", uid);
		SeleniumDriver.webobj.type("password", pwd);
		Logger.info("Logged in with the member id: " + uid);

		driver.runStep("ClickingSigninButton");
		
		//Verify if Start page is loaded
		gf.VerifyPageLoad(120, "Sign Out", "Unable to find START PAGE");
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Select Product to Upgrade
		WebRegFunctions.NZ_StoreAccelSignup ();

		//If payment method is NOT the same as original, select new Payment method and submit the form
		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		//Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
		"Unable to find Confirmation page.");
		
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_Pctuneup_LEC_Accounts.txt";
			String dstnfilename = brand + "_Accel_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PC Tune Up LEC To Accel CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Logger
					.error("PC Tune Up LEC TO ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");


	}
		
	@Test(groups = { "ISPUpgrades" })
	public void B_Learningedge_ACH_To_Platinum_CC_Upgrade() {

		String filename = brand + "_Learningedge_ACH_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;



		String uid = fo.doReadTextFile(filepath);
		
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		driver.runStep("LoadStartPage");
		
		//Login to Start page
		gf.VerifyElementLoad(60, "memberId", "Unable to find MemberID field on the Start Page");
		SeleniumDriver.webobj.type("memberId", uid);
		SeleniumDriver.webobj.type("password", pwd);
		Logger.info("Logged in with the member id: " + uid);

		driver.runStep("ClickingSigninButton");
		
		//Verify if Start page is loaded
		gf.VerifyPageLoad(120, "Sign Out", "Unable to find START PAGE");
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Select Product to Upgrade
		WebRegFunctions.NZ_StorePlatSignup ();

		//If payment method is NOT the same as original, select new Payment method and submit the form
		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		//Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
		"Unable to find Confirmation page.");
		
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			String srcfilename = brand + "_Learningedge_ACH_Accounts.txt";
			String dstnfilename = brand + "_Platinum_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("LearningEdge ACH To Platinum CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Logger
					.error("LearningEdge ACH TO Platinum CC Upgrade is NOT successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");


	}
	
	@Test(groups = { "ISPUpgrades" })
	public void B_NIS_LEC_To_Accel_ACH_Upgrade() {

		String filename = brand + "_NIS_LEC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;



		String uid = fo.doReadTextFile(filepath);
		
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		driver.runStep("LoadStartPage");
		
		//Login to Start page
		gf.VerifyElementLoad(60, "memberId", "Unable to find MemberID field on the Start Page");
		SeleniumDriver.webobj.type("memberId", uid);
		SeleniumDriver.webobj.type("password", pwd);
		Logger.info("Logged in with the member id: " + uid);

		driver.runStep("ClickingSigninButton");
		
		//Verify if Start page is loaded
		gf.VerifyPageLoad(120, "Sign Out", "Unable to find START PAGE");
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Select Product to Upgrade
		WebRegFunctions.NZ_StoreAccelSignup ();

		//If payment method is NOT the same as original, select new Payment method and submit the form
		WebRegFunctions.ISP_EnterPaymentInfo_ACH(ACH_RoutingNumber,
				ACH_AccountNumber);
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		//Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
		"Unable to find Confirmation page.");
		
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_NIS_LEC_Accounts.txt";
			String dstnfilename = brand + "_Accel_ACH_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("NIS LEC To Accel ACH Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Logger
					.error("NIS LEC TO ACCELERATOR ACH UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");


	}
		
	@Test(groups = { "ISPUpgrades" })
	public void B_Free_DialUp_To_Accel_LEC_Upgrade() {

		String filename = brand + "_FreeIsp_Free_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;



		String uid = fo.doReadTextFile(filepath);
		
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		driver.runStep("LoadStartPage");
		
		//Login to Start page
		gf.VerifyElementLoad(60, "memberId", "Unable to find MemberID field on the Start Page");
		SeleniumDriver.webobj.type("memberId", uid);
		SeleniumDriver.webobj.type("password", pwd);
		Logger.info("Logged in with the member id: " + uid);
		

		driver.runStep("ClickingSigninButton");
		
		//Verify if Start page is loaded
		gf.VerifyPageLoad(120, "Sign Out", "Unable to find START PAGE");
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Select Product to Upgrade
		WebRegFunctions.NZ_StoreAccelSignup ();

		//Submit Payment Info 
		WebRegFunctions.ISP_EnterPaymentInfo_PhoneBill();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		//Verify Confirmation page
		gf.VerifyPageLoad(120, "Order Details",
		"Unable to find Confirmation page.");
		
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Details");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_FreeIsp_Free_Accounts.txt";
			String dstnfilename = brand + "_Accel_ACH_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free DialUp To Accel LEC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Logger
					.error("Free DialUp TO ACCELERATOR LEC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");


	}

	
	// ISP to DSL
	
	@Test
	public void B_Accel_CC_To_DSL_Ultra_CC_Upgrade () {
		service = "DSL_VZW_Ultra";
		paytype = "CC";
		String planName = "DSL Ultra";
		String TN = "8182873211";
		
		
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		
		String filename = brand + "_Accel_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		SeleniumDriver.webobj.pause ("1000");
		
		
		// Validate Store page and click Broadbank link
		gf.VerifyPageLoad(30, "Products & Services",
		"Unable to find Store page");
		Logger.info("Loaded Store Page");
		SeleniumDriver.webobj.click("link=» DSL Broadband");

		
		
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		gf
				.VerifyElementLoad(
						10,
						"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]",
						"Unable to find SELECT button");

		SeleniumDriver.webobj
				.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage_onUpgrade(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
		
	}
	
	
	// ISP to Wireless Upgrades
	
	@Test
	public void B_Store_ISP_Accel_To_WRLS_Pro_Upgrade (){
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	
		
		String filename = brand + "_Accel_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		SeleniumDriver.webobj.pause ("1000");
		
		
		//Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v1(planName, deviceName, VisaCcNum, uid);
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	
	@Test
	public void B_Store_ISP_Free_To_WRLS_Basic_Upgrade (){
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_FreeIsp_Free_Accounts.txt";
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		

		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		//Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v2(planName, deviceName, VisaCcNum, uid);
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	
	
	
	@Test
	public void B_Store_ISP_Platinum_To_WRLS_Basic_Upgrade (){
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_Platinum_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);
		
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		

		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");
		
		
		//Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v3(planName, deviceName, VisaCcNum, uid);
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	
	
}
