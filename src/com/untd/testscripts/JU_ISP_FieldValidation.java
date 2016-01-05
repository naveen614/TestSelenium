package com.untd.testscripts;

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

public class JU_ISP_FieldValidation extends TestNgIntegration {

	String brand = "JU", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	GeneralFunctions gf = new GeneralFunctions();
	public ISP_RegistrationFormFunctions WebRegFunctions = null;

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/ju_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_FirstNameFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();

		EnterMemberIdDetails();

		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("firstName", "");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: FirstName");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}
	@Test
	public void JU_TandS_Validation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();

		EnterMemberIdDetails();

		driver.runStep("ChoosePayMethod_CC");
		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "546");


		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		SeleniumDriver.webobj.type("captchaTypedWord", str);
		
		
		//SeleniumDriver.webobj.type("firstName", "");
		//driver.runStep("AcceptingAndSubmitting");
		
		
		//Click "Submit and Continue" button
		SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	
		
		if (!SeleniumDriver.webobj
				.isTextPresent("We cannot process your transaction unless you select \"I accept these Terms.\""))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Terms and Service");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}
	@Test
	public void JU_LastNameFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("lastName", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: LastName");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_AddressFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.streetName", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// {RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			// Logger.error(" *** ERROR: Error message was not returned when left the following field blank: Address");
			// }
			RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_CityFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.city", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: City");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_StateFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.state", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: State");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_ZipFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.zip", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Zip");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PhoneAreaCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.phoneAreaCode", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Blank Area Code");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PhonePrefixCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.phonePrefix", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Prefix");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PhoneSuffixCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("billingAddress.phoneSuffix", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Suffix");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_MemberIDCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("memberId", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your Member ID may only contain letters, numbers, periods, dashes and underscores, and it must start with a letter and end with a letter or number. Please try again."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Member ID");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordCodeFieldValidation_5() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "net zero");

		SeleniumDriver.webobj.type("password", "");
		SeleniumDriver.webobj.type("formPassword2", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field is blank");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_SecurityAnswerCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("secretAnswer", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Answer");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_SecurityQuestionCodeFieldValidation() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("secretQuestionCode", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Security Question");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordValidation_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("password", "netzero<");
		SeleniumDriver.webobj.type("formPassword2", "netzero<");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))

			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordValidation_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		SeleniumDriver.webobj.type("password", "netzero>");
		SeleniumDriver.webobj.type("formPassword2", "netzero>");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordValidation_3() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "netzero\"");

		SeleniumDriver.webobj.type("password", "netzero\"");
		SeleniumDriver.webobj.type("formPassword2", "netzero\"");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \" .");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordValidation_4() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "netzero'");

		SeleniumDriver.webobj.type("password", "netzero'");
		SeleniumDriver.webobj.type("formPassword2", "netzero'");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))

			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"'\".");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_PasswordValidation_5() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "net zero");

		SeleniumDriver.webobj.type("password", "net zero");
		SeleniumDriver.webobj.type("formPassword2", "net zero");
		driver.runStep("AcceptingAndSubmitting");
		if (!SeleniumDriver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: <space>");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_CCValidation_BlankField() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "");
		SeleniumDriver.webobj.select("ccExpMonth", "label=07");
		SeleniumDriver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");

		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Number");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_CCValidation_InvalidCharacters() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "123456");
		SeleniumDriver.webobj.select("ccExpMonth", "label=07");
		SeleniumDriver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '123456'");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_CCValidation_SpecialCharacters() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "541234567890!!@#");
		SeleniumDriver.webobj.select("ccExpMonth", "label=07");
		SeleniumDriver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");

		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '541234567890!!@#'");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_CCValidation_Invalid_CC() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "12345678901234");
		SeleniumDriver.webobj.select("ccExpMonth", "label=07");
		SeleniumDriver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '12345678901234'");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void JU_CCValidation_BlankExpMonth() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "5412345678901190");
		// SeleniumDriver.webobj.select("ccExpMonth", "label=Select");
		SeleniumDriver.webobj.select("ccExpYear", "label=2016");
		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "546");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Month");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_CCValidation_BlankExpYear() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.type("ccNumber", "5412345678901190");
		SeleniumDriver.webobj.select("ccExpMonth", "label=07");
		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "546");
		// SeleniumDriver.webobj.select("ccExpYear", "");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Year");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_CCValidation_InvalidExpireMonthYear() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("ccNumber", "5412345678901190");
		SeleniumDriver.webobj.select("ccExpMonth", "label=01");
		SeleniumDriver.webobj.select("ccExpYear", "label=2013");
		
		if (SeleniumDriver.webobj.isElementPresent("id=ccCvm"))
			SeleniumDriver.webobj.type("id=ccCvm", "546");
		
	
	gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
			String str = SeleniumDriver.webobj.getCookieByName("cw");

			SeleniumDriver.webobj.type("captchaTypedWord", str);
	
		
		driver.runStep("AcceptingAndSubmitting");
		SeleniumDriver.webobj.pause("5000");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent(" We were unable to process your transaction with the credit card information you provided. Please enter a valid expiration date."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Expiration Date '01-2013'");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_ACHValidation_BlankFields() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave ACH fields blank");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_ACHValidation_RountingNbrBlank() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "");
		SeleniumDriver.webobj.type("bankAccountNumber", "9302100");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test invalid characters in 'bankRoutingNumber'
	public void JU_ACHValidation_InvalidRoutingNbr_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "!@#$%#$");
		SeleniumDriver.webobj.type("bankAccountNumber", "9302100");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please enter a valid Bank Routing Number"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Rounting Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test boundary condition for 'bankRoutingNumber'
	public void JU_ACHValidation_InvalidRoutingNbr_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "12345678954545454");
		SeleniumDriver.webobj.type("bankAccountNumber", "9302100");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please enter a valid Bank Routing Number"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Rounting Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test invalid characters in 'bankAccountNumber'
	public void JU_ACHValidation_InvalidAccountNbr_1() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		SeleniumDriver.webobj.type("bankAccountNumber", "93021$)");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid characters in: ACH Bank Account Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	// to test boundary condition for 'bankAccountNumber'
	public void JU_ACHValidation_InvalidAccountNbr_2() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		SeleniumDriver.webobj.type("bankAccountNumber", "AB123");
		SeleniumDriver.webobj.type("bankAccountNumber2", "AB123");
		gf.VerifyCookieLoad(50, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid number of characters in: ACH Bank Account Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_ACHValidation_BankAccountNotMatch() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		SeleniumDriver.webobj.type("bankAccountNumber", "546879");
		SeleniumDriver.webobj.type("bankAccountNumber2", "213546");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = SeleniumDriver.webobj.getCookieByName("cw");

		// System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Bank Account Numbers don't match"))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when Bank Account Numbers don't match.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_ACHValidation_CAPTCHABlank() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		SeleniumDriver.webobj.type("bankAccountNumber", "9302100");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("You did not enter the Security Check words correctly. Please try again."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_ACHValidation_InvalidCAPTCHA() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType",
				"label=Electronic Check");
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.type("bankRoutingNumber", "122000661");
		SeleniumDriver.webobj.type("bankAccountNumber", "9302100");
		SeleniumDriver.webobj.type("bankAccountNumber2", "9302100");

		SeleniumDriver.webobj.type("captchaTypedWord", "invalid");
		driver.runStep("AcceptingAndSubmitting");
		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("You did not enter the Security Check words correctly. Please try again."))
			// RestartDriver("ju_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_EmptyPhoneNumber() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_BlankAreaCode() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_BlankPhonePrefix() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_BlankPhoneSuffix() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_NoAnswer1() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		// SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_NoAnswer2() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		SeleniumDriver.webobj.pause("5000");

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		// SeleniumDriver.webobj.click("c3");
		SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered.");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void JU_PhoneBillValidation_NoAnswer3() {
		driver.runStep("DeleteCookies");
		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingJUAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		SeleniumDriver.webobj.select("id=selectedPaymentType", "label=Phone Bill");

		SeleniumDriver.webobj.click("c1");
		SeleniumDriver.webobj.click("c3");
		// SeleniumDriver.webobj.click("c5");

		SeleniumDriver.webobj.type("billedPhoneNumberAreaCode", "818");
		SeleniumDriver.webobj.type("billedPhoneNumberPrefix", "287");
		SeleniumDriver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// SeleniumDriver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!SeleniumDriver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered. ");

		RestartDriver("ju_runconfig.properties", "ISPSignupAndUpgrade.csv");

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

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public void EnterMemberIdDetails() {

		SeleniumDriver.webobj.type("memberId", "jfaux_auto_" + getDateTime());
		SeleniumDriver.webobj.type("password", "netzero");
		SeleniumDriver.webobj.type("formPassword2", "netzero");
		SeleniumDriver.webobj.select("secretQuestionCode",
				"label=What is my mother's maiden name?");
		SeleniumDriver.webobj.type("secretAnswer", "juno");
		SeleniumDriver.webobj.pause("3000");
		
	}
}
