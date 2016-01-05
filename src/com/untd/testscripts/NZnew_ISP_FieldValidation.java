/*package com.untd.testscripts;

import org.testng.annotations.BeforeClass;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;

import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.recovery.TestNgIntegration;

public class NZ_ISP_FieldValidation extends TestNgIntegration {

	String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	GeneralFunctions gf = new GeneralFunctions();

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");

	}
 */

package com.untd.testscripts;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;

import org.testng.annotations.BeforeClass; //import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver; //import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;

public class NZnew_ISP_FieldValidation extends TestNgIntegration {

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

		// SeleniumDriver.webobj.deleteAllVisibleCookies();

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

	/*	// ***********************
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
*/
		// **********************

		String env = runConfigProperties.getProperty("Env");
		System.out.println("Env:" + env);

		VisaCcNum = (envConfigProperties.getProperty(env + ".VisaCcNum"));
		ACH_AccountNumber = (envConfigProperties.getProperty(env
				+ ".ACHAccountNumber"));
		ACH_RoutingNumber = (envConfigProperties.getProperty(env
				+ ".ACHRoutingNumber"));
	}

	@Test
	public void NZ_FirstNameFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("firstName", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: FirstName");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}
	@Test
	public void NZ_TandS_Validation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		//SeleniumDriver.webobj.type("firstName", "");
		//WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("We cannot process your transaction unless you select \"I accept these Terms.\""))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Term and Service");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}
	@Test
	public void NZ_LastNameFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("lastName", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: LastName");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_AddressFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.streetName", "");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Address");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CityFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.city", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: City");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_StateFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// Clear State dropdown
		SeleniumDriver.webobj.click("css=a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=State/Province");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		// SeleniumDriver.webobj.type("billingAddress.state", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(30, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: State");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_ZipFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.zip", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Zip");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhoneAreaCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.phoneAreaCode", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Blank Area Code");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhonePrefixCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.phonePrefix", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Prefix");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhoneSuffixCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("billingAddress.phoneSuffix", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Suffix");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_MemberIDCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("memberId", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your Member ID must be at least 3 characters long and may only contain letters, numbers, periods, dashes and underscores. It must start with a letter and end with a letter or number. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Member ID");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordCodeFieldValidation_5() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "");
		SeleniumDriver.webobj.type("formPassword2", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field is blank");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_SecurityAnswerCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("secretAnswer", "");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Answer");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_SecurityQuestionCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		// SeleniumDriver.webobj.type("secretQuestionCode", "");
		SeleniumDriver.webobj
				.click("css=td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Select a Question");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(300, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Security Question");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "netzero<");
		SeleniumDriver.webobj.type("formPassword2", "netzero<");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))

			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "netzero>");
		SeleniumDriver.webobj.type("formPassword2", "netzero>");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_3() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "netzero\"");
		SeleniumDriver.webobj.type("formPassword2", "netzero\"");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \" .");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_4() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "netzero'");
		SeleniumDriver.webobj.type("formPassword2", "netzero'");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))

			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"'\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_5() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		WebRegFunctions.ISP_EnterPaymentInfo_CC(VisaCcNum);

		SeleniumDriver.webobj.type("password", "net zero");
		SeleniumDriver.webobj.type("formPassword2", "net zero");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		if (!SeleniumDriver.webobj
				.isTextPresent("Your password must be 6-12 letters and/or numbers. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: <space>");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CCValidation_BlankField() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		// SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Number");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_InvalidCharacters() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "15465481");

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		gf.VerifyPageLoad(30, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method. For assistance, call toll-free 1-866-841-1442"))
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '15465481'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_SpecialCharacters() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "123456@#$@#$21@%");

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		gf.VerifyPageLoad(300, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");
		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '541234567890!!@#'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_Invalid_CC() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", "1234567890123456");

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(300, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '12345678901234'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CCValidation_BlankExpMonth() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		// SeleniumDriver.webobj
		// .click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		// SeleniumDriver.webobj.click("link=04");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Month");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_BlankExpYear() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=04");
		// SeleniumDriver.webobj
		// .click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		// SeleniumDriver.webobj.click("link=2015");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Year");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_InvalidExpireMonthYear() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj.click("link=Credit Card/Debit Card");
		SeleniumDriver.webobj.type("id=ccNumber", VisaCcNum);

		SeleniumDriver.webobj
				.click("css=div.input1.typeInput > table > tbody > tr > td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=01");
		SeleniumDriver.webobj
				.click("//div[@id='ccExpYearHTML']/div[2]/table/tbody/tr/td[3]/div/div/a");
		SeleniumDriver.webobj.click("link=2013");

		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "123");
		else
			Logger.info("CVV field is not present on the page");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(30, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent(" We were unable to process your transaction with the credit card information you provided. Please enter a valid expiration date."))
			 // or choose a different payment method."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Expiration Date '01-2013'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_BlankFields() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();
		SeleniumDriver.webobj.pause("5000");
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave ACH fields blank");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_RountingNbrBlank() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", "");
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test invalid characters in 'bankRoutingNumber'
	public void NZ_ACHValidation_InvalidRoutingNbr_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", "!@#$$#");
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please enter a valid Bank Routing Number"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Rounting Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test boundary condition for 'bankRoutingNumber'
	public void NZ_ACHValidation_InvalidRoutingNbr_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", "2135468794");
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please enter a valid Bank Routing Number"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Rounting Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test invalid characters in 'bankAccountNumber'
	public void NZ_ACHValidation_InvalidAccountNbr_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", ACH_RoutingNumber);
		SeleniumDriver.webobj.type("id=bankAccountNumber", "213@#$");
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Bank Account Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test boundary condition for 'bankAccountNumber'
	public void NZ_ACHValidation_InvalidAccountNbr_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		/*
		 * SeleniumDriver.webobj.select("selectedPaymentType",
		 * "label=Electronic Check"); SeleniumDriver.webobj.pause("5000");
		 * SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		 * SeleniumDriver.webobj.type("bankAccountNumber", "AB123");
		 * SeleniumDriver.webobj.type("bankAccountNumber2", "AB123");
		 * SeleniumDriver.webobj.pause("5000"); gf.VerifyCookieLoad(120, "cw",
		 * "Unable to find cw cookie"); String str =
		 * SeleniumDriver.webobj.getCookieByName("cw");
		 * 
		 * SeleniumDriver.webobj.type("captchaTypedWord", str);
		 */
		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", ACH_RoutingNumber);
		SeleniumDriver.webobj.type("id=bankAccountNumber", "AB123");
		SeleniumDriver.webobj.type("name=bankAccountNumber2", "AB123");

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid number of characters in: ACH Bank Account Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_BankAccountNotMatch() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// Select Electronic Check
		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", ACH_RoutingNumber);
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj.type("name=bankAccountNumber2", "546879");

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			WebRegFunctions.ISP_EnterCAPTCHA();

		/*
		 * SeleniumDriver.webobj.select("selectedPaymentType",
		 * "label=Electronic Check"); SeleniumDriver.webobj.pause("5000");
		 * SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		 * 
		 * SeleniumDriver.webobj.type("bankAccountNumber", "546879");
		 * SeleniumDriver.webobj.type("bankAccountNumber2", "213546");
		 * SeleniumDriver.webobj.pause("10000"); gf.VerifyCookieLoad(50, "cw",
		 * "Unable to find cw cookie"); String str =
		 * SeleniumDriver.webobj.getCookieByName("cw");
		 * 
		 * // System.out.println(str);
		 * SeleniumDriver.webobj.type("captchaTypedWord", str);
		 */
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Bank Account Numbers don't match"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when Bank Account Numbers don't match.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_CAPTCHABlank() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		SeleniumDriver.webobj.type("memberId", "jfaux_auto_" + gf.getDateTime());
		//SeleniumDriver.webobj.type("memberId", "jfaux_vstar");
		
		
		
		SeleniumDriver.webobj.type("password", "netzero");
		SeleniumDriver.webobj.type("formPassword2", "netzero");
		// SeleniumDriver.webobj.select("secretQuestionCode",
		// "label=What is my mother's maiden name?");
		SeleniumDriver.webobj
				.click("css=td > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=exact:What is my pet's name?");
		SeleniumDriver.webobj.type("secretAnswer", "juno");
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", ACH_RoutingNumber);
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		// if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		// WebRegFunctions.ISP_EnterCAPTCHA ();
		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj.isTextPresent("You did not enter the Security Check words correctly. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger.error(" *** ERROR: Error message was not returned when leave the following field blank: CAPTCHA Security word.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_InvalidCAPTCHA() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Electronic Check");
		SeleniumDriver.webobj.type("id=bankRoutingNumber", ACH_RoutingNumber);
		SeleniumDriver.webobj.type("id=bankAccountNumber", ACH_AccountNumber);
		SeleniumDriver.webobj
				.type("name=bankAccountNumber2", ACH_AccountNumber);

		if (SeleniumDriver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			// WebRegFunctions.ISP_EnterCAPTCHA ();
			SeleniumDriver.webobj.type("id=captchaTypedWord", "invalid");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();
		
		//String ErrorMessage1 = "You did not enter the Security Check words correctly. Please try again.";
		//String ErrorMessage2 = "Please enter the Security Check words.";
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		String ErrorMessage = SeleniumDriver.webobj.getText("id=pageError");
		System.out.print("ErrorMessage: " + SeleniumDriver.webobj.getText("id=pageError"));
		
		
		if (!SeleniumDriver.webobj.isTextPresent(ErrorMessage))
		/*if (!SeleniumDriver.webobj
				.isTextPresent("You did not enter the Security Check words correctly. Please try again.")) */
			{Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");}
		
			
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_EmptyPhoneNumber() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");

		SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankAreaCode() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// SeleniumDriver.webobj.select("selectedPaymentType",
		// "label=Phone Bill");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "3005");
		SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(300, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankPhonePrefix() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "3005");
		SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankPhoneSuffix() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "");
		SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer1() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "3005");
		// SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer2() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "3005");
		SeleniumDriver.webobj.click("id=c1");
		// SeleniumDriver.webobj.click("id=c3");
		SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer3() {
		driver.runStep("DeleteCookies");
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		// Click Dial-Up tab
		gf.VerifyElementLoad(60, "id=realButton", "Unable to find WWW page");
		SeleniumDriver.webobj.click("link=DIAL-UP");

		// Click Sign Up Now link for Accelerated Dial-Up product
		gf.VerifyPageLoad(60, "Accelerated  Dial-Up",
				"Unable to find ISP Product page");
		SeleniumDriver.webobj.click("css=a.r16 > img");

		// Fill out Customer Information form and Submit
		WebRegFunctions.ISP_EnterBasicInfo();
		WebRegFunctions.ISP_EnterMemberIdDetails();
		// String uid = SeleniumDriver.webobj.getValue("memberId");

		// SeleniumDriver.webobj.select("selectedPaymentType",
		// "label=Phone Bill");

		SeleniumDriver.webobj
				.click("css=div.typeInput > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen");
		SeleniumDriver.webobj.click("link=Phone Bill");
		SeleniumDriver.webobj.type("id=billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("id=billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("id=billedPhoneNumberSuffix", "3005");
		SeleniumDriver.webobj.click("id=c1");
		SeleniumDriver.webobj.click("id=c3");
		// SeleniumDriver.webobj.click("id=c5");

		WebRegFunctions.ISP_Accept_TandC();
		WebRegFunctions.ISP_ClickSubmit();

		gf.VerifyPageLoad(300, "Create a Member ID and Password",
				"Unable to find \"Enter Information\" page");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered. ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	public void RestartDriver(String configFile, String csvFile) {

		try {
			SeleniumDriver.webobj.pause("5000");
			SeleniumDriver.webobj.stop();
			SeleniumDriver.webobj.pause("5000");
			SeleniumDriver.webobj.start();
			driver.startDriver(System.getProperty("user.dir")
					+ "/src/resources/config/" + configFile, System
					.getProperty("user.dir")
					+ "/src/resources/csv/" + csvFile);
			SeleniumDriver.webobj.windowMaximize();
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}

	}

	public void EnterBasicInfo() {
		gf.VerifyPageLoad(120, "Enter Information",
				"Unable to find Enter Your Information page");
		// if (!SeleniumDriver.webobj.isTextPresent("Enter Information"))
		// Logger.error("Unable to find Enter Your Information page");
		// else
		// {
		SeleniumDriver.webobj.type("firstName", "John");
		SeleniumDriver.webobj.type("lastName", "Smith");
		SeleniumDriver.webobj.type("billingAddress.streetName",
				"12301 burbank Blvd");
		SeleniumDriver.webobj.type("billingAddress.aptNumber", "100");
		SeleniumDriver.webobj.type("billingAddress.city", "Woodland Hills");
		SeleniumDriver.webobj
				.select("billingAddress.state", "label=California");
		SeleniumDriver.webobj.type("billingAddress.zip", "91367");
		SeleniumDriver.webobj.type("billingAddress.phoneAreaCode", "818");
		SeleniumDriver.webobj.type("billingAddress.phonePrefix", "287");
		SeleniumDriver.webobj.type("billingAddress.phoneSuffix", "3005");

		// }
	}

	/*
	 * public static String getDateTime() { DateFormat dateFormat = new
	 * SimpleDateFormat("MMddyy_HHmmss"); Date date = new Date(); return
	 * dateFormat.format(date);
	 * 
	 * }
	 */

	public void EnterMemberIdDetails() {

		SeleniumDriver.webobj
				.type("memberId", "jfaux_auto_" + gf.getDateTime());
		SeleniumDriver.webobj.type("password", "netzero");
		SeleniumDriver.webobj.type("formPassword2", "netzero");
		SeleniumDriver.webobj.select("secretQuestionCode",
				"label=What is my mother's maiden name?");
		SeleniumDriver.webobj.type("secretAnswer", "juno");
	}
}
