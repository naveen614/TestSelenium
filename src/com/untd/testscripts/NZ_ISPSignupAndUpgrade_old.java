package com.untd.testscripts;

import java.sql.Driver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.cmates.selenium.framework.SeleniumDriver;
import com.cmates.selenium.framework.page.WebObj;
import com.cmates.selenium.framework.recovery.TestNgIntegration;
import com.cmates.selenium.framework.utils.Logger;
import com.untd.testscripts.Utils.*;

public class NZ_ISPSignupAndUpgrade_old extends TestNgIntegration {

	String brand = "NZ", service = null, paytype = null, pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;

	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");
		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);
	}

	@Test(groups = { "ISPSignup" })
	public void A_EPack_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreEpackSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyEPackConfirmationPage");
			service = "Epack";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Epack CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("EPACK CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_EPack_LEC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreEpackSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyEPackConfirmationPage");
			service = "Epack";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);

			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Epack LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("EPACK LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_LearningEdge_CC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreLESignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyLEConfirmationPage");
			service = "Learningedge";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Learning Edge CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("LEARNING EDGE CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_LearningEdge_LEC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreLESignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyLEConfirmationPage");
			service = "Learningedge";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Learning Edge LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {

			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("LEARNING EDGE LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_PCTuneUp_CC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePCTPSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPCTuneUpConfirmationPage");
			service = "Pctuneup";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PCTuneUp CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PCTUNEUP CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_PCTuneUp_LEC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePCTPSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPCTuneUpConfirmationPage");
			service = "Pctuneup";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("PCTuneUp LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("PCTUNEUP LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		}
	}

	@Test(groups = { "ISPSignup" })
	public void A_ValuePack_CC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreVPSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {

			driver.runStep("VerifyVPConfirmationPage");
			service = "Valuepack";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("ValuePack CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("VALUEPACK CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_ValuePack_LEC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreVPSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {

			driver.runStep("VerifyVPConfirmationPage");
			service = "Valuepack";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("ValuePack LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("VALUEPACK LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "ISPSignup" })
	public void A_MM_CC_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreMMSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMConfirmationPage");
			service = "Megamail";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MM CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MM CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void A_MM_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreMMSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMConfirmationPage");
			service = "Megamail";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MM LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MM LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void A_MMPlus_CC_Signup_1() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreMMPlusSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMPlusConfirmationPage");
			service = "Mmplus";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MMPlus CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MMPLUS CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void A_MMPlus_CC_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreMMPlusSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMPlusConfirmationPage");
			service = "Mmplus";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MMPlus CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MMPLUS CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void MMPlus_CC_Signup_3() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreMMPlusSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMMPlusConfirmationPage");
			service = "Mmplus";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("MMPlus CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("MMPLUS CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePlatSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Platinum LEC Signup is successfull");
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_CC_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelSignup");
		// driver.runStep("EnterBasicInfo");
		WebRegFunctions.ISP_EnterBasicInfo();
		// driver.runStep("EnterMemberIDDetails");
		WebRegFunctions.WIR_EnterMemberIdDetails();
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_LEC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePlatSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_ACH");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "ACH";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Platinum ACH Signup is successfull");
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Accelerator_ACH_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_ACH");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "ACH";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePlatSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Platinum CC Signup is successfull");
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_Platinum_CC_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStorePage");
		driver.runStep("StorePlatSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Platinum CC Signup is successfull");
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FreeIsp_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("FreeIspLandingPage");
		driver.runStep("FreeIspSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("TellUsAboutYourself");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeIspConfirmationVerification");
			service = "FreeIsp";
			paytype = "Free";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free Isp Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FREE ISP SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FreeIsp_Signup_2() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("FreeIspLandingPage");
		driver.runStep("FreeIspSignup");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("TellUsAboutYourself");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeIspConfirmationVerification");
			service = "FreeIsp";
			paytype = "Free";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Free Isp Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FREE ISP SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPUpgrades" })
	public void B_Platinum_CC_To_Accel_Upgrade() {

		String filename = brand + "_Platinum_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();

		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelUpgrade");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
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
			RestartDriver();
			Logger
					.error("PLATINUM CC TO ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPUpgrades" })
	public void B_Accel_CC_To_Mmplus_Upgrade() {

		String filename = brand + "_Accel_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StoreMMPlusUpgrade");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMmplusUpgradeConfirmation");
			String srcfilename = brand + "_Accel_CC_Accounts.txt";
			String dstnfilename = brand + "_Mmplus_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC To Mmplus CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			RestartDriver();
			Logger
					.error("ACCELERATOR CC To MMPLUS CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPUpgrades" })
	public void B_Accel_CC_To_Vpack_Upgrade() {

		String filename = brand + "_Accel_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StoreVpUpgrade");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyVpUpgradeConfirmation");
			String srcfilename = brand + "_Accel_CC_Accounts.txt";
			String dstnfilename = brand + "_Valuepack_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Accelerator CC To Vpack CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error("ACCELERATOR CC To VPACK CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

	}

	@Test(groups = { "ISPUpgrades" })
	public void B_FreeISP_To_Accel_Upgrade() {

		String filename = brand + "_FreeIsp_Free_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelUpgrade");
		driver.runStep("ChoosePayMethod_CC");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_FreeIsp_Free_Accounts.txt";
			String dstnfilename = brand + "_Accel_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info(" Free ISP To Accelerator CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			RestartDriver();
			Logger
					.error(" Free ISP To ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	/*
	 * @Test(groups = { "ISPUpgrades" }) public void
	 * B_Megamail_CC_To_Accel_Upgrade() {
	 * 
	 * String filename = brand + "_Megamail_CC_Accounts.txt"; // String filepath
	 * = // "E:/Eclipse3.5/Automation/src/resources/Files/"+filename; String
	 * filepath = System.getProperty("user.dir") + "/src/resources/Files/" +
	 * filename;
	 * 
	 * FileOperations fo = new FileOperations(); String uid =
	 * fo.doReadTextFile(filepath);
	 * 
	 * SeleniumDriver.webobj.deleteAllVisibleCookies(); RestartDriver();
	 * driver.runStep("LoadStartPage");
	 * 
	 * while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
	 * driver.runStep("WaitForStartPageLoad"); }
	 * SeleniumDriver.webobj.type("memberId", uid);
	 * 
	 * while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
	 * driver.runStep("WaitForStartPageLoad"); }
	 * SeleniumDriver.webobj.type("password", pwd);
	 * 
	 * driver.runStep("ClickingSigninButton");
	 * driver.runStep("WaitForStartPageLoad");
	 * driver.runStep("ClickingUpgradeLink");
	 * SeleniumDriver.webobj.pause("20000");
	 * 
	 * // driver.runStep("LoadStorePage"); driver.runStep("StoreAccelUpgrade");
	 * SeleniumDriver.webobj.pause("10000");
	 * driver.runStep("SubmittingEyiPage");
	 * 
	 * SeleniumDriver.webobj.pause("50000"); boolean b =
	 * SeleniumDriver.webobj.isTextPresent("Order Confirmation");
	 * Logger.info("Value of boolean variable b:" + b);
	 * 
	 * if (b) { driver.runStep("VerifyAccelUpgradeConfirmation"); String
	 * srcfilename = brand + "_Megamail_CC_Accounts.txt"; String dstnfilename =
	 * brand + "_Accel_CC_Accounts.txt"; fo.updateFiles(srcfilename,
	 * dstnfilename, uid); Logger
	 * .info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	 * Logger .info(" Megamail CC To Accelerator CC Upgrade is successfull");
	 * Logger
	 * .info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	 * } else { Logger
	 * .info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	 * Logger
	 * .error(" MEGAMAIL CC To ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
	 * Logger
	 * .info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	 * }
	 * 
	 * // Following five lines code to avoid the 'Confirm' dialogue box shown //
	 * for the Isp users to alert about software download. // This piece of code
	 * will end the browser session after completing the // Isp signup and
	 * restart it again. // Code Start Here RestartDriver ();
	 * 
	 * }
	 */

	@Test(groups = { "ISPUpgrades" })
	public void B_Megamailplus_CC_To_Accel_Upgrade() {

		String filename = brand + "_Mmplus_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StoreAccelUpgrade");
		// driver.runStep("ChoosePayMethod_CC");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelUpgradeConfirmation");
			String srcfilename = brand + "_Mmplus_CC_Accounts.txt";
			String dstnfilename = brand + "_Accel_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Megamail Plus CC To Accelerator CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" MEGAMAIL PLUS CC To ACCELERATOR CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPUpgrades" })
	public void B_Plat_ACH_To_Mmplus_PcTuneUp_Upgrade() {

		String filename = brand + "_Platinum_ACH_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");

		driver.runStep("StoreMMPlusUpgrade");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("ChangeISPPaymentType_CC");
		driver.runStep("ChangeISPPaymentType_CC");
		driver.runStep("ChangePaymentType_CC");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyMmplusUpgradeConfirmation");
			SeleniumDriver.webobj.pause("10000");
			driver.runStep("PurchasingPcTuneUp");
			// driver.runStep("PurchasingNisUpsell");
			// driver.runStep("VerifyNisDetailsOnConfirmation");
			String srcfilename = brand + "_Platinum_ACH_Accounts.txt";
			String dstnfilename = brand + "_Mmplus_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" Platinum CC To MMplus, PcTuneUp CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			RestartDriver();
			Logger
					.error(" PLATINUM CC To MMPLUS, PcTuneUp CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		RestartDriver();
	}

	@Test(groups = { "ISPUpgrades" })
	public void B_MMP_CC_To_Platinum_Nis_Upgrade() {

		String filename = brand + "_Mmplus_CC_Accounts.txt";
		// String filepath =
		// "E:/Eclipse3.5/Automation/src/resources/Files/"+filename;
		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		// driver.runStep("LoadStorePage");
		driver.runStep("StorePlatinumlUpgrade");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SubmittingEyiPage");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatinumConfirmation");
			SeleniumDriver.webobj.pause("10000");
			driver.runStep("PurchasingNis");

			SeleniumDriver.webobj.pause("10000");
			driver.runStep("VerifyNisDetails");
			String srcfilename = brand + "_Mmplus_CC_Accounts.txt";
			String dstnfilename = brand + "_Platinum_CC_Accounts.txt";
			fo.updateFiles(srcfilename, dstnfilename, uid);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info(" MMplus CC To Platinum, NIS CC Upgrade is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error(" MMPLUS CC To PLATINUM, NIS CC UPGRADE IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_SOLP_MeteringOn_CC_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadSOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SolpTollFreeSignup");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("TFMeteringOn");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_SOLP_MeteringOff_CC_Signup() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadSOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("SolpTollFreeSignup");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_DOLP_MeteringOn_CC_Signup() {
		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();

		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpTollFreeSignup");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("TFMeteringOn");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_DOLP_MeteringOff_CC_Signup() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpTollFreeSignup");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFreeDOLP_Accel1495_CC_Signup() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadDOTollFreeLandingPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("DolpAccel1495Signup");
		SeleniumDriver.webobj.pause("5000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_Accessnumbers_MeteringOn_CC_Signup() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadAccessNumbersTollFreeOfferPage");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("TFMeteringOn");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_TollFree_Accessnumbers_MeteringOff_CC_Signup() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadAccessNumbersTollFreeOfferPage");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyTFConfirmationPage");
			service = "Tollfree";
			paytype = "CC";
			FileOperations fo = new FileOperations();
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
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Accelerator_Signup_CC_SUN() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("ClickingNZAccelSignupNowButton");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Accelerator CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FRONT DOOR ACCELERATOR CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Accelerator_Signup_LEC_MI() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("ClickingNZAccelMoreInfoLink");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("ClickingNZAccelLandingSignUpNowButton");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_LEC");
		// driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyAccelConfirmationPage");
			service = "Accel";
			paytype = "LEC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Accelerator LEC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error("FRONT DOOR ACCELERATOR LEC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Platinum_Signup_CC_SUN() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("ClickingNZPlatinumSignupNowLink");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_CC");
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Platinum CC Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FRONT DOOR PLATINUM CC SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_Platinum_Signup_ACH_MI() {

		// SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();

		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("ClickingNZPlatinumMoreInfoLink");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("ClickingNZPlatinumLandingSignUpNowButton");
		driver.runStep("EnterBasicInfo");

		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("ChoosePayMethod_ACH");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyPlatConfirmationPage");
			service = "Platinum";
			paytype = "ACH";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Platinum ACH Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FRONT DOOR PLATINUM ACH SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();
	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_FreeIsp_Signup() {

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();

		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("SigningUpFDFreeDialUp");

		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("TellUsAboutYourself");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeIspConfirmationVerification");
			service = "FreeIsp";
			paytype = "Free";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Free Isp Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FRONT DOOR FREE ISP SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_FreeEmail_Signup() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();

		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("SigningUpFDFreeEmail");

		driver.runStep("EnterBasicInfo");
		driver.runStep("EnterMemberIDDetails");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		SeleniumDriver.webobj.pause("10000");
		driver.runStep("TellUsAboutYourself");
		String str = SeleniumDriver.webobj.getCookieByName("cw");
		System.out.println(str);
		SeleniumDriver.webobj.type("captchaTypedWord", str);
		driver.runStep("AcceptingAndSubmitting");

		SeleniumDriver.webobj.pause("50000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("FreeEmailConfirmationVerification");
			service = "FreeEmail";
			paytype = "Free";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.info("Front Door Free Email Signup is successfull");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger.error("FRONT DOOR FREE EMAIL SIGNUP IS NOT SUCCESSFULL");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// Following five lines code to avoid the 'Confirm' dialogue box shown
		// for the Isp users to alert about software download.
		// This piece of code will end the browser session after completing the
		// Isp signup and restart it again.
		// Code Start Here
		RestartDriver();

	}

	@Test(groups = { "ISPSignup" })
	public void A_FrontDoor_DSLSaver_Signup_CC() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();

		driver.runStep("LoadFrontDoorPage");
		SeleniumDriver.webobj.pause("10000");

		driver.runStep("FrontDoorDSLSaverSignUp");
		driver.runStep("EnteringBillingDetails_DSL");
		driver.runStep("EnteringShippingDetails_DSL");
		driver.runStep("EnteringCCDetails_DSL");
		driver.runStep("EnteringMemberIDDetails_DSL");
		String uid = SeleniumDriver.webobj.getValue("memberId");
		driver.runStep("AcceptingAndSubmitting_DSL");

		SeleniumDriver.webobj.pause("30000");
		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			driver.runStep("VerifyingDSLSaverDetails");
			service = "FrontDoor_DSLSaver";
			paytype = "CC";
			FileOperations fo = new FileOperations();
			fo.doWriteTextFile(uid, brand, service, paytype);
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.info("VZE Saver 0768 CC Signup is successfull from the Front Door");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		} else {
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Logger
					.error("VZE SAVER 0768 CC SIGNUP IS NOT SUCCESSFULL FROM THE FRONT DOOR");
			Logger
					.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		}

	}

	@Test
	public void B_Platinum_LEC_To_DSLSaver_CC_Upgrade() {

		String filename = brand + "_Platinum_LEC_Accounts.txt";

		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();

		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		driver.runStep("DSLStorePageSignup");
		driver.runStep("EnteringAndSubmittingTN8182873200");
		driver.runStep("ClickGetStartedButton_StoreDmn");
		driver.runStep("SelectedSaverPlan");
		driver.runStep("ConfirmPayMethod_LEC");
		driver.runStep("AcceptingAndSubmittingEyiPage");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");
		}

		String srcfilename = brand + "_Platinum_LEC_Accounts.txt";
		String dstnfilename = brand + "_DSL_Saver_LEC_Accounts.txt";
		fo.updateFiles(srcfilename, dstnfilename, uid);
		System.out.println("source file: " + srcfilename);
		System.out.println("destination file: " + dstnfilename);
	}

	@Test
	public void B_Accel_ACH_To_DSL_SpeedSaver_CC_Upgrade() {

		String filename = brand + "_Accel_ACH_Accounts.txt";

		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();

		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		driver.runStep("DSLStorePageSignup");
		driver.runStep("EnteringAndSubmittingTN8182873222");
		driver.runStep("ClickGetStartedButton_StoreDmn");
		driver.runStep("SelectedAttsSpeedSaverPlan");
		driver.runStep("EnteringDetailsInAddressOverlay");
		driver.runStep("SubmittingAttsAddressOverlay");

		driver.runStep("ChangePaymentType_CC");

		driver.runStep("AcceptingAndSubmittingEyiPage");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifySpeedsaverConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");
		}

		String srcfilename = brand + "_Accel_ACH_Accounts.txt";
		String dstnfilename = brand + "_DSL_SpeedSaver_CC_Accounts.txt";
		fo.updateFiles(srcfilename, dstnfilename, uid);
		System.out.println("source file: " + srcfilename);
		System.out.println("destination file: " + dstnfilename);
	}

	@Test
	public void B_FreeISP_To_DSL_Pro_CC_Upgrade() {

		String filename = brand + "_FreeIsp_Free_Accounts.txt";

		String filepath = System.getProperty("user.dir")
				+ "/src/resources/Files/" + filename;

		FileOperations fo = new FileOperations();

		String uid = fo.doReadTextFile(filepath);

		SeleniumDriver.webobj.deleteAllVisibleCookies();
		RestartDriver();
		driver.runStep("LoadStartPage");

		while (!(SeleniumDriver.webobj.isElementPresent("memberId"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("memberId", uid);

		while (!(SeleniumDriver.webobj.isElementPresent("password"))) {
			driver.runStep("WaitForStartPageLoad");
		}
		SeleniumDriver.webobj.type("password", pwd);

		driver.runStep("ClickingSigninButton");
		driver.runStep("WaitForStartPageLoad");
		driver.runStep("ClickingUpgradeLink");
		SeleniumDriver.webobj.pause("20000");

		driver.runStep("DSLStorePageSignup");
		driver.runStep("EnteringAndSubmittingTN8182873218");
		driver.runStep("ClickGetStartedButton_StoreDmn");
		driver.runStep("SelectedCqwProPlan");
		driver.runStep("SubmittingAddressOverlay");

		driver.runStep("ChangePaymentType_CC");

		driver.runStep("AcceptingAndSubmittingEyiPage");

		boolean b = SeleniumDriver.webobj.isTextPresent("Order Confirmation");
		Logger.info("Value of boolean variable b:" + b);

		if (b) {
			// Verify confirmation Page.
			driver.runStep("VerifyDSLProConfirmationPage");
			driver.runStep("VerifyBillingAndShippingAddress");
		}

		String srcfilename = brand + "_FreeIsp_Free_Accounts.txt";
		String dstnfilename = brand + "_DSL_Pro_CC_Accounts.txt";
		fo.updateFiles(srcfilename, dstnfilename, uid);
		System.out.println("source file: " + srcfilename);
		System.out.println("destination file: " + dstnfilename);
	}

	public void RestartDriver() {
		SeleniumDriver.webobj.deleteAllVisibleCookies();

		SeleniumDriver.webobj.pause("1000");
		SeleniumDriver.webobj.stop();
		SeleniumDriver.webobj.pause("1000");
		SeleniumDriver.webobj.start();
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");
	}
}
