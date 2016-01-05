package com.untd.testscripts;

/*import org.testng.annotations.BeforeClass;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 import com.cmates.selenium.framework.SeleniumDriver;
 import com.cmates.selenium.framework.page.WebObj;
 import com.cmates.selenium.framework.recovery.TestNgIntegration;
 import com.cmates.selenium.framework.utils.Logger;

 import java.lang.*;
 import java.util.Properties;
 import java.io.*;*/

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;

public class NZNew_DslSignupAndUpgrade extends TestNgIntegration {

	// String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	String brand = "NZ", service = "null", paytype = "null", pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	private Properties runConfigProperties = null;
	private Properties envConfigProperties = SystemConfig.envConfigProperties;
	GeneralFunctions gf;// = new GeneralFunctions();
	FileOperations fo = new FileOperations();
	String VisaCcNum, uid, TN, planName;

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();

		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);
		gf = new GeneralFunctions();

		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/DslSignupAndUpgrade.csv");

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

		// WebRegFunctions = new ISP_RegistrationFormFunctions(driver);

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
		}

		// **********************
*/
		String env = runConfigProperties.getProperty("Env");
		System.out.println("Env:" + env);

		VisaCcNum = (envConfigProperties.getProperty(env + ".VisaCcNum"));

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_Verizon_Saver0768_CC_Signup() {

		String service = "DSL_VZE_Saver";
		String paytype = "CC";
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf
				.VerifyElementLoad(
						10,"css=div.ss1.data1 > div > img",
					//	"//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("css=div.ss1.data1 > div > img");
				//.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");
	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_Verizon_MultipleAddress_Failure_CC_Signup() {

		TN = "8182873001";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Select an Address (0:Success)
		gf.VerifyPageLoad(30, "Select An Address",
				"Unable to find \"Select An Address\" page");
		SeleniumDriver.webobj.click("//div[6]/div[2]/form/input[32]");
		gf.VerifyPageLoad(30, "Sorry, NetZero DSL is not currently available",
				"Unable to find \"DSL Unavailable\" page");

		// Submit Email
		SeleniumDriver.webobj.type("id=altEmailAddress",
				"jfaux_testuser@netzero.net");
		SeleniumDriver.webobj.click("name=Submit");
		gf.VerifyPageLoad(30, "Thank you for your",
				"Unable to find \"Thank You for your Interest\" page");

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_VZE_Pro3000_CC_Signup() {
		service = "DSL_VZE_Pro";
		paytype = "CC";
		TN = "8182873200";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL Plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click("id=enterAdd");
		Logger.info("Selected " + planName);

		// Fill out Customer Information page
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_VZW_Ultra7100_CC_Signup() {
		service = "DSL_VZW_Ultra";
		paytype = "CC";
		planName = "DSL Ultra";
		TN = "8182873211";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_WWW_COVVZ_Speedsaver_CC_Signup() {
	 * 
	 * service = "DSL_COVVZ_Speedsaver"; paytype = "CC"; TN = "8182873031";
	 * planName = "DSL Speedsaver";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadWWWPage();
	 * WebRegFunctions.DSL_EnterTN_WWWPage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click("id=enterAdd"); Logger.info("Selected " +
	 * planName);
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * }
	 */

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_COVQW_Pro3000_CC_Signup() {
		service = "DSL_CQW_Pro";
		paytype = "CC";
		TN = "8182873218";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]");

		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_WWW_COVATT_Pro3000_CC_Signup() { service = "DSL_COVATT_Pro";
	 * paytype = "CC"; TN = "8182873052"; planName = "DSL Pro";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadWWWPage();
	 * WebRegFunctions.DSL_EnterTN_WWWPage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click(("id=enterAdd"), true);
	 * Logger.info("Selected " + planName); SeleniumDriver.webobj.pause("5000");
	 * 
	 * // Submit "Check Address Availability" Overlay
	 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
	 * "Please enter the address (as it appears on your phone bill)",
	 * "Unable to find \"Check Address Availability\" Overlay");
	 * SeleniumDriver.webobj.click("id=submitButton");
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void A_NZ_DSL_WWW_COVATT_NoService_CC_Signup() {
	 * 
	 * TN = "8182873056";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadWWWPage();
	 * WebRegFunctions.DSL_EnterTN_WWWPage(TN);
	 * 
	 * // Submit Email gf.VerifyPageLoad(30,
	 * "Sorry, NetZero DSL is not currently available",
	 * "Unable to find \"DSL Unavailable\" page");
	 * SeleniumDriver.webobj.type("id=altEmailAddress",
	 * "jfaux_testuser@netzero.net");
	 * SeleniumDriver.webobj.click("name=Submit"); gf.VerifyPageLoad(30,
	 * "Thank you for your",
	 * "Unable to find \"Thank You for your Interest\" page");
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * }
	 */

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_WWW_COVBLS_SpeedSaver_CC_Signup() { service =
	 * "DSL_COVBLS_SpeedSaver"; paytype = "CC"; TN = "8182873041"; planName =
	 * "DSL Speedsaver ";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadWWWPage();
	 * WebRegFunctions.DSL_EnterTN_WWWPage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click(("id=enterAdd"), true);
	 * Logger.info("Selected " + planName); SeleniumDriver.webobj.pause("5000");
	 * 
	 * // Submit "Check Address Availability" Overlay
	 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
	 * "Please enter the address (as it appears on your phone bill)",
	 * "Unable to find \"Check Address Availability\" Overlay");
	 * SeleniumDriver.webobj.click("id=submitButton");
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * 
	 * }
	 */

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_COVQW_SpeedSaver_CC_Signup() {
		service = "DSL_COVQW_SpeedSaver";
		paytype = "CC";
		TN = "8182873060";
		planName = "DSL Speedsaver ";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click(("id=enterAdd"), true);
		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_ATT_Pro3000_CC_Signup() {
		service = "DSL_ATT_Pro";
		paytype = "CC";
		TN = "8182873071";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		if (!gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page"))
			return;
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
					//	"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
			//	.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_ATT_Speedsaver_MultiAddress_Success_CC_Signup() {
		service = "DSL_ATT_Speedsaver";
		paytype = "CC";
		TN = "8182873068";
		planName = "DSL Speedsaver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Select an Address (0:Success)
		gf.VerifyPageLoad(30, "Select An Address",
				"Unable to find \"Select An Address\" page");
		SeleniumDriver.webobj.click("css=input[type=\"image\"]");

		// Validate DSL CHOOSE A PLAN page and select DSL Plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click("id=enterAdd");
		Logger.info("Selected " + planName);
		// SeleniumDriver.webobj.pause("5000");

		/*
		 * //Submit "Check Address Availability" Overlay
		 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
		 * "Please enter the address (as it appears on your phone bill)",
		 * "Unable to find \"Check Address Availability\" Overlay");
		 * SeleniumDriver.webobj.click("id=submitButton");
		 */

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_Sonictas_Ultra_CC_Signup() {
		service = "DSL_Sonictas_Pro";
		paytype = "CC";
		TN = "8182873226";
		planName = "DSL Ultra";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");

		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]");
		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.type("id=shippingAddress.streetNumber", "21302");
		SeleniumDriver.webobj.type("id=shippingAddress.streetName", "Burbank");
		SeleniumDriver.webobj.type("id=shippingAddress.aptNumber", "");
		SeleniumDriver.webobj.type("id=shippingAddress.city", "Woodland Hills");
		SeleniumDriver.webobj.select("id=shippingAddress.state", "label=CA");
		SeleniumDriver.webobj.type("id=shippingAddress.zip", "91367");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_WWW_ATTS_Ultra_CC_Signup() {
		service = "DSL_ATTS_Pro";
		paytype = "CC";
		TN = "8182873222";
		planName = "DSL Ultra";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]");
		// SeleniumDriver.webobj.click("xpath=//div[7]/div[2]/div[4]/button");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[3]",
					//	"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-atts'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[3]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-atts'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.type("id=shippingAddress.streetNumber", "21302");
		SeleniumDriver.webobj.type("id=shippingAddress.streetName", "Burbank");
		SeleniumDriver.webobj.type("id=shippingAddress.aptNumber", "");
		SeleniumDriver.webobj.type("id=shippingAddress.city", "Woodland Hills");
		SeleniumDriver.webobj.select("id=state", "label=CA");
		SeleniumDriver.webobj.type("id=shippingAddress.zip", "91367");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_Verizon_Saver0768_CC_Signup() {

		String service = "DSL_VZE_Saver";
		String paytype = "CC";
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click("css=div.ss1.data1 > div > img");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_Verizon_MultipleAddress_Failure_CC_Signup() {

		TN = "8182873001";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Select an Address (0:Success)
		gf.VerifyPageLoad(30, "Select An Address",
				"Unable to find \"Select An Address\" page");
		SeleniumDriver.webobj.click("//div[6]/div[2]/form/input[32]");
		gf.VerifyPageLoad(30, "Sorry, NetZero DSL is not currently available",
				"Unable to find \"DSL Unavailable\" page");

		// Submit Email
		SeleniumDriver.webobj.type("id=altEmailAddress",
				"jfaux_testuser@netzero.net");
		SeleniumDriver.webobj.click("name=Submit");
		gf.VerifyPageLoad(30, "Thank you for your ",
				"Unable to find \"Thank You for your Interest\" page");

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_VZE_Pro3000_CC_Signup() {
		service = "DSL_VZE_Pro";
		paytype = "CC";
		TN = "8182873200";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL Plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click("id=enterAdd");
		Logger.info("Selected " + planName);

		// Fill out Customer Information page
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_VZW_Ultra7100_CC_Signup() {
		service = "DSL_VZW_Ultra";
		paytype = "CC";
		planName = "DSL Ultra";
		TN = "8182873211";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]",
						"Unable to find SELECT button");

		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL7100','nz-dslultra-with-setup-fee-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_Store_COVVZ_Speedsaver_CC_Signup() {
	 * 
	 * service = "DSL_COVVZ_Speedsaver"; paytype = "CC"; TN = "8182873031";
	 * planName = "DSL Speedsaver";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadStorePage();
	 * WebRegFunctions.DSL_EnterTN_StorePage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click("id=enterAdd"); Logger.info("Selected " +
	 * planName);
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * }
	 */

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_COVQW_Pro3000_CC_Signup() {
		service = "DSL_CQW_Pro";
		paytype = "CC";
		TN = "8182873218";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		gf
				.VerifyElementLoad(
						10, "xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
			//	.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]");

		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-qstc'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_Store_COVATT_Pro3000_CC_Signup() { service = "DSL_COVATT_Pro";
	 * paytype = "CC"; TN = "8182873052"; planName = "DSL Pro";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadStorePage();
	 * WebRegFunctions.DSL_EnterTN_StorePage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click(("id=enterAdd"), true);
	 * Logger.info("Selected " + planName); SeleniumDriver.webobj.pause("5000");
	 * 
	 * // Submit "Check Address Availability" Overlay
	 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
	 * "Please enter the address (as it appears on your phone bill)",
	 * "Unable to find \"Check Address Availability\" Overlay");
	 * SeleniumDriver.webobj.click("id=submitButton");
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void A_NZ_DSL_Store_COVATT_NoService_CC_Signup() {
	 * 
	 * TN = "8182873056";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadStorePage();
	 * WebRegFunctions.DSL_EnterTN_StorePage(TN);
	 * 
	 * // Submit Email gf.VerifyPageLoad(30,
	 * "Sorry, NetZero DSL is not currently available",
	 * "Unable to find \"DSL Unavailable\" page");
	 * SeleniumDriver.webobj.type("id=altEmailAddress",
	 * "jfaux_testuser@netzero.net");
	 * SeleniumDriver.webobj.click("name=Submit"); gf.VerifyPageLoad(30,
	 * "Thank you for your",
	 * "Unable to find \"Thank You for your Interest\" page");
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * }
	 */

	/*
	 * @Test(groups = { "NZDSLSignups" }) public void
	 * A_NZ_DSL_Store_COVBLS_SpeedSaver_CC_Signup() { service =
	 * "DSL_COVBLS_SpeedSaver"; paytype = "CC"; TN = "8182873041"; planName =
	 * "DSL Speedsaver ";
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies();
	 * WebRegFunctions.DSL_LoadStorePage();
	 * WebRegFunctions.DSL_EnterTN_StorePage(TN);
	 * 
	 * // Validate DSL CHOOSE A PLAN page and select DSL plan
	 * gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
	 * "Unable to find \"CHOOSE A PLAN\" page"); gf.VerifyElementLoad(10,
	 * "id=enterAdd", "Unable to find SELECT button");
	 * SeleniumDriver.webobj.click(("id=enterAdd"), true);
	 * Logger.info("Selected " + planName); SeleniumDriver.webobj.pause("5000");
	 * 
	 * // Submit "Check Address Availability" Overlay
	 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
	 * "Please enter the address (as it appears on your phone bill)",
	 * "Unable to find \"Check Address Availability\" Overlay");
	 * SeleniumDriver.webobj.click("id=submitButton");
	 * 
	 * // Fill out Customer Information page and submit uid =
	 * WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);
	 * 
	 * // Verify DSl Plan on Confirmation Page.
	 * WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);
	 * 
	 * // Writing the MemberID to the destination text file.
	 * fo.doWriteTextFile(uid, brand, service, paytype);
	 * 
	 * WebRegFunctions.RestartDriver("nz_runconfig.properties",
	 * "DslSignupAndUpgrade.csv");
	 * 
	 * 
	 * }
	 */

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_COVQW_SpeedSaver_CC_Signup() {
		service = "DSL_COVQW_SpeedSaver";
		paytype = "CC";
		TN = "8182873060";
		planName = "DSL Speedsaver ";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");
		SeleniumDriver.webobj.click(("id=enterAdd"), true);
		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_ATT_Pro3000_CC_Signup() {
		service = "DSL_ATT_Pro";
		paytype = "CC";
		TN = "8182873071";
		planName = "DSL Pro";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		// gf.VerifyPageLoad(10,"SELECT",
		// "\"CHOOSE A PLAN\" page is not fully loaded");
		// SeleniumDriver.webobj.click("//img[@id='enterAdd' and @type='submit' and @type='submit' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]");
		gf
				.VerifyElementLoad(
						10,
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]",
						"xpath=(//img[@id='enterAdd'])[2]",	"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL3000','nz-dslpro-with-setup-fee-with-modem-atts'));\"]");
		

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_ATT_Speedsaver_MultiAddress_Success_CC_Signup() {
		service = "DSL_ATT_Speedsaver";
		paytype = "CC";
		TN = "8182873068";
		planName = "DSL Speedsaver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Select an Address (0:Success)
		gf.VerifyPageLoad(30, "Select An Address",
				"Unable to find \"Select An Address\" page");
		SeleniumDriver.webobj.click("css=input[type=\"image\"]");

		// Validate DSL CHOOSE A PLAN page and select DSL Plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf.VerifyElementLoad(10, "id=enterAdd", "Unable to find SELECT button");

		SeleniumDriver.webobj.click("id=enterAdd");
		Logger.info("Selected " + planName);
		// SeleniumDriver.webobj.pause("5000");

		/*
		 * //Submit "Check Address Availability" Overlay
		 * SeleniumDriver.webobj.selectWindow(null); gf.VerifyPageLoad(10,
		 * "Please enter the address (as it appears on your phone bill)",
		 * "Unable to find \"Check Address Availability\" Overlay");
		 * SeleniumDriver.webobj.click("id=submitButton");
		 */

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_Sonictas_Ultra_CC_Signup() {
		service = "DSL_Sonictas_Pro";
		paytype = "CC";
		TN = "8182873226";
		planName = "DSL Ultra";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf
				.VerifyElementLoad(
						10,"xpath=(//img[@id='enterAdd'])[2]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]",
						"Unable to find SELECT button");

		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[2]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-sonic'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.type("id=shippingAddress.streetNumber", "21302");
		SeleniumDriver.webobj.type("id=shippingAddress.streetName", "Burbank");
		SeleniumDriver.webobj.type("id=shippingAddress.aptNumber", "");
		SeleniumDriver.webobj.type("id=shippingAddress.city", "Woodland Hills");
		SeleniumDriver.webobj.select("id=shippingAddress.state", "label=CA");
		SeleniumDriver.webobj.type("id=shippingAddress.zip", "91367");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void A_NZ_DSL_Store_ATTS_Ultra_CC_Signup() {
		service = "DSL_ATTS_Ultra";
		paytype = "CC";
		TN = "8182873222";
		planName = "DSL Ultra";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

		WebRegFunctions.DSL_LoadStorePage();
		WebRegFunctions.DSL_EnterTN_StorePage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		gf
				.VerifyElementLoad(
						10,
"xpath=(//img[@id='enterAdd'])[3]",
						//"//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-atts'));\"]",
						"Unable to find SELECT button");
		SeleniumDriver.webobj.click("xpath=(//img[@id='enterAdd'])[3]");
				//.click("//img[@id='enterAdd' and @onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL6000','nz-dslultra-with-setup-fee-atts'));\"]");

		Logger.info("Selected " + planName);
		SeleniumDriver.webobj.pause("5000");

		// Submit "Check Address Availability" Overlay
		SeleniumDriver.webobj.selectWindow(null);
		gf.VerifyPageLoad(10,
				"Please enter the address (as it appears on your phone bill)",
				"Unable to find \"Check Address Availability\" Overlay");
		SeleniumDriver.webobj.type("id=shippingAddress.streetNumber", "21302");
		SeleniumDriver.webobj.type("id=shippingAddress.streetName", "Burbank");
		SeleniumDriver.webobj.type("id=shippingAddress.aptNumber", "");
		SeleniumDriver.webobj.type("id=shippingAddress.city", "Woodland Hills");
		SeleniumDriver.webobj.select("id=state", "label=CA");
		SeleniumDriver.webobj.type("id=shippingAddress.zip", "91367");
		SeleniumDriver.webobj.click("id=submitButton");

		// Fill out Customer Information page and submit
		uid = WebRegFunctions.DSL_FillOutCustomerInfoPage(planName, VisaCcNum);

		// Verify DSl Plan on Confirmation Page.
		WebRegFunctions.DSL_VerifyConfirmationPage(planName, uid);

		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"DslSignupAndUpgrade.csv");

	}

	// DSL to Wireless Upgrades
	@Test(groups = { "NZDSLSignups" })
	public void B_NZ_Store_DSL_Saver_To_WRLS_Basic_Upgrade() {

		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the
										// designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_DSL_VZE_Saver_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

		// Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage(uid, pwd);

		// Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");

		// Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v3(planName, deviceName, VisaCcNum,
				uid);

		// Save member id in the designated file
		String dstnfilename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void B_NZ_Store_DSL_Ultra_To_WRLS_Platinum_Upgrade() {

		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the
										// designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_DSL_VZW_Ultra_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

		// Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage(uid, pwd);

		// Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");

		// Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v2(planName, deviceName, VisaCcNum,
				uid);

		// Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void AAAAAB_NZ_Store_DSL_Pro_To_WRLS_Pro_Upgrade() {

		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the
										// designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_DSL_ATTS_Pro_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

		// Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage(uid, pwd);

		// Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");

		// Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v2(planName, deviceName, VisaCcNum,
				uid);

		// Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

	}

	@Test(groups = { "NZDSLSignups" })
	public void B_NZ_Store_DSL_SpeedSaver_To_WRLS_Plus_Upgrade() {

		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName; // to be used to save member_id to the
										// designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String filename = brand + "_DSL_COVQW_SpeedSaver_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

		// Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage(uid, pwd);

		// Click Upgrade link
		SeleniumDriver.webobj.click("link=» Upgrade Today!");

		// Upgrade to Wireless Plan
		WebRegFunctions.WIR_Upgrade_Store_v2(planName, deviceName, VisaCcNum,
				uid);

		// Save member id in the designated file
		String dstnfilename = brand + "_WIR_Plus_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);

		WebRegFunctions.RestartDriver("nz_runconfig.properties",
				"ISPSignupAndUpgrade.csv");

	}

}
