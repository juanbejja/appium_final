package eci.qa.planes_prueba;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eci.qa.appium.Base;
import eci.qa.appium.Constantes;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.MyAccountPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.page_objects.login.RecoveryPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsLogin extends Base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(3000);
	}

	@AfterTest
	public void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}

	@Test(dataProvider = "login")
	public void TC1799970(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1799970);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1799970").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1799970").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			ZephyrUtilities.addAttachment(1799970);

			ZephyrUtilities.addComentary(1799970, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1799970, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1799970, "2");

			ZephyrUtilities.addComentary(1799970, e.getMessage());

			ZephyrUtilities.addAttachment(1799970);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1801504(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1801504);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1801504").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1801504").get("Contrasena"));

			login.clickBtnIniciarSesion();

			AssertJUnit.assertEquals(login.getTextLoginFail(), dataJSON.get("TC1801504").get("Mensaje"));

			ZephyrUtilities.addAttachment(1801504);

			ZephyrUtilities.addComentary(1801504, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1801504, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1801504, "2");

			ZephyrUtilities.addComentary(1801504, e.getMessage());

			ZephyrUtilities.addAttachment(1801504);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1801563(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1801563);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			RecoveryPage recovery = new RecoveryPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.clickBtnRecuperarContrasena();

			recovery.checkRecoveryPage();

			recovery.enterEmail(dataJSON.get("TC1801563").get("Email"));

			recovery.clickBtnSendEmail();

			recovery.checkPageEmailSent();

			AssertJUnit.assertEquals(recovery.getTextEmailSent().contains(dataJSON.get("TC1801563").get("Mensaje")),
					true);

			ZephyrUtilities.addAttachment(1801563);

			ZephyrUtilities.addComentary(1801563, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1801563, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1801563, "2");

			ZephyrUtilities.addComentary(1801563, e.getMessage());

			ZephyrUtilities.addAttachment(1801563);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1801551(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1801551);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage myAccount = new MyAccountPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1801551").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1801551").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.clickBtnMiCuenta();

			myAccount.clickBtnCloseSession();

			myAccount.checkMyAccountPage();

			myAccount.checkPopCloseSession();

			myAccount.clickBtnAcceptClose();

			login.checkLoginPage();

			ZephyrUtilities.addAttachment(1801551);

			ZephyrUtilities.addComentary(1801551, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1801551, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1801551, "2");

			ZephyrUtilities.addComentary(1801551, e.getMessage());

			ZephyrUtilities.addAttachment(1801551);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1801514(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1801514);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			RecoveryPage recovery = new RecoveryPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.clickBtnRecuperarContrasena();

			recovery.checkRecoveryPage();

			recovery.enterEmail(dataJSON.get("TC1801514").get("Email"));

			recovery.clickBtnSendEmail();

			AssertJUnit.assertEquals(
					recovery.getEmailUnrecognizedMsg().contains(dataJSON.get("TC1801514").get("Mensaje")), true);

			ZephyrUtilities.addAttachment(1801514);

			ZephyrUtilities.addComentary(1801514, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1801514, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1801514, "2");

			ZephyrUtilities.addComentary(1801514, e.getMessage());

			ZephyrUtilities.addAttachment(1801514);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1801384(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1801384);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnLogin();

			login.sendDataInputEmail(dataJSON.get("TC1801384").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1801384").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			ZephyrUtilities.addAttachment(1801384);

			ZephyrUtilities.addComentary(1801384, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1801384, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1801384, "2");

			ZephyrUtilities.addComentary(1801384, e.getMessage());

			ZephyrUtilities.addAttachment(1801384);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "login")
	public void TC1802108(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1802108);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			RecoveryPage recovery = new RecoveryPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.clickBtnRecuperarContrasena();

			recovery.checkRecoveryPage();

			recovery.enterEmail(dataJSON.get("TC1802108").get("Email"));

			recovery.clickBtnSendEmail();

			recovery.checkFormatFail();

			ZephyrUtilities.addAttachment(1802108);

			ZephyrUtilities.addComentary(1802108, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1802108, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1802108, "2");

			ZephyrUtilities.addComentary(1802108, e.getMessage());

			ZephyrUtilities.addAttachment(1802108);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "login")
	public Object[][] getDataProviderLogin() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_LOGIN));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}

}
