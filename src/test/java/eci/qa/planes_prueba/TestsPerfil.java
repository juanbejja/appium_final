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
import eci.qa.page_objects.profile.AccesoPage;
import eci.qa.page_objects.profile.DatosPersonalesPage;
import eci.qa.page_objects.profile.DireccionesPage;
import eci.qa.page_objects.profile.PerfilPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsPerfil extends Base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		System.setProperty("http.proxyHost", "proxycorp.geci");
		System.setProperty("http.proxyPort", "8080");
		System.getProperties().put("http.proxyUser", "XY8776BE");
		System.getProperties().put("http.proxyPassword", "BEJARAN0");
		System.setProperty("https.proxyHost", "proxycorp.geci");
		System.setProperty("https.proxyPort", "8080");
		System.getProperties().put("https.proxyUser", "XY8776BE");
		System.getProperties().put("https.proxyPassword", "BEJARAN0");
		Thread.sleep(3000);
	}

	@AfterTest
	public void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}

	@Test(dataProvider = "perfil")
	public void TC1807970(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1807970);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnMiCuenta();

			cuenta.clickBtnPerfil();

			login.checkLoginPage();

			AssertJUnit.assertEquals(login.getlblPerfil(), dataJSON.get("TC1807970").get("lblCorrecto"));

			driver.closeApp();

			driver.quit();

			service.stop();

			ZephyrUtilities.addAttachment(1807970);

			ZephyrUtilities.addComentary(1807970, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1807970, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1807970, "2");

			ZephyrUtilities.addComentary(1807970, e.getMessage());

			ZephyrUtilities.addAttachment(1807970);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "perfil")
	public void TC1807973(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1807973);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			PerfilPage perfil = new PerfilPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1807973").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1807973").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			cuenta.checkMyAccountPage();

			cuenta.clickBtnPerfil();

			perfil.checkPerfilPage();

			ZephyrUtilities.addAttachment(1807973);

			ZephyrUtilities.addComentary(1807973, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1807973, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1807973, "2");

			ZephyrUtilities.addComentary(1807973, e.getMessage());

			ZephyrUtilities.addAttachment(1807973);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "perfil")
	public void TC1807977(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1807977);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			PerfilPage perfil = new PerfilPage(driver);

			AccesoPage acceso = new AccesoPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1807977").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1807977").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			cuenta.checkMyAccountPage();

			cuenta.clickBtnPerfil();

			perfil.checkPerfilPage();

			perfil.clickBtnAcceso();

			acceso.checkAccesoPage();

			ZephyrUtilities.addAttachment(1807977);

			ZephyrUtilities.addComentary(1807977, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1807977, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1807977, "2");

			ZephyrUtilities.addComentary(1807977, e.getMessage());

			ZephyrUtilities.addAttachment(1807977);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "perfil")
	public void TC1807978(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1807978);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			PerfilPage perfil = new PerfilPage(driver);

			DatosPersonalesPage datosPersonales = new DatosPersonalesPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1807978").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1807978").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			cuenta.checkMyAccountPage();

			cuenta.clickBtnPerfil();

			perfil.checkPerfilPage();

			perfil.clickBtnDatosPersonales();

			datosPersonales.checkDatosPage();

			ZephyrUtilities.addAttachment(1807978);

			ZephyrUtilities.addComentary(1807978, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1807978, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1807978, "2");

			ZephyrUtilities.addComentary(1807978, e.getMessage());

			ZephyrUtilities.addAttachment(1807978);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "perfil")
	public void TC1807984(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1807984);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			PerfilPage perfil = new PerfilPage(driver);

			DireccionesPage direccion = new DireccionesPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1807984").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1807984").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			cuenta.checkMyAccountPage();

			cuenta.clickBtnPerfil();

			perfil.checkPerfilPage();

			perfil.clickBtnDirecciones();

			direccion.checkSinDireccion();

			ZephyrUtilities.addAttachment(1807984);

			ZephyrUtilities.addComentary(1807984, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1807984, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1807984, "2");

			ZephyrUtilities.addComentary(1807984, e.getMessage());

			ZephyrUtilities.addAttachment(1807984);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "perfil")
	public void TC1808158(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1808158);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			LoginPage login = new LoginPage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			MyAccountPage cuenta = new MyAccountPage(driver);

			PerfilPage perfil = new PerfilPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1808158").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1808158").get("Contrasena"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			cuenta.checkMyAccountPage();

			cuenta.clickBtnPerfil();

			perfil.checkPerfilPage();

			perfil.clickBtnInformation();

			perfil.checkModalInformation();

			ZephyrUtilities.addAttachment(1808158);

			ZephyrUtilities.addComentary(1808158, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1808158, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1808158, "2");

			ZephyrUtilities.addComentary(1808158, e.getMessage());

			ZephyrUtilities.addAttachment(1808158);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "perfil")
	public Object[][] getDataProviderPerfil() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_PERFIL));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}
}
