package com.untd.testscripts;

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

public class NZ_WIR_SignupAndUpgrade extends TestNgIntegration {

	String brand = "NZ", service = "null", paytype = "null", pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	private Properties runConfigProperties = null;
	private Properties envConfigProperties = SystemConfig.envConfigProperties;
	GeneralFunctions gf;// = new GeneralFunctions();
	FileOperations fo = new FileOperations();
	String VisaCcNum, uid, MC_CcNum;


	@BeforeClass
	public void setUp() {
		driver = new SeleniumDriver();
		WebRegFunctions = new ISP_RegistrationFormFunctions(driver);
		gf = new GeneralFunctions();
		//gf = new GeneralFunctions(driver);
		driver.startDriver(System.getProperty("user.dir")
				+ "/src/resources/config/nz_runconfig.properties", System
				.getProperty("user.dir")
				+ "/src/resources/csv/ISPSignupAndUpgrade.csv");
		

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

		// ***********************
		// Read envconfig.properties file.
/*
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

		VisaCcNum = (envConfigProperties.getProperty(env + ".VisaWRLSNum"));
		MC_CcNum = (envConfigProperties.getProperty(env + ".MCWRLSNum"));
		// System.out.println ("VisaCcNum");
		// VisaExpMonth = (EnvConfigProperties.getProperty(env +
		// ".VisaExpMonth"));
		// VisaExpYear = (EnvConfigProperties.getProperty(env +
		// ".VisaExpYear"));
	}

/*	@AfterClass
	public void CloseBrowser (){
		driver.webobj.close();
		driver.webobj.stop();
	}
	*/
	
	
	
	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Plus_MiFi_Signup_LoopQual() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String LoopQual = "Continue"; // select "Continue" option on Coverage Notification page
		
		uid = WebRegFunctions.WIR_Signup_WWW_LoopQual(planName, deviceName, VisaCcNum, LoopQual);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Platinum_Modem_Signup_LoopQual() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String LoopQual = "Cancel"; // select "Cancel" option on Coverage Notification page
		
		uid = WebRegFunctions.WIR_Signup_WWW_LoopQual(planName, deviceName, VisaCcNum, LoopQual);
		
		// Writing the MemberID to the destination text file.
		//fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Free_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		

		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Free_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "USBModem";

		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Plus_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file

		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Plus_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		
		String planName = "Plus";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_BASIC_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_BASIC_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Pro_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Pro_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Platinum_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Platinum_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	
	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Free_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Free_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Plus_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Plus_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_BASIC_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_BASIC_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Pro_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Pro_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Platinum_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_Platinum_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	//@Test(groups = { "WIRSignup" })
	/*public void A_Store_WRLS_Platinum_Modem_Signup_v1() {

		String planName = "Platinum";
		String deviceName = "USBModem";

		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	*/
	
	
	
	
	//Store Signups:
	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		

	uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
				
		// Writing the MemberID to the destination text file.
			fo.doWriteTextFile(uid, brand, service, paytype);
			
			WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
				
		// Writing the MemberID to the destination text file.
			fo.doWriteTextFile(uid, brand, service, paytype);
					
			WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
				
		// Writing the MemberID to the destination text file.
			fo.doWriteTextFile(uid, brand, service, paytype);
			
			WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_MiFi_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_Modem_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v1(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	
	

	
	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		

		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_MiFi_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_Modem_Signup_v2() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v2(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	
	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_MiFi_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		

		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Free_Modem_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_MiFi_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Plus_Modem_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Plus";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_MiFi_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_BASIC_Modem_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_MiFi_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Pro_Modem_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Pro";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_MiFi_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	@Test(groups = { "WIRSignup" })
	public void A_Store_WRLS_Platinum_Modem_Signup_v3() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Platinum";
		String deviceName = "USBModem";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		
		uid = WebRegFunctions.WIR_Signup_Store_v3(planName, deviceName, VisaCcNum);
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	
	//Start page upgrades to Wireless
		
	@Test
	public void B_Store_WRLS_Free_MiFi_To_Basic_Upgrade (){
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		
		String productName = "Basic";
		String filename = brand + "_WIR_Free_MiFi_CC_Accounts.txt";
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		String uid = fo.doReadTextFile(filepath);
		
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);

		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		gf.VerifyElementLoad(30, "//div[@id='t2']",
				"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Monthly Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Basic Plan
		//driver.webobj.click("xpath=(//input[@type='image'])[3]");
		//driver.webobj.click("link=Order Now");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-basic-9-95-monthly')]");
				
		//Validate Customer Information Page
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		gf.VerifyPageLoad(120, "Current Payment Method", "Unable to find \"CUSTOMER INFO\" page");
		
		
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			//WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	
	@Test
	public void B_Store_WRLS_Free_USBModem_To_Plus_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Plus";
		
		String filename = brand + "_WIR_Free_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		gf.VerifyElementLoad(30, "//div[@id='t2']",
				"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Plus Plan
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-plus-19-95-double-data-monthly')]");
		//driver.webobj.click("xpath=(//input[@type='image'])[4]");
		//driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-plus-19-95-monthly')]");
		
		//Validate Customer Information Page
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			//WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Plus_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	@Test
	public void B_Store_WRLS_Free_MiFi_To_Pro_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Pro";
		
		String filename = brand + "_WIR_Free_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		gf.VerifyElementLoad(30, "//div[@id='t2']",
				"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Monthly Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Pro Plan
		//driver.webobj.click("xpath=(//input[@type='image'])[5]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-pro-34-95-double-data-monthly')]");

		//driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-pro-34-95-monthly')]");
		
		//Validate Customer Information Page
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	@Test
	public void B_Store_WRLS_Free_USBModem_To_Platinum_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Platinum";
		
		String filename = brand + "_WIR_Free_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband Platinumduct page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		gf.VerifyElementLoad(30, "//div[@id='t2']",
				"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Platinum Plan
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-platinum-49-95-double-data-monthly')]");
		//driver.webobj.click("xpath=(//input[@type='image'])[6]");
		//driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-platinum-49-95-monthly')]");
		
		//Validate Customer Information Page
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	

	@Test
	public void B_Store_WRLS_Basic_MiFi_To_Plus_Upgrade (){
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		//Upgrade from Start page
		String productName = "Plus";
		
		String filename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		//gf.VerifyElementLoad(30, "//div[@id='t2']",
		//		"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Plus Plan
		driver.webobj.pause ("1000");
		//driver.webobj.click("xpath=(//input[@type='image'])[4]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-plus-19-95-double-data-monthly')]");
		//driver.webobj.click("link=Order Now");
		
		
		
		//Validate Customer Information Page
		driver.webobj.pause ("5000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			//WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Plus_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	@Test
	public void B_Store_WRLS_Basic_USBModem_To_Pro_Upgrade (){
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		
		//Upgrade from Start page
		String productName = "Pro";
		
		String filename = brand + "_WIR_Basic_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		//gf.VerifyElementLoad(30, "//div[@id='t2']",
		//		"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Pro Plan
		driver.webobj.pause ("5000");
		//driver.webobj.click("xpath=(//input[@type='image'])[2]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-pro-34-95-double-data-monthly')]");
		//driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-pro-34-95-monthly')]");
		

		//Validate Customer Information Page
		driver.webobj.pause ("2000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	@Test
	public void B_Store_WRLS_Basic_USBModem_To_Platinum_Upgrade (){
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		
		//Upgrade from Start page
		String productName = "Platinum";
		
		String filename = brand + "_WIR_Basic_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband Platinum page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		//gf.VerifyElementLoad(30, "//div[@id='t2']",
		//		"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
	//	gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Platinum Plan
		driver.webobj.pause ("1000");
		//driver.webobj.click("xpath=(//input[@type='image'])[3]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-platinum-49-95-double-data-monthly')]");
		
		//Validate Customer Information Page
		driver.webobj.pause ("1000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	
	@Test
	public void B_Store_WRLS_Basic_MiFi_To_Pro_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Pro";
		
		String filename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband product page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		gf.VerifyElementLoad(30, "//div[@id='t2']",
				"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Pro Plan
		driver.webobj.pause ("5000");
		//driver.webobj.click("xpath=(//input[@type='image'])[5]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-pro-34-95-double-data-monthly')]");
		//driver.webobj.click("link=Order Now");
		
		//Validate Customer Information Page
		driver.webobj.pause ("1000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
			//WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	
	@Test
	public void B_Store_WRLS_Plus_USBModem_To_Platinum_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Platinum";
		
		String filename = brand + "_WIR_Plus_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» Upgrade Today!");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.pause ("1000");
		driver.webobj.click("link=» 4G Mobile Broadband");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband Platinumduct page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		//gf.VerifyElementLoad(30, "//div[@id='t2']",
		//		"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Platinum Plan
		driver.webobj.pause ("5000");
		//driver.webobj.click("xpath=(//input[@type='image'])[2]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-platinum-49-95-double-data-monthly')]");
		
		//Validate Customer Information Page
		driver.webobj.pause ("1000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}

	
	@Test
	public void B_Store_WRLS_Pro_MiFi_To_Platinum_Upgrade (){
		//Upgrade from Start page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		String productName = "Platinum";
		
		String filename = brand + "_WIR_Pro_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Start page
		driver.runStep("LoadStartPage");
		WebRegFunctions.LoginToStartPage (uid, pwd);
		
		//Click Upgrade link
		driver.webobj.click("link=» Upgrade Today!");
		driver.webobj.pause ("1000");
		
		// Validate Store page and click Mobile Broadbank link
		gf.VerifyPageLoad(30, "4G Mobile Broadband",
				"Unable to find STORE page");
		driver.webobj.click("link=» 4G Mobile Broadband");
		driver.webobj.pause ("1000");
		gf.VerifyPageLoad(30, "NetZero 4G Mobile Broadband",
				"Unable to find Mobile Broadband Platinumduct page");
		
		// Click Plans and Pricing tab
		//div[@id='t2']
		//gf.VerifyElementLoad(30, "//div[@id='t2']",
		//		"Unable to find \"Plans & Pricing\" tab");
		//driver.webobj.click("id=t2");
		//driver.webobj.selectFrame("id=chartContent");
		//gf.VerifyPageLoad(30, "Price",
		//		"Unable to find \"Plans and Pricing\" chart");
		
		//Select Platinum Plan
		driver.webobj.pause ("5000");
		//driver.webobj.click("link=Order Now");
		//driver.webobj.pause ("1000");
		//driver.webobj.click("xpath=(//input[@type='image'])[6]");
		driver.webobj.click("//a[contains(@href, '/account/selectOfferController.do?offerId=nz-wls-platinum-49-95-double-data-monthly')]");
		
		//Validate Customer Information Page
		driver.webobj.pause ("1000");
		gf.VerifyPageLoad(120, "CUSTOMER INFO",
		"Unable to find \"CUSTOMER INFO\" page");
		
		//Fill Out Security Word
		//if (driver.webobj.isVisible("//div[@id='captchaHTML']/span"))
		//	WebRegFunctions.ISP_EnterCAPTCHA();
		
		//Submit and verify Confirmation page
		WebRegFunctions.WIR_Accept_TandC();
		WebRegFunctions.WIR_ClickSubmit();
		WebRegFunctions.WIR_VerifyConfirmationPageOnUpgrade (productName,uid);
		
	//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	

	@Test
	public void B_Account_WRLS_Free_USBModem_To_Pro_Upgrade () {
		
		//Upgrade from Account page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "WebTrain.csv");
		
		String productName = "Pro";
		
		String filename = brand + "_WIR_Free_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Account Page
		driver.runStep("LoadLoginPage");
		WebRegFunctions.loginToAccountPage(GetMemberId(filename, filepath), pwd);
		
		//Click Upgrade button and select a Product
		gf.VerifyPageLoad(30,"MY PRODUCTS & SERVICES", "Unable to find MyAccount page");
		SeleniumDriver.webobj.click ("//img[@alt='Upgrade Image']");
		

		SeleniumDriver.webobj.pause("3000");
		SeleniumDriver.webobj.click("xpath=(//input[@name='selectedPrimaryOffer'])[3]");
		SeleniumDriver.webobj.pause("3000");
		SeleniumDriver.webobj.click("name=purchase");
		
		gf.VerifyPageLoad( 30, "Congratulations!", "Unable to find Upgrade Confirmation overlay");
		SeleniumDriver.webobj.click("css=img.closeHolderAnchor1");
		
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Pro_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "WebTrain.csv");
	}
	
	@Test
	public void B_Account_WRLS_Basic_MiFi_To_Platinum_Upgrade () {
		
		//Upgrade from Account page
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "WebTrain.csv");
		
		String productName = "Platinum";
		
		String filename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Login to Account Page
		driver.runStep("LoadLoginPage");
		WebRegFunctions.loginToAccountPage(GetMemberId(filename, filepath), pwd);
		
		//Click Upgrade button and select a Product
		gf.VerifyPageLoad(30,"MY PRODUCTS & SERVICES", "Unable to find MyAccount page");
		SeleniumDriver.webobj.click ("//img[@alt='Upgrade Image']");
		
		//gf.VerifyPageLoad(10,"Upgrade Your Service Plan", "Unable to find Upgrade Overlay");
		SeleniumDriver.webobj.pause("3000");
		SeleniumDriver.webobj.click("xpath=(//input[@name='selectedPrimaryOffer'])[3]");
		SeleniumDriver.webobj.pause("3000");
		SeleniumDriver.webobj.click("name=purchase");
		
		gf.VerifyPageLoad( 30, "Congratulations!", "Unable to find Upgrade Confirmation overlay");
		SeleniumDriver.webobj.click("css=img.closeHolderAnchor1");
		
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_MiFi_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "WebTrain.csv");
	}

		
	

	@Test(groups = { "WIRSignup" })
	public void A_WWW_WRLS_BASIC_MiFi_Signup_v2_Plus_PCTuneUp_AddOn() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Basic";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		String addon = "PCTuneUp";
		
		
		uid = WebRegFunctions.WIR_Signup_WWW_v2(planName, deviceName, VisaCcNum);
		
		//Purchase PCTuneUp Add-on
		gf.VerifyPageLoad(10, "NetZero Extras", "Unable to find Add Ons on Confirmation Page");
		driver.webobj.click ("link=More Info");
		driver.webobj.pause("5000");
		//driver.webobj.selectFrame("relative=up");
		driver.webobj.selectFrame("overlayIframe");
		
		gf.VerifyPageLoad(10, "Keep your computer running like new with one-click maintenance. Speed up PC performance, fix errors and bugs, clean up your hard drive and protect your privacy. For Windows.", "Unable to find PC TuneUp Addon");
		driver.webobj.click("css=span.fontU");
		driver.webobj.pause("5000");
		driver.webobj.selectWindow("null");
		gf.VerifyPageLoad(10,"Order Details", "Unable to find PC TuneUp AddOn on Confirmation Page");
		gf.VerifyPageLoad(10,"PC Tune-Up", "Unable to find PC TuneUp AddOn on Confirmation Page");
		gf.VerifyPageLoad(10,"$4.95 a month (first month free)", "Unable to find PC TuneUp AddOn on Confirmation Page");
		gf.VerifyPageLoad(10,"PC Tune-Up", "Unable to find PC TuneUp AddOn on Confirmation Page");
		Logger.info("Verified PCTuneUp Addon purchase on Confirmation Page");
		
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, addon, paytype);
		
		

		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	
	

	@Test
	public void B_MINISITE_Add_More_Data_WIR_Basic (){
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		//String productName = "Basic";
		
		String filename = brand + "_WIR_Basic_MiFi_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Load MiniSite page
		driver.runStep("LoadMiniSite_AddMoreData");
		driver.webobj.pause ("5000");
		if (!(driver.webobj.isTextPresent("You have reached the data limit"))){
			
			driver.webobj.click ("id=overridelink");
		}
		gf.VerifyPageLoadEx(10, "You have reached the data limit on your service plan.", "Unable to find MiniSite Webpage - Add More Data");
		
		//Login to Minisite
		driver.webobj.type("id=memberId", uid);
		driver.webobj.type("id=password", pwd);
		driver.webobj.click ("name=_eventId_success");
		gf.VerifyPageLoadEx(10, "To continue using your NetZero 4G Mobile Broadband service, please purchase more data or upgrade your service plan.", "Unable to login to MiniSite");
		Logger.info("Logged in to Minisite with member id: " + uid);
		
		//Top-Up current Plan
		driver.webobj.click("css=label.label_radio.r_off");
		driver.webobj.click("id=selectedPrimaryOffer1");
		driver.webobj.click("name=purchase");
		Logger.info("Clicked Top-Up radio button");
		
		//Validate Confirmation
		gf.VerifyPageLoad(10, "Thank you for using NetZero 4G Mobile Broadband","Unable to find MiniSite Confirmation page");
		gf.VerifyPageLoad(10, "The data purchase you made should be available for use within the next 15 minutes.","Unable to find MiniSite Confirmation page");
		Logger.info("Validated Minisite Confirmation page");
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}




	@Test
	public void B_MINISITE_Upgrade_Plus_to_Platinum (){
		
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		//String productName = "Plus";
		
		String filename = brand + "_WIR_Plus_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Load MiniSite page
		driver.runStep("LoadMiniSite_AddMoreData");
		
			driver.webobj.pause ("5000");
		if (!(driver.webobj.isTextPresent("You have reached the data limit"))){
			
			driver.webobj.click ("id=overridelink");
		}
		
		gf.VerifyPageLoadEx(30, "You have reached the data limit on your service plan.", "Unable to find MiniSite Webpage - Add More Data");
		
		//Login to Minisite
		driver.webobj.type("id=memberId", uid);
		driver.webobj.type("id=password", pwd);
		driver.webobj.click ("name=_eventId_success");
		gf.VerifyPageLoadEx(30, "Top-Up your current service plan:", "Unable to login to MiniSite");
		Logger.info("Logged in to MiniSite with the member id: " + uid);
		
		//Upgrade
		//driver.webobj.click("css=label.label_radio.r_on");
		//driver.webobj.getAttribute("id=selectedPrimaryOffer4")
		driver.webobj.click("id=selectedPrimaryOffer4");
		driver.webobj.click ("name=purchase");
		Logger.info("Selected Platinum plan to upgrade");
		
		//Verify Confirmation
		gf.VerifyPageLoadEx(30, "Thank you for using NetZero 4G Mobile Broadband","Unable to find MiniSite Confirmation page");
		gf.VerifyPageLoad(30, "The data purchase you made should be available for use within the next 15 minutes.","Unable to find MiniSite Confirmation page");
		Logger.info("Verified Confirmation page");
		
		//Save member id in the designated file
		String dstnfilename = brand + "_WIR_Platinum_USBModem_CC_Accounts.txt";
		fo.updateFiles(filename, dstnfilename, uid);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}


	

	@Test
	public void B_MINISITE_Update_Payment_Info_WIR_Plus (){
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		//String productName = "Plus";
		
		String filename = brand + "_WIR_Plus_USBModem_CC_Accounts.txt";
		
		String filepath = System.getProperty("user.dir")
		+ "/src/resources/Files/" + filename;
		
		String uid = fo.doReadTextFile(filepath);
		
		//Load Minisite page
		driver.runStep("LoadMiniSite_UpdatePaymentInfo");
		
			driver.webobj.pause ("5000");
		if (!(driver.webobj.isTextPresent("We are having problems processing your payment"))){
			
			driver.webobj.click ("id=overridelink");
		}
		
		gf.VerifyPageLoadEx(10, "We are having problems processing your payment.", "Unable to find MiniSite \"Update Payment Information\" Page");
		
		//Login to Minisite
		driver.webobj.type("id=memberId", uid);
		driver.webobj.type("id=password", pwd);
		driver.webobj.click ("name=_eventId_success");
		gf.VerifyPageLoadEx(10, "Please update your billing information below:", "Unable to login to MiniSite");
		Logger.info("Logged in to Minisite with the member id: " + uid);
		//Update Billing Information
		
		driver.webobj.type("id=fname", "John");
		driver.webobj.type("id=lname", "Smith");
		driver.webobj.type("id=street", "21301 Burbank Blvd");
		driver.webobj.type("id=unit", "100");
		driver.webobj.type("id=city", "Woodland Hills");
		driver.webobj.select("id=billingAddress.state", "label=California");
		driver.webobj.type("id=zip", "91367");
		driver.webobj.type("id=email", "test_user@hotmail.com");
		driver.webobj.type("id=billingAddress.phoneAreaCode", "818");
		driver.webobj.type("id=billingAddress.phonePrefix", "287");
		driver.webobj.type("id=billingAddress.phoneSuffix", "3005");
		driver.webobj.type("id=ccno", MC_CcNum);
		driver.webobj.select("id=ccExpMonth", "label=12");
		driver.webobj.select("id=ccExpYear", "label=2024");
		driver.webobj.type("id=ccCvm", "1235");
			
		driver.webobj.pause("5000");
		driver.webobj.type("id=captchaTypedWord", driver.webobj.getCookieByName("cw"));
		driver.webobj.click("name=purchase");
		Logger.info("Updated Payment information");
		
		//Validate Confirmation Page
		gf.VerifyPageLoad(10, "Thank you for using NetZero 4G Mobile Broadband.", "Unable to find MiniSite Confirmation Page");
		gf.VerifyPageLoad(10, "Your payment information has been updated and your Internet service will be available for use within the next 15 minutes.", "Unable to find MiniSite Confirmation Page");
		Logger.info("Verified Minisite Confirmation page");
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
	}
	

	
	
	
	
	public String GetMemberId(String filename, String filepath) {

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);
		return uid;
	}

	@Test(groups = { "WIRSignup" })
	public void 
	A_WWW_WRLS_Free_MiFi_Signup_RAF_via_Email() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = "Free";
		String deviceName = "MiFi";
		service = "WIR_" + planName + "_" + deviceName; // to be used to save member_id to the designated file
		paytype = "CC"; // to be used to save member_id to the designated file
		

		uid = WebRegFunctions.WIR_Signup_WWW_v1(planName, deviceName, VisaCcNum);
		
		//Refer A Friend via Email:
		//gf.VerifyPageLoad(10, "Order Confirmation", "Unable to find Confirmation Page");
		
		//Verify 'Share via Email' button exists
		gf.VerifyElementLoad(10, "//img[@onclick=\"setMiddle('popDiv', 'overlayBackground');\"]", "Unable to find 'Share via Email' button");
		
		//Click 'Share via Email' button
		SeleniumDriver.webobj.click("//img[@onclick=\"setMiddle('popDiv', 'overlayBackground');\"]");
		
		//Fill out email address and submit
		gf.VerifyElementLoad(10, "id=emailAddresses", "Unable to find 'Share via Email' overlay");
		SeleniumDriver.webobj.type("id=emailAddresses", "testuser@hotmail.com");
		SeleniumDriver.webobj.click("id=inviteImg");
		
		//Verify RAF Confirmation 
		SeleniumDriver.webobj.pause("5000");
		SeleniumDriver.webobj.selectFrame("popDivIframe");
		gf.VerifyPageLoad(10, "Thank you for referring your friend(s) to NetZero!", "Unable to find RAF Confiramation");
		System.out.println ("Refer-A-Friend via Email was successfull");
		
		// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
	
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
	}
	
	
	
	
	
}
