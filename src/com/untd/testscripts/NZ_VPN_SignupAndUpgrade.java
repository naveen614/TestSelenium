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

public class NZ_VPN_SignupAndUpgrade extends TestNgIntegration {

	String brand = "NZ", service = "null", paytype = "null", pwd = "netzero";
	public SeleniumDriver driver = null;
	public ISP_RegistrationFormFunctions WebRegFunctions = null;
	private Properties runConfigProperties = null;
	private Properties envConfigProperties = SystemConfig.envConfigProperties;
	private Properties untdProducts = SystemConfig.untdProducts;
	GeneralFunctions gf;// = new GeneralFunctions();
	FileOperations fo = new FileOperations();
	String VisaCcNum, uid, MC_CcNum, planName, planPrice;


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
		//System.out.println("Env:" + env);

		VisaCcNum = envConfigProperties.getProperty(env + ".VisaWRLSNum");
		MC_CcNum = envConfigProperties.getProperty(env + ".MCWRLSNum");
		
		
		
	
	}

/*	@AfterClass
	public void CloseBrowser (){
		driver.webobj.close();
		driver.webobj.stop();
	}
	*/
	
	
	
	
	


	
	//Store Signups:
	@Test(groups = { "VPNSignup" })
	public void A_Store_VPN_1M_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");

		planName = untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Name");
		planPrice = untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Price");
		
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		

	
		uid = WebRegFunctions.VPN_Signup_Store_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}


	
	@Test(groups = { "VPNSignup" })
	public void A_Store_VPN_3M_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		planName = untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Name");
		planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_Store_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	@Test(groups = { "VPNSignup" })
	public void A_Store_VPN_6M_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		planName = untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Name");
		planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_Store_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}

	
	@Test(groups = { "VPNSignup" })
	public void A_Store_VPN_12M_Signup_v1() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		planName = untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Name");
		planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_Store_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}
	
	@Test(groups = { "VPNSignup" })
	public void A_Store_VPN_Signup_ChangePlanOnOrderSummary() {
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		
		planName = untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Name");
		planPrice = untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Price");
		
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		String origPlanName = untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Name");
		
		
		

	uid = WebRegFunctions.VPN_Signup_Store_ChangePlan(origPlanName, planName,planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		}


	
	//WWW Signups
	@Test(groups = { "VPNSignup" })
	public void A_VPN_Signup_WWW_1M_Signup_v1() {
	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	

	@Test(groups = { "VPNSignup" })
	public void A_VPN_Signup_WWW_3M_Signup_v1() {
	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	


	@Test(groups = { "VPNSignup" })
	public void A_VPN_Signup_WWW_6M_Signup_v1() {
	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	


	@Test(groups = { "VPNSignup" })
	public void A_VPN_Signup_WWW_12M_Signup_v1() {
	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	


	
	@Test(groups = { "VPNSignup" })
	public void A_VPN_Sginup_WWW_1M_Signup_v2() {
	
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_1Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	

	public void A_VPN_Sginup_WWW_3M_Signup_v2() {
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_3Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	

	public void A_VPN_Sginup_WWW_6M_Signup_v2() {
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_6Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	

	public void A_VPN_Sginup_WWW_12M_Signup_v2() {
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
		
		String planName = untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Name");
		String planPrice = SystemConfig.untdProducts.getProperty("NZ_WEB_VPN_12Month_Plan_Price");
		paytype = "CC"; // to be used to save member_id to the designated file
		service = "VPN_" + planName; // to be used to save member_id to the designated file
		
		
		

	uid = WebRegFunctions.VPN_Signup_WWW_v1(planName, planPrice, VisaCcNum);
		
	// Writing the MemberID to the destination text file.
		fo.doWriteTextFile(uid, brand, service, paytype);
		
		WebRegFunctions.RestartDriver("nz_runconfig.properties", "ISPSignupAndUpgrade.csv");
			
	}	

	
	
	
	public String GetMemberId(String filename, String filepath) {

		FileOperations fo = new FileOperations();
		String uid = fo.doReadTextFile(filepath);
		return uid;
	}


	
}
