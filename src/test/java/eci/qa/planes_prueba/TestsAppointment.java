package eci.qa.planes_prueba;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eci.qa.appium.Base;
import eci.qa.appium.Constantes;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.appointment.MainAppointmentPage;
import eci.qa.page_objects.appointment.NewAppointmentPage;
import eci.qa.page_objects.appointment.PastAppointmentPage;
import eci.qa.page_objects.appointment.UpcomingAppointmentPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsAppointment extends Base {

	@BeforeClass
	public static void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
//		System.setProperty("http.proxyHost", "proxycorp.geci");
//		System.setProperty("http.proxyPort", "8080");
//		System.getProperties().put("http.proxyUser", "XY8776BE");
//		System.getProperties().put("http.proxyPassword", "BEJ4RANO");
//		System.setProperty("https.proxyHost", "proxycorp.geci");
//		System.setProperty("https.proxyPort", "8080");
//		System.getProperties().put("https.proxyUser", "XY8776BE");
//		System.getProperties().put("https.proxyPassword", "BEJ4RANO");
		Thread.sleep(3000);
	}

	@AfterClass
	public static void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}

	// Pedir Cita
	@Test(dataProvider = "appointment")
	public void TC1938231(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1938231);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MainAppointmentPage mainAppointment = new MainAppointmentPage(driver);

			NewAppointmentPage newAppointment = new NewAppointmentPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1938231").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1938231").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnServicios();

			servicep.clickBtnAskAppointment();

			mainAppointment.checkPage();

			mainAppointment.clickBtnNewAppointment();

			newAppointment.checkPage();

			newAppointment.clickBtnAddField();

			newAppointment.checkServices();

			newAppointment.selectFirstService();

			newAppointment.clickBtnAddField();

			newAppointment.checkDetailService();

			newAppointment.selectDetailService();

			newAppointment.clickBtnAddField();

			newAppointment.checkLocation();

			newAppointment.selectProvince();

			newAppointment.clickBtnAddField();

			newAppointment.checkDayHour();

			newAppointment.selectDayHour();

			ZephyrUtilities.addAttachment(1938231);

			newAppointment.clickCheckBoxAcceptConditions();

			newAppointment.clickBtnConfirmAppointment();

			ZephyrUtilities.addAttachment(1938231);
			
			newAppointment.checkAppointment();

			mainAppointment.checkAppointmentPending();

			ZephyrUtilities.addAttachment(1938231);

			ZephyrUtilities.addComentary(1938231, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1938231, Constantes.STATUS_OK);

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1938231, Constantes.STATUS_KO);

			ZephyrUtilities.addComentary(1938231, e.getMessage());

			ZephyrUtilities.addAttachment(1938231);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// Modificar Cita
	@Test(dataProvider = "appointment")
	public void TC1938235(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1938235);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MainAppointmentPage mainAppointment = new MainAppointmentPage(driver);

			UpcomingAppointmentPage upcomingAppointment = new UpcomingAppointmentPage(driver);

			NewAppointmentPage newAppointment = new NewAppointmentPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1938235").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1938235").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnServicios();

			servicep.clickBtnAskAppointment();

			mainAppointment.checkPage();
			
			ZephyrUtilities.addAttachment(1938235);

			mainAppointment.clickBtnUpcomingAppointment();

			upcomingAppointment.checkPage();

			upcomingAppointment.clickBtnUpdateAppointment();

			newAppointment.clickBtnEditDay();

			newAppointment.selectDayHour();

			newAppointment.clickCheckBoxAcceptConditions();

			newAppointment.clickBtnConfirmAppointment();
			
			ZephyrUtilities.addAttachment(1938235);

			newAppointment.checkAppointmentModify();

			ZephyrUtilities.addAttachment(1938235);

			ZephyrUtilities.addComentary(1938235, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1938235, Constantes.STATUS_OK);

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1938235, Constantes.STATUS_KO);

			ZephyrUtilities.addComentary(1938235, e.getMessage());

			ZephyrUtilities.addAttachment(1938235);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// Eliminar Cita
	@Test(dataProvider = "appointment")
	public void TC1938238(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1938238);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MainAppointmentPage mainAppointment = new MainAppointmentPage(driver);

			UpcomingAppointmentPage upcomingAppointment = new UpcomingAppointmentPage(driver);

			NewAppointmentPage newAppointment = new NewAppointmentPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1938238").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1938238").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnServicios();

			servicep.clickBtnAskAppointment();

			mainAppointment.checkPage();

			mainAppointment.clickBtnUpcomingAppointment();

			upcomingAppointment.checkPage();
			
			ZephyrUtilities.addAttachment(1938238);

			upcomingAppointment.clickBtnDeleteAppointment();

			newAppointment.clickBtnAcceptDelete();
			
			ZephyrUtilities.addAttachment(1938238);

			newAppointment.checkAppointmentDeleted();

			ZephyrUtilities.addAttachment(1938238);

			ZephyrUtilities.addComentary(1938238, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1938238, Constantes.STATUS_OK);

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1938238, Constantes.STATUS_KO);

			ZephyrUtilities.addComentary(1938238, e.getMessage());

			ZephyrUtilities.addAttachment(1938238);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// Volver a pedir Cita
	@Test(dataProvider = "appointment")
	public void TC1938240(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1938240);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MainAppointmentPage mainAppointment = new MainAppointmentPage(driver);

			PastAppointmentPage pastAppointment = new PastAppointmentPage(driver);

			NewAppointmentPage newAppointment = new NewAppointmentPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1938240").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1938240").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnServicios();

			servicep.clickBtnAskAppointment();

			mainAppointment.checkPage();

			mainAppointment.clickBtnPastAppointment();

			pastAppointment.checkPage();

			pastAppointment.clickBtnAskAppointmentAgain();
			
			ZephyrUtilities.addAttachment(1938240);

			newAppointment.clickBtnAddField();

			newAppointment.selectDayHour();

			newAppointment.clickCheckBoxAcceptConditions();

			newAppointment.clickBtnConfirmAppointment();
			
			ZephyrUtilities.addAttachment(1938240);

			newAppointment.checkAppointment();

			ZephyrUtilities.addAttachment(1938240);

			ZephyrUtilities.addComentary(1938240, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1938240, Constantes.STATUS_OK);

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1938240, Constantes.STATUS_KO);

			ZephyrUtilities.addComentary(1938240, e.getMessage());

			ZephyrUtilities.addAttachment(1938240);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "appointment")
	public Object[][] getDataProviderSearch() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_APPOINTMENT));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}
}
