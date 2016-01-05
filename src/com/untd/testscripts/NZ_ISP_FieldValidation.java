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

public class NZ_ISP_FieldValidation extends TestNgIntegration {

	String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	GeneralFunctions gf;// = new GeneralFunctions();

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_FirstNameFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("firstName", "");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: FirstName");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_LastNameFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("lastName", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: LastName");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_AddressFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.streetName", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Address");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CityFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.city", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: City");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_StateFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.state", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: State");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_ZipFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.zip", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Zip");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhoneAreaCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.phoneAreaCode", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Blank Area Code");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhonePrefixCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.phonePrefix", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Prefix");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PhoneSuffixCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("billingAddress.phoneSuffix", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone number, Suffix");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_MemberIDCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("memberId", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Your Member ID may only contain letters, numbers, periods, dashes and underscores, and it must start with a letter and end with a letter or number. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Member ID");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordCodeFieldValidation_5() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "net zero");

		driver.webobj.type("password", "");
		driver.webobj.type("formPassword2", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field is blank");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_SecurityAnswerCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("secretAnswer", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Answer");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_SecurityQuestionCodeFieldValidation() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("secretQuestionCode", "");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Security Question");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_1() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("password", "netzero<");
		driver.webobj.type("formPassword2", "netzero<");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))

			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_2() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		driver.webobj.type("password", "netzero>");
		driver.webobj.type("formPassword2", "netzero>");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"<\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_3() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "netzero\"");

		driver.webobj.type("password", "netzero\"");
		driver.webobj.type("formPassword2", "netzero\"");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \" .");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_4() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "netzero'");

		driver.webobj.type("password", "netzero'");
		driver.webobj.type("formPassword2", "netzero'");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))

			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: \"'\".");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_PasswordValidation_5() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();
		driver.runStep("ChoosePayMethod_CC");

		// System.out.println ("@#$$$$$$$$$$$ Password is: " + "net zero");

		driver.webobj.type("password", "net zero");
		driver.webobj.type("formPassword2", "net zero");
		driver.runStep("AcceptingAndSubmitting");
		if (!driver.webobj.isTextPresent("Please correct the field"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the password field contains invalid character: <space>");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CCValidation_BlankField() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");

		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Number");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_InvalidCharacters() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "123456");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '123456'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_SpecialCharacters() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "541234567890!!@#");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");

		if (!driver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '541234567890!!@#'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_Invalid_CC() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "12345678901234");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please make sure that all information is accurate or choose a different payment method."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Number '12345678901234'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test
	public void NZ_CCValidation_BlankExpMonth() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "5412345678901190");
		// driver.webobj.select("ccExpMonth", "label=Select");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Month");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_BlankExpYear() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=07");
		// driver.webobj.select("ccExpYear", "");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: CC Expire Year");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_InvalidExpireMonthYear() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=01");
		driver.webobj.select("ccExpYear", "label=2013");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("We were unable to process your transaction with the credit card information you provided. Please enter a valid expiration date or choose a different payment method."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid Credit Card Expiration Date '01-2013'");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_BlankFields() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave ACH fields blank");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_RountingNbrBlank() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "");
		driver.webobj.type("bankAccountNumber", "9302100");
		driver.webobj.type("bankAccountNumber2", "9302100");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
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
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "!@#$%#$");
		driver.webobj.type("bankAccountNumber", "9302100");
		driver.webobj.type("bankAccountNumber2", "9302100");
		// driver.webobj.pause ("5000");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = driver.webobj.getCookieByName("cw");

		driver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
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
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "12345678954545454");
		driver.webobj.type("bankAccountNumber", "9302100");
		driver.webobj.type("bankAccountNumber2", "9302100");
		driver.webobj.pause("5000");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = driver.webobj.getCookieByName("cw");

		driver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
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
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "122000661");
		driver.webobj.type("bankAccountNumber", "93021$)");
		driver.webobj.type("bankAccountNumber2", "9302100");
		driver.webobj.pause("5000");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = driver.webobj.getCookieByName("cw");

		driver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
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
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "122000661");
		driver.webobj.type("bankAccountNumber", "AB123");
		driver.webobj.type("bankAccountNumber2", "AB123");
		driver.webobj.pause("5000");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		String str = driver.webobj.getCookieByName("cw");

		driver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Your account number must contain at least six digits"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when enter invalid number of characters in: ACH Bank Account Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_BankAccountNotMatch() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "122000661");

		driver.webobj.type("bankAccountNumber", "546879");
		driver.webobj.type("bankAccountNumber2", "213546");
		driver.webobj.pause("10000");
		gf.VerifyCookieLoad(50, "cw", "Unable to find cw cookie");
		String str = driver.webobj.getCookieByName("cw");

		// System.out.println(str);
		driver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Bank Account Numbers don't match"))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when Bank Account Numbers don't match.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_CAPTCHABlank() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "122000661");
		driver.webobj.type("bankAccountNumber", "9302100");
		driver.webobj.type("bankAccountNumber2", "9302100");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("You did not enter the Security Check words correctly. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_ACHValidation_InvalidCAPTCHA() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType",
				"label=Electronic Check");
		driver.webobj.pause("5000");
		driver.webobj.type("bankRoutingNumber", "122000661");
		driver.webobj.type("bankAccountNumber", "9302100");
		driver.webobj.type("bankAccountNumber2", "9302100");
		gf.VerifyCookieLoad(120, "cw", "Unable to find cw cookie");
		driver.webobj.type("captchaTypedWord", "invalid");
		driver.runStep("AcceptingAndSubmitting");
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("You did not enter the Security Check words correctly. Please try again."))
			// RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when leave the following field blank: ACH Rounting Number.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_EmptyPhoneNumber() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankAreaCode() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "");
		driver.webobj.type("billedPhoneNumberPrefix", "287");
		driver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankPhonePrefix() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "818");
		driver.webobj.type("billedPhoneNumberPrefix", "");
		driver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_BlankPhoneSuffix() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "818");
		driver.webobj.type("billedPhoneNumberPrefix", "287");
		driver.webobj.type("billedPhoneNumberSuffix", "");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("Please correct the field(s) highlighted below"))

			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Number  ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer1() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		// driver.webobj.click("c1");
		driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "818");
		driver.webobj.type("billedPhoneNumberPrefix", "287");
		driver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer2() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		// driver.webobj.click("c3");
		driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "818");
		driver.webobj.type("billedPhoneNumberPrefix", "287");
		driver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered.");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PhoneBillValidation_NoAnswer3() {
		driver.webobj.deleteAllVisibleCookies();
		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		driver.runStep("LoadFrontDoorPage");
		driver.runStep("ClickingNZAccelSignupNowButton");

		EnterBasicInfo();
		EnterMemberIdDetails();

		driver.webobj.select("selectedPaymentType", "label=Phone Bill");

		driver.webobj.click("c1");
		driver.webobj.click("c3");
		// driver.webobj.click("c5");

		driver.webobj.type("billedPhoneNumberAreaCode", "818");
		driver.webobj.type("billedPhoneNumberPrefix", "287");
		driver.webobj.type("billedPhoneNumberSuffix", "3005");

		driver.runStep("AcceptingAndSubmitting");

		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!driver.webobj
				.isTextPresent("In order to charge your monthly service to your telephone bill, you must answer"))

			Logger
					.error(" *** ERROR: Error message was not returned when one of the questions not answered. ");

		RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

	}

	public void RestartDriver(String configFile, String csvFile) {

		try {
			driver.webobj.pause("1000");
			driver.webobj.stop();
			driver.webobj.pause("1000");
			driver.webobj.start();
			driver.startDriver(System.getProperty("user.dir")
					+ "/src/resources/config/" + configFile, System
					.getProperty("user.dir")
					+ "/src/resources/csv/" + csvFile);
			driver.webobj.windowMaximize();
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}

	}

	public void EnterBasicInfo() {
		gf.VerifyPageLoad(120, "Enter Information",
				"Unable to find Enter Your Information page");
		// if (!driver.webobj.isTextPresent("Enter Information"))
		// Logger.error("Unable to find Enter Your Information page");
		// else
		// {
		driver.webobj.type("firstName", "John");
		driver.webobj.type("lastName", "Smith");
		driver.webobj.type("billingAddress.streetName",
				"12301 burbank Blvd");
		driver.webobj.type("billingAddress.aptNumber", "100");
		driver.webobj.type("billingAddress.city", "Woodland Hills");
		driver.webobj
				.select("billingAddress.state", "label=California");
		driver.webobj.type("billingAddress.zip", "91367");
		driver.webobj.type("billingAddress.phoneAreaCode", "818");
		driver.webobj.type("billingAddress.phonePrefix", "287");
		driver.webobj.type("billingAddress.phoneSuffix", "3005");

		// }
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public void EnterMemberIdDetails() {

		driver.webobj.type("memberId", "jfaux_auto_" + getDateTime());
		driver.webobj.type("password", "netzero");
		driver.webobj.type("formPassword2", "netzero");
		driver.webobj.select("secretQuestionCode",
				"label=What is my mother's maiden name?");
		driver.webobj.type("secretAnswer", "juno");
	}
}
