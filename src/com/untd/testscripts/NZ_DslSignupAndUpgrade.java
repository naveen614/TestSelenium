package com.untd.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;

import java.lang.*;
import java.io.*;
import com.untd.testscripts.Utils.*;

public class NZ_DslSignupAndUpgrade extends TestNgIntegration {

	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	GeneralFunctions gf = new GeneralFunctions();
	
	String brand = "NZ", service = null, paytype = null, pwd = "netzero";

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/DslSignupAndUpgrade.csv");
	
		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);
	
	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZE_Saver0768_CC_Signup() {
		service = "DSL_VZE_Saver";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3200.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873200");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSaverPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);

			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("VZE Saver 0768 CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("VZE SAVER 0768 CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZE_Pro3000_LEC_Signup() {
		service = "DSL_VZE_Pro";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3200.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873200");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedProPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZE Pro LEC  Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("VZE PRO LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZE_Ultra7100_CC_Signup() {
		service = "DSL_VZE_Ultra";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3200.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873200");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedUltraPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {

			// Verify confirmation Page.
			driver.runStep("VerifyUltraConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZE Ultra CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZE ULTRA CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZE_SpeedSaver1500_LEC_Signup() {
		service = "DSL_VZE_Speedsaver";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3201.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873201");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSpeedSaverPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySpeedSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZE SpeedSaver LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZE SPEEDSAVER LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignup" })
	public void NZ_Dsl_VZW_Saver0768_LEC_Signup() {
		service = "DSL_VZW_Saver";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3209.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873209");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSaverPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyVZWSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZW Saver LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZW Saver LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZW_Pro3000_CC_Signup() {
		service = "DSL_VZW_Pro";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3209.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873209");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedProPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyVZWProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZW Pro CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZW PRO CCSIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZW_Ultra7100_LEC_Signup() {
		service = "DSL_VZW_Ultra";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3209.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873209");
		driver.runStep("ClickGetStartedButton_RegisterDmn");

		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedUltraPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyVZWUltraConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZW Ultra LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZW ULTRA LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_VZW_SpeedSaver1500_CC_Signup() {

		service = "DSL_VZW_Speedsaver";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3210.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873210");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSpeedSaverPlan");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyVZWSpeedSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" VZW SpeedSaver CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" VZW SPEEDSAVER CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl__SpeedSaver1500_CC_Signup() {
		service = "DSL__Speedsaver";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3218.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873218");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSpeedSaverPlan");
		driver.runStep("SubmittingAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySpeedSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("  SpeedSaver CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("  SPEEDSAVER CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl__Pro3000_LEC_Signup() {
		service = "DSL__Pro";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3218.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873218");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedProPlan");
		driver.runStep("SubmittingAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("  Pro LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("  PRO LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl__Ultra6000_CC_Signup() {
		service = "DSL__Ultra";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3218.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873218");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedUltraPlan");
		driver.runStep("SubmittingAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyUltraConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("  Ultra CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("  ULTRA CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_ATTS_SpeedSaver1500_LEC_Signup() {
		service = "DSL_ATTS_SpeedSaver";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3222.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873222");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedAttsSpeedSaverPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingAttsAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyAttsSpeedSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" ATTS SpeedSaver LEC  Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" ATTS SPEEDSAVER LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_ATTS_Pro3000_CC_Signup() {
		service = "DSL_ATTS_Pro";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3222.
		driver.runStep("LoadDslLandingPage");
		// driver.runStep("LoadStorePage");
		// driver.runStep("DSLStorePageSignup");

		driver.runStep("EnteringAndSubmittingTN8182873222");
		driver.runStep("ClickGetStartedButton_RegisterDmn");

		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedAttsProPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingAttsAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyAttsProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" ATTS Pro CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" ATTS PRO CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_ATTS_Ultra6000_LEC_Signup() {
		service = "DSL_ATTS_Ultra";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3222.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873222");
		driver.runStep("ClickGetStartedButton_RegisterDmn");

		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedAttsUltraPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingAttsAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyAttsUltraConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" ATTS Ultra LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" ATTS ULTRA LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_SonicTas_SpeedSaver1500_CC_Signup() {
		service = "DSL_SonicTas_SpeedSaver";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3226.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873226");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSonicTasSpeedSaverPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingSonicTasAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySonicTasSpeedSaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" SonicTas SpeedSaver CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" SONICTAS SPEEDSAVER CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_SonicTas_Pro3000_LEC_Signup() {
		service = "DSL_SonicTas_Pro";
		paytype = "LEC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3226.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873226");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSonicTasProPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingSonicTasAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySonicTasProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" SonicTas Pro LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" SONICTAS PRO LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "NZDSLSignups" })
	public void NZ_Dsl_SonicTas_Ultra6000_CC_Signup() {
		service = "DSL_SonicTas_Ultra";
		paytype = "CC";

		driver.runStep("DeleteCookies");

		// Loading the DSL landing page, entering and submitting the TN#
		// 818-287-3226.
		driver.runStep("LoadDslLandingPage");
		driver.runStep("EnteringAndSubmittingTN8182873226");
		driver.runStep("ClickGetStartedButton_RegisterDmn");
		// Selecting the Dsl Saver Plan on the 'Choose A Plan' page.
		driver.runStep("SelectedSonicTasUltraPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingSonicTasAddressOverlay");

		// Entering details on the EYI page and submitting it.
		String uid = EnterInformation(paytype);

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySonicTasUltraConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");

			// Writing the Account information to the destination text file.
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" SonicTas Ultra CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error(" SONICTAS ULTRA CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	public String EnterInformation(String payment_method) {

		// Entering details on the EYI page and submitting it.
		driver.runStep("BillingAddressInformation");
		driver.runStep("ShippingAddressInformation");
		if (SeleniumDriver.webobj.isTextPresent("Security Check"))
			WebRegFunctions.ISP_EnterCAPTCHA ();

		if (payment_method == "CC") {
			driver.runStep("ChoosePayMethod_CC");
		} else {
			driver.runStep("ChoosePayMethod_LEC");
		}

		driver.runStep("MemberIdDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("AcceptingAndSubmittingEyiPage ");
		
		if (SeleniumDriver.webobj.isTextPresent("To continue with registration, please enter the word as it is shown in the image below."))
		{
			gf.VerifyCookieLoad(30, "cw", "Unable to find \"cw\" cookie");
			String captchaWord = (SeleniumDriver.webobj.getCookieByName("cw"));
			SeleniumDriver.webobj.type("id=captchaTypedWord", captchaWord);
			SeleniumDriver.webobj.click ("name=_eventId_success");
			
		}
			
		gf.VerifyPageLoadEx(60, "Order Confirmation", "Unable to find Confirmation Page");
		return (uid);

	}

}
