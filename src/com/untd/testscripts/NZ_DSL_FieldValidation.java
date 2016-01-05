package com.untd.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;




public class NZ_DSL_FieldValidation extends TestNgIntegration {

	String pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions dsl_formFillOut = null;
	GeneralFunctions gf;// = new GeneralFunctions ();


	@BeforeClass
	public void setUp() {
		
		try {
		driver = new SeleniumDriver();
		//gf = new GeneralFunctions(driver);
		dsl_formFillOut = new ISP_RegistrationFormFunctions (driver);

		
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/DslSignupAndUpgrade.csv");
		
	}
	catch (Exception e) {
		System.err.println(e.getMessage());

	}
	}
@Test
public void NZ_FirstNameFieldValidation () {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("firstName", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your First Name."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: FirstName");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_LastNameFieldValidation () {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("lastName", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your Last Name."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Last Name");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}


@Test
public void NZ_AddressFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.streetName", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your Address."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Address");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_CityFieldValidation() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.city", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your City."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: City");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}
@Test
public void NZ_StateFieldValidation() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.select("id=billingAddress.state", "label=-");

	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your State."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: State");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_ZipFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.zip", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us ZIP Code."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Zip Code");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_ShippingAddressFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("dslShippingAddress.streetName", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your shipping Address."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping Address");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_ShippingCityFieldValidation() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("dslShippingAddress.city", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your shipping City."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping City");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}
@Test
public void NZ_ShippingStateFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.select("id=dslShippingAddress.state", "label=-");

	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us your shipping State."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping State");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_ShippingZipFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("dslShippingAddress.zip", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please tell us shipping ZIP Code."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Shipping Zip Code");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}



@Test
public void NZ_PhoneAreaCodeFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.phoneAreaCode", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please re-enter your Phone Number."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Area Code");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PhonePrefixCodeFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.phonePrefix", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please re-enter your Phone Number."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Prefix");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PhoneSuffixFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("billingAddress.phoneSuffix", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please re-enter your Phone Number."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Phone Suffix");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_MemberIDFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("memberId", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please enter your Member ID."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Member Id");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_BlankPasswordFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please enter your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Password");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PasswordReTypeFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("formPassword2", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please re-enter your Password for verification."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: re-type Password");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PasswordDoNotMatchValidation() {
		
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "1111111");
	driver.webobj.type("formPassword2", "2222222");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("The Passwords you entered in the two password fields do not match. Please be sure that you have entered the same password in both fields." ))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when two pw fields did not match.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PasswordSpecialChar_FieldValidation_1() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "netzero<");
	driver.webobj.type("formPassword2", "netzero<");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("You are using a character that is not allowed in your Password. Please note that you may only use letters and numbers in your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}


@Test
public void NZ_PasswordSpecialChar_FieldValidation_2() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "netzero>");
	driver.webobj.type("formPassword2", "netzero>");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("You are using a character that is not allowed in your Password. Please note that you may only use letters and numbers in your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}


@Test
public void NZ_PasswordSpecialChar_FieldValidation_3() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "netzero\"");
	driver.webobj.type("formPassword2", "netzero\"");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("You are using a character that is not allowed in your Password. Please note that you may only use letters and numbers in your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PasswordSpecialChar_FieldValidation_4() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "netzero'");
	driver.webobj.type("formPassword2", "netzero'");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("You are using a character that is not allowed in your Password. Please note that you may only use letters and numbers in your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_PasswordSpecialChar_FieldValidation_5() {
	
	
	
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("password", "net zero");
	driver.webobj.type("formPassword2", "net zero");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("You are using a character that is not allowed in your Password. Please note that you may only use letters and numbers in your Password."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned PASSWORD contain special characters.");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}



@Test
public void NZ_SecurityQuestionFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.select("id=secretQuestionCode", "label=Please select a question");

	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please select your secret question."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Secret Question");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}

@Test
public void NZ_SecurityAnswerCodeFieldValidation() {
	
	
	driver.runStep("DeleteCookies");
	dsl_formFillOut.LoadDSL_EYI_Page ();
	dsl_formFillOut.EnterDSLBasicInfo ();
	dsl_formFillOut.EnterMemberIdDetails ();
	driver.runStep("ChoosePayMethod_CC");
	driver.webobj.type("secretAnswer", "");
	//driver.runStep("AcceptingAndSubmittingEyiPage ");
	driver.webobj.click("acceptTerms");
	driver.webobj.click("_eventId_success");
	
	//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
	String alert =  driver.webobj.getAlert();
	System.out.println ("    ALERT     " + alert);
		
	
	// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
	if (!alert.equals("Please enter your secret answer."))
		// RestartDriver("nz_runconfig.properties",
		// "ISPSignupAndUpgrade.csv");
		Logger
				.error(" *** ERROR: Error message was not returned when left the following field blank: Secret Answer");

	dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

}


	@Test
	public void NZ_CCValidation_BlankField() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please enter your Credit Card Number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Number");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_PaymentMethodValidation_BlankField() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		//driver.webobj.type("ccNumber", "");
		//driver.webobj.select("ccExpMonth", "label=07");
		//driver.webobj.select("ccExpYear", "label=2016");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please select a payment method."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following blank: Payment Type Selection");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	
	@Test
	public void NZ_CCValidation_InvalidCharacters() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "12323232323");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_SpecialCharacters() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "!@#%$#%$");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_Invalid_CC() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.runStep("ChoosePayMethod_CC");
		//driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "12345678901234");
		//driver.webobj.select("ccExpMonth", "label=07");
		//driver.webobj.select("ccExpYear", "label=2016");
		//driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("The Credit Card number you entered is invalid. Please re-enter your Credit Card number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when the following field is invalid: Credit Card Number");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_BlankExpMonth() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=Month");
		driver.webobj.select("ccExpYear", "label=2016");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please tell us the month in which your Credit Card expires."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Expiration Month");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");


	}

	@Test
	public void NZ_CCValidation_BlankExpYear() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=07");
		driver.webobj.select("ccExpYear", "label=Year");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please tell us the year in which your Credit Card expires."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Expiration Year");
		
			
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}

	@Test
	public void NZ_CCValidation_InvalidExpireMonthYear() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=01");
		driver.webobj.select("ccExpYear", "label=2013");
		driver.webobj.type("ccCvm", "123");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please enter a valid expiration date."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card Expiration Month and Year");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}
	
	
	public void NZ_CvmValidation_Blank() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=01");
		driver.webobj.select("ccExpYear", "label=2018");
		driver.webobj.type("ccCvm", "");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("Please tell us your Credit card's CVM number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card CVM");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}
	
	
	public void NZ_CvmValidation_Invalid() {
		driver.runStep("DeleteCookies");
		dsl_formFillOut.LoadDSL_EYI_Page ();
		dsl_formFillOut.EnterDSLBasicInfo ();
		dsl_formFillOut.EnterMemberIdDetails ();

		driver.webobj.select("selectedPaymentType", "label=Credit Card");
		driver.webobj.type("ccNumber", "5412345678901190");
		driver.webobj.select("ccExpMonth", "label=01");
		driver.webobj.select("ccExpYear", "label=2018");
		driver.webobj.type("ccCvm", "!@#");
		//driver.runStep("AcceptingAndSubmitting");

		driver.webobj.click("acceptTerms");
		driver.webobj.click("_eventId_success");
		
		//assertEquals(driver.webobj.getAlert(), "Please tell us your First Name.");
		String alert =  driver.webobj.getAlert();
		System.out.println ("    ALERT     " + alert);
			
		
		// driver.webobj.click("//tbody/tr[4]/td[3]/a/table/tbody/tr/td[2]/span");
		if (!alert.equals("The CVM number you entered is invalid. Please re-enter your CVM number."))
			// ff.RestartDriver("nz_runconfig.properties",
			// "ISPSignupAndUpgrade.csv");
			Logger
					.error(" *** ERROR: Error message was not returned when left the following field blank: Credit Card CVM");
		
			
		dsl_formFillOut.RestartDriver("nz_runconfig.properties", "DslSignupAndUpgrade.csv");

	}
	
	
	
	
	
	
	

}
