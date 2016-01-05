package com.untd.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;

import java.lang.*;
import java.util.Properties;
import java.io.*;

import com.untd.testscripts.Utils.*;

public class NZnew_DSL_FieldValidation extends TestNgIntegration {

	String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	private Properties runConfigProperties = null;
	private Properties envConfigProperties = SystemConfig.envConfigProperties;
	GeneralFunctions gf = new GeneralFunctions();
	FileOperations fo = new FileOperations();
	String VisaCcNum, uid, TN, planName;
 
	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
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

		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);

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

	@Test
	public void NZ_DSL_FirstNameFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		// Clear up field
		SeleniumDriver.webobj.type("firstName", "");
		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your First Name."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: FirstName");

	WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
		

	}

	@Test
	public void NZ_DSL_LastNameFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		// Clear up field and submit
		SeleniumDriver.webobj.type("lastName", "");
		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error messaging
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your Last Name."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Last Name");

				WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_AddressFieldValidation() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		// Clear up field and submit
		SeleniumDriver.webobj.type("billingAddress.streetName", "");
		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your Address."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Address");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");
				

	}

	@Test
	public void NZ_DSL_CityFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("billingAddress.city", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your City."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: City");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_StateFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		// SeleniumDriver.webobj.select("id=billingAddress.state", "label=-");
		gf.VerifyElementLoad(30, "css=a.jqTransformSelectOpen",
				"Unable to find \"State\" dropdown menu");
		SeleniumDriver.webobj.click("css=a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=State/Province");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your State."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: State");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_ZipFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("billingAddress.zip", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us ZIP Code."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Zip Code");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_ShippingAddressFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("dslShippingAddress.streetName", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your shipping Address."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping Address");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_ShippingCityFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("dslShippingAddress.city", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your shipping City."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping City");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_ShippingStateFieldValidation() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		// SeleniumDriver.webobj.select("id=dslShippingAddress.state",
		// "label=-");
		gf.VerifyElementLoad(30, "id=dslShippingAddressstate",
				"Unable to find \"State\" dropdown menu");
		SeleniumDriver.webobj.click("id=dslShippingAddressstate");
		SeleniumDriver.webobj.click("//tr[@id='hackTR5']/td[3]/div/div/a");
		SeleniumDriver.webobj.click("//tr[@id='hackTR5']/td[3]/div/ul/li/a");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your shipping State."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping State");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_ShippingZipFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("dslShippingAddress.zip", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us shipping ZIP Code."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping Zip Code");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PhoneAreaCodeFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("billingAddress.phoneAreaCode", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please re-enter your Phone Number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Area Code");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PhonePrefixCodeFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("billingAddress.phonePrefix", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please re-enter your Phone Number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Prefix");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PhoneSuffixFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("billingAddress.phoneSuffix", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please re-enter your Phone Number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Suffix");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_MemberIDFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("memberId", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please enter your Member ID."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Member Id");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_BlankPasswordFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please enter your Password."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Password");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 

	}

	@Test
	public void NZ_DSL_PasswordReTypeFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("formPassword2", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please re-enter your Password for verification."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: re-type Password");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordDoNotMatchValidation() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "1111111");
		SeleniumDriver.webobj.type("formPassword2", "2222222");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("The Passwords you entered in the two password fields do not match. Please be sure that you have entered the same password in both fields."))

			Logger
					.error(" *** ERROR: Error message was not returned when two pw fields did not match.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordSpecialChar_FieldValidation_1() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "netzero<");
		SeleniumDriver.webobj.type("formPassword2", "netzero<");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Your password must be 6-12 letters and/or numbers. Please try again."))

			Logger
					.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordSpecialChar_FieldValidation_2() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "netzero>");
		SeleniumDriver.webobj.type("formPassword2", "netzero>");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Your password must be 6-12 letters and/or numbers. Please try again."))
			Logger
					.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordSpecialChar_FieldValidation_3() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "netzero\"");
		SeleniumDriver.webobj.type("formPassword2", "netzero\"");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Your password must be 6-12 letters and/or numbers. Please try again."))

			Logger
					.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordSpecialChar_FieldValidation_4() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "netzero'");
		SeleniumDriver.webobj.type("formPassword2", "netzero'");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Your password must be 6-12 letters and/or numbers. Please try again."))

			Logger
					.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PasswordSpecialChar_FieldValidation_5() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("password", "net zero");
		SeleniumDriver.webobj.type("formPassword2", "net zero");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Your password must be 6-12 letters and/or numbers. Please try again."))

			Logger
					.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_SecurityQuestionFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		// Leave Security Question blank
		SeleniumDriver.webobj.click("id=secretQuestionCode");
		SeleniumDriver.webobj.click("link=Select a question");
		SeleniumDriver.webobj.type("secretAnswer", "juno");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please select your secret question."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Secret Question");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_SecurityAnswerCodeFieldValidation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);
		SeleniumDriver.webobj.type("id=secretAnswer", "");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please enter your secret answer."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Secret Answer");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_BlankField() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "");

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please enter your Credit Card Number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Number");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_PaymentMethodValidation_BlankField() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please select a payment method."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following blank: Payment Type Selection");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_InvalidCharacters() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "12323232323");

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))

			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_SpecialCharacters() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "!@#%$#%$");

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))

			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_Invalid_CC() {
		driver.runStep("DeleteCookies");
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "12345678901234");

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))

			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_BlankExpMonth() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		//SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Month");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Please tell us the month in which your Credit Card expires."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Expiration Month");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_BlankExpYear() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=Year");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("Please tell us the year in which your Credit Card expires."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Expiration Year");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	@Test
	public void NZ_DSL_CCValidation_InvalidExpireMonthYear() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);
		SeleniumDriver.webobj.pause("3000");

	//	SeleniumDriver.webobj
	//			.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
	//	SeleniumDriver.webobj.click("link=Month");
	//	SeleniumDriver.webobj.pause("3000");
	//	SeleniumDriver.webobj
	//			.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
	//	SeleniumDriver.webobj.click("link=Year");
	//	SeleniumDriver.webobj.pause("3000");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();
		SeleniumDriver.webobj.pause("5000");

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		Logger.info("Getting an ALERT: " + alert);

		if (!alert.equals("Please tell us the month in which your Credit Card expires."))
		
			Logger.error(" **** ERROR: ****  Error message was not returned when left the following field blank: Credit Card Expiration Month and Year");
		
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	public void NZ_DSL_CvmValidation_Blank() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please tell us your Credit card's CVM number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card CVM");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

	public void NZ_DSL_CvmValidation_Invalid() {
		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		// WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.click("id=selectedPaymentType");
		SeleniumDriver.webobj.click("link=Credit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//table[@id='table5a']/tbody/tr[3]/td[2]/div[2]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "abc");
		else
			Logger.info("CVV field is not present on the page");

		WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error message
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert
				.equals("The CVM number you entered is invalid. Please re-enter your CVM number."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card CVM");

		WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}
	
	@Test
	public void NZ_DSL_TandS_Validation() {

		TN = "8182873005";
		planName = "DSL Saver";

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		WebRegFunctions.DSL_LoadWWWPage();
		WebRegFunctions.DSL_EnterTN_WWWPage(TN);

		// Validate DSL CHOOSE A PLAN page and select DSL plan
		gf.VerifyPageLoadEx(30, "CHOOSE A PLAN",
				"Unable to find \"CHOOSE A PLAN\" page");
		//gf.VerifyPageLoad(10, "SELECT",
				//"\"CHOOSE A PLAN\" page is not fully loaded");
		SeleniumDriver.webobj.click("//img[@onclick=\"javascript:void(window.chooseAPlanCustomSubmitter('DSL0768','nz-dslsaver-9-95-vz'));\"]");
		Logger.info("Selected " + planName);

		// Fill Out Customer Information page
		WebRegFunctions.DSL_EnterBasicInfo();
		WebRegFunctions.DSL_EnterMemberIdDetails();
		WebRegFunctions.DSL_EnterPaymentInfo_CC(VisaCcNum);

		
		//WebRegFunctions.DSL_Accept_TandC();
		WebRegFunctions.DSL_ClickSubmit();

		// Validate proper error messaging
		String alert = SeleniumDriver.webobj.getAlert();
		System.out.println("    ALERT     " + alert);

		if (!alert.equals("Please accept the terms of service."))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Last Name");

				WebRegFunctions.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv"); 
				

	}

}
