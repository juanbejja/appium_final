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
import eci.qa.appium.Utilities;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.page_objects.search.BuyPage;
import eci.qa.page_objects.search.ItemPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsCart extends Base {

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

	@Test(dataProvider = "cart")
	public void TC1836349(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1836349);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			ItemPage item = new ItemPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1836349").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1836349").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1836349").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(7000);

			buy.checkMultipleItems();

			buy.clickItem();

			item.checkItemPage();

			item.selectSize();
			
			item.validateItemAdded();

			ZephyrUtilities.addAttachment(1836349);

			ZephyrUtilities.addComentary(1836349, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1836349, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1836349, "2");

			ZephyrUtilities.addComentary(1836349, e.getMessage());

			ZephyrUtilities.addAttachment(1836349);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "cart")
	public Object[][] getDataProviderSearch() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_CART));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}

}
