package eci.qa.planes_prueba;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eci.qa.appium.Base;
import eci.qa.appium.Constantes;
import eci.qa.appium.Utilities;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.page_objects.parking.MallsListPage;
import eci.qa.page_objects.parking.MyCarsPage;
import eci.qa.page_objects.parking.ParkingPage;
import eci.qa.page_objects.paymentMethods.PaymentMethodPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsParking extends Base {

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
	
	
	//USUARIO CAMBIA EL ESTADO DE UNA MATRÍCULA
	@Test(dataProvider = "parking")
	public void TC1920731(Map<String, Map<String, String>> dataJSON) throws Exception {
		
		try {
			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ZephyrUtilities.cleanAttachments(1920731);
			
			InitPage init = new InitPage(driver);
			
			HomePage home = new HomePage(driver);
			
			LoginPage login = new LoginPage(driver);
	
			ParkingPage parkingp = new ParkingPage(driver);
			
			MyCarsPage mycarsp = new MyCarsPage(driver);
			
			ServicesPage servicesp = new ServicesPage(driver);
			
			init.clickBtnNoWIFI();
	
			init.clickBtnAcceptCookies();
			
			init.clickBtnAppNoRastreator();
			
			init.clickBtnOnboardingJump();
	
			init.clickBtnPermNotificaciones(); 
			
			init.clickBtnDontAllowNoti();
			
			home.existBtnServicios();
			
			home.clickBtnServicios();
			
			servicesp.clickBtnParking();
			
			login.sendDataInputEmail(dataJSON.get("TC1920731").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1920731").get("Contrasena"));

			login.clickBtnIniciarSesion();
			
			servicesp.clickBtnParking();
			
			parkingp.clickBtnMyCars();
			
			mycarsp.clickNumeroMatricula();
			
			ZephyrUtilities.addAttachment(1920731);
			
			mycarsp.clickVehiculoSwitch();
			
			ZephyrUtilities.addAttachment(1920731);
			
			mycarsp.clickIconBack();

			ZephyrUtilities.addAttachment(1920731);

			ZephyrUtilities.addComentary(1920731, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1920731, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1920731, "2");

			ZephyrUtilities.addComentary(1920731, e.getMessage());

			ZephyrUtilities.addAttachment(1920731);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}
	}

	//FIN USUARIO CAMBIA EL ESTADO DE UNA MATRÍCULA
	
	//USUARIO AÑADE UN VEHÍCULO A PARKING Y LUEGO LO ELIMINA CON MEDIOS DE PAGO GUARDADO
	@Test(dataProvider = "parking")
	public void TC1908942(Map<String, Map<String, String>> dataJSON) throws Exception {
		
		try {
			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ZephyrUtilities.cleanAttachments(1908942);
			
			InitPage init = new InitPage(driver);
			
			HomePage home = new HomePage(driver);
			
			LoginPage login = new LoginPage(driver);
			
			ServicesPage servicep = new ServicesPage(driver);
			
			ParkingPage parkingp = new ParkingPage(driver);
			
			MyCarsPage mycarsp = new MyCarsPage(driver);
			
			init.clickBtnNoWIFI();
			
			init.clickBtnAcceptCookies();
			
			init.clickBtnAppNoRastreator();
			
			init.clickBtnOnboardingJump();
	
			init.clickBtnPermNotificaciones(); 
			
			init.clickBtnDontAllowNoti();
			
			home.existBtnServicios();
			
			home.clickBtnServicios();
			
			servicep.clickBtnParking();
			
			login.sendDataInputEmail(dataJSON.get("TC1908942").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1908942").get("Contrasena"));

			login.clickBtnIniciarSesion();
			
			servicep.clickBtnParking();
			
			parkingp.clickBtnMyCars();
			
			mycarsp.clickBtnAddCar();
			
			mycarsp.enterMatricula(dataJSON.get("TC1908942").get("matricula"));
			
			mycarsp.clickBtnSaveCar();
			
			mycarsp.clickBtnSaveCarConfirm();
			
			ZephyrUtilities.addAttachment(1908942);
			
			mycarsp.clickLicenceDetail();
			
			mycarsp.clickBtnLicenceDelete();
			
			mycarsp.clickBtnLicenceDeleteConfirm();
			
			ZephyrUtilities.addAttachment(1908942);

			ZephyrUtilities.addComentary(1908942, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1908942, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1908942, "2");

			ZephyrUtilities.addComentary(1908942, e.getMessage());

			ZephyrUtilities.addAttachment(1908942);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}
	}
	//FIN USUARIO AÑADE UN VEHÍCULO A PARKING Y LUEGO LO ELIMINA CON MEDIOS DE PAGO GUARDADO

	
	//USUARIO VISUALIZA LA LISTA DE CENTROS CON PARKING
		@Test(dataProvider = "parking")
		public void TC1929917(Map<String, Map<String, String>> dataJSON) throws Exception {
			
			try {
				service = startAppiumServer();

				AppiumDriver<MobileElement> driver = capabilities();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				ZephyrUtilities.cleanAttachments(1920731);
				
				InitPage init = new InitPage(driver);
				
				HomePage home = new HomePage(driver);
				
				LoginPage login = new LoginPage(driver);
	
				ParkingPage parkingp = new ParkingPage(driver);
				
				MyCarsPage mycarsp = new MyCarsPage(driver);
				
				ServicesPage servicesp = new ServicesPage(driver);
				
				MallsListPage mallsp = new MallsListPage(driver);
				
				init.clickBtnNoWIFI();
				
				init.clickBtnAcceptCookies();
				
				init.clickBtnAppNoRastreator();
				
				init.clickBtnOnboardingJump();
		
				init.clickBtnPermNotificaciones(); 
				
				init.clickBtnDontAllowNoti();
				
				home.existBtnServicios();
				
				home.clickBtnServicios();
				
				servicesp.clickBtnParking();
				
				login.sendDataInputEmail(dataJSON.get("TC1929917").get("Usuario"));

				login.sendDataInputContrasena(dataJSON.get("TC1929917").get("Contrasena"));

				login.clickBtnIniciarSesion();
				
				servicesp.clickBtnParking();
				
				parkingp.clickMallsList();
				
				mallsp.clickScrollUp();
				
				mycarsp.clickIconBack();
				
				ZephyrUtilities.addAttachment(1929917);
				
				ZephyrUtilities.addComentary(1929917, Constantes.TESTOK_MSG);

				ZephyrUtilities.updateZephyr(1929917, "1");

			} catch (Exception e) {

				e.printStackTrace();

				ZephyrUtilities.updateZephyr(1929917, "2");

				ZephyrUtilities.addComentary(1929917, e.getMessage());

				ZephyrUtilities.addAttachment(1929917);

				throw new Exception(e);

			} finally {

				driver.closeApp();

				driver.quit();

				service.stop();
			}
		}
		//FIN USUARIO VISUALIZA LA LISTA DE CENTROS CON PARKING
	
	
		//USUARIO VISUALIZA LA AYUDA CONTEXTUAL
	@Test(dataProvider = "parking")
	public void TC1930966(Map<String, Map<String, String>> dataJSON) throws Exception {
		
		try {
			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ZephyrUtilities.cleanAttachments(1930966);
			
			InitPage init = new InitPage(driver);
			
			HomePage home = new HomePage(driver);
			
			LoginPage login = new LoginPage(driver);
			
			ServicesPage servicep = new ServicesPage(driver);
		
			ParkingPage parkingp = new ParkingPage(driver);
			
			init.clickBtnNoWIFI();
	
			init.clickBtnAcceptCookies();
			
			init.clickBtnAppNoRastreator();
			
			init.clickBtnOnboardingJump();
	
			init.clickBtnPermNotificaciones(); 
			
			init.clickBtnDontAllowNoti();
			
			home.existBtnServicios();
			
			home.clickBtnServicios();
			
			servicep.clickBtnParking();
			
			login.sendDataInputEmail(dataJSON.get("TC1930966").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1930966").get("Contrasena"));

			login.clickBtnIniciarSesion();
			
			servicep.clickBtnParking();
			
			parkingp.clickBtnAyudaContextual();
			
			parkingp.swipeLeft();
			
			ZephyrUtilities.addAttachment(1930966);
			
			parkingp.clickBtnAyudaClose();
			
			ZephyrUtilities.addAttachment(1930966);

			ZephyrUtilities.addComentary(1930966, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1930966, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1930966, "2");

			ZephyrUtilities.addComentary(1930966, e.getMessage());

			ZephyrUtilities.addAttachment(1930966);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}
	}	
		//FIN USUARIO VISUALIZA LA AYUDA CONTEXTUAL
	
	// USUARIO ACCEDE A PARKING CON VEHÍCULOS GUARDADOS PERO SIN MEDIOS DE PAGO ASOCIADOS A PARKING
	@Test(dataProvider = "parking")
	public void TC1851610(Map<String, Map<String, String>> dataJSON) throws Exception {
		
		try {
			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ZephyrUtilities.cleanAttachments(1851610);
			
			InitPage init = new InitPage(driver);
			
			HomePage home = new HomePage(driver);
			
			LoginPage login = new LoginPage(driver);
			
			ServicesPage servicep = new ServicesPage(driver);
			
			ParkingPage parkingp = new ParkingPage(driver);
			
//			init.clickBtnNoWIFI(); 
			
			init.clickBtnAcceptCookies();
			
			init.clickBtnAppNoRastreator();
			
			init.clickBtnOnboardingJump();
	
			init.clickBtnPermNotificaciones(); 
			
			init.clickBtnDontAllowNoti();
			
			home.existBtnServicios();
			
			home.clickBtnServicios();
			
			servicep.clickBtnParking();
			
			login.sendDataInputEmail(dataJSON.get("TC1851610").get("Usuario"));

			login.sendDataInputContrasena(dataJSON.get("TC1851610").get("Contrasena"));

			login.clickBtnIniciarSesion();
			
			servicep.clickBtnParking();
			
			ZephyrUtilities.addAttachment(1851610);
			
			parkingp.clickBtnCloseModal();
			
			ZephyrUtilities.addAttachment(1851610);

			ZephyrUtilities.addComentary(1851610, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1851610, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1851610, "2");

			ZephyrUtilities.addComentary(1851610, e.getMessage());

			ZephyrUtilities.addAttachment(1851610);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}
	}
	// FIN USUARIO ACCEDE A PARKING CON VEHÍCULOS GUARDADOS PERO SIN MEDIOS DE PAGO ASOCIADOS A PARKING
		

	@DataProvider(name = "parking")
	public Object[][] getDataProviderParking() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_PARKING));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}
}
