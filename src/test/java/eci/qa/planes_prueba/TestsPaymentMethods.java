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
import eci.qa.page_objects.DigitalWalletPage;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.MyAccountPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.page_objects.paymentMethods.CardInfoPage;
import eci.qa.page_objects.paymentMethods.DetailCardPage;
import eci.qa.page_objects.paymentMethods.PaymentMethodPage;
import eci.qa.page_objects.paymentMethods.RedsysPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsPaymentMethods extends Base {

	@BeforeClass
	public static void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(3000);
	}

	@AfterClass
	public static void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}
	
	
	// AGREGAR TARJETA ECI Y ELIMINAR
	@Test(dataProvider = "payment_methods")
	public void TC1802069(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1802069);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();
			
			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1802069").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1802069").get("password"));
			
			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickBtnAddMethod();

			paymentMethod.clickBtnCardECI();

			paymentMethod.enterCardECINumber(dataJSON.get("TC1802069").get("cardNumber"));

			paymentMethod.enterCardECIAlias(dataJSON.get("TC1802069").get("aliasName"));
			
			Utilities.clickNextKeyboard();

			paymentMethod.clickBtnSaveCard();

			// WEBVIEW

			paymentMethod.enterCardDNI(dataJSON.get("TC1802069").get("NIF"));
			
			paymentMethod.enterPostalCode(dataJSON.get("TC1802069").get("postalCode"));

			ZephyrUtilities.addAttachment(1802069);

			paymentMethod.clickBtnAcceptCardData();

			paymentMethod.checkModalCardAssMPShop();

			paymentMethod.clickBtnBetterAnotherTime();

			paymentMethod.checkPMethodCardAdded();

			ZephyrUtilities.addAttachment(1802069);

			paymentMethod.clickCardAdded();

			paymentMethod.clickBtnRemoveCard();

			paymentMethod.clickBtnAcceptRemoveCard();

			paymentMethod.checkPMPage();

			ZephyrUtilities.addAttachment(1802069);

			ZephyrUtilities.addComentary(1802069, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1802069, Constantes.STATUS_OK);

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1802069, "2");

			ZephyrUtilities.addComentary(1802069, e.getMessage());

			ZephyrUtilities.addAttachment(1802069);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// AGREGAR TARJETA BANCARIA
	@Test(dataProvider = "payment_methods")
	public void TC1852022(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1852022);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			RedsysPage redsys = new RedsysPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1852022").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1852022").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickBtnAddMethod();

			paymentMethod.clickBtnCardBank();

//			redsys.checkPage();

			redsys.enterCardBankMonth(dataJSON.get("TC1852022").get("expireMonth"));

			redsys.enterCardBankYear(dataJSON.get("TC1852022").get("expireYear"));
			
			redsys.enterCardBankNumber(dataJSON.get("TC1852022").get("cardNumber"));

			redsys.enterCardBankCod(dataJSON.get("TC1852022").get("cardCod"));

			ZephyrUtilities.addAttachment(1852022);

			redsys.clickBtnAcceptRedsys();
			
			Thread.sleep(3000);

			redsys.enterInputCIP(dataJSON.get("TC1852022").get("CIP"));

			redsys.clickBtnAcceptCIP();

			paymentMethod.enterInputCardBankAlias(dataJSON.get("TC1852022").get("aliasName"));

			ZephyrUtilities.addAttachment(1852022);
			
			Utilities.clickNextKeyboard();

			paymentMethod.clickBtnSaveCard();

			paymentMethod.checkBankCardAdded();

			ZephyrUtilities.addAttachment(1852022);

			ZephyrUtilities.addComentary(1852022, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1852022, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1852022, "2");

			ZephyrUtilities.addComentary(1852022, e.getMessage());

			ZephyrUtilities.addAttachment(1852022);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// AGREGAR TARJETA REGALO
	@Test(dataProvider = "payment_methods")
	public void TC1852170(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1852170);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1852170").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1852170").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickBtnAddMethod();

			paymentMethod.clickBtnCardGift();

			paymentMethod.enterInputCardGiftNumber(dataJSON.get("TC1852170").get("cardNumber"));

			paymentMethod.enterInputCardGiftPIN(dataJSON.get("TC1852170").get("PIN"));

			paymentMethod.enterInputCardGiftAlias(dataJSON.get("TC1852170").get("aliasName"));
			
			Utilities.clickAcceptKeyboard();

			ZephyrUtilities.addAttachment(1852170);

			paymentMethod.clickBtnContinueGiftCard();

			paymentMethod.checkGCData();

			ZephyrUtilities.addAttachment(1852170);

			paymentMethod.clickBtnConfirmGiftCard();

			paymentMethod.checkGiftCardAdded();

			ZephyrUtilities.addAttachment(1852170);

			ZephyrUtilities.addComentary(1852170, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1852170, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1852170, "2");

			ZephyrUtilities.addComentary(1852170, e.getMessage());

			ZephyrUtilities.addAttachment(1852170);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// MODIFICAR ALIAS DE TARJETA AGREGADA
	@Test(dataProvider = "payment_methods")
	public void TC1852156(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1852156);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1852156").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1852156").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardECI();

			detailCard.editInputAliasCardECI(dataJSON.get("TC1852156").get("aliasModified"));
			
			Utilities.clickNextKeyboard();

			detailCard.clickBtnSaveCardDetail();

			paymentMethod.checkAliasModified();

			ZephyrUtilities.addAttachment(1852156);

			paymentMethod.clickDetailCardECI();

			detailCard.editInputAliasCardECI(dataJSON.get("TC1852156").get("aliasFirst"));
			
			Utilities.clickNextKeyboard();

			detailCard.clickBtnSaveCardDetail();

			ZephyrUtilities.addComentary(1852156, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1852156, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1852156, "2");

			ZephyrUtilities.addComentary(1852156, e.getMessage());

			ZephyrUtilities.addAttachment(1852156);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// ERROR TARJETA REGALO NO EXISTENTE
	@Test(dataProvider = "payment_methods")
	public void TC1852305(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1852305);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1852305").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1852305").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickBtnAddMethod();

			paymentMethod.clickBtnCardGift();

			paymentMethod.enterInputCardGiftNumber(dataJSON.get("TC1852305").get("cardNumber"));

			paymentMethod.enterInputCardGiftPIN(dataJSON.get("TC1852305").get("PIN"));

			paymentMethod.enterInputCardGiftAlias(dataJSON.get("TC1852305").get("aliasName"));
			
			Utilities.clickAcceptKeyboard();

			ZephyrUtilities.addAttachment(1852305);

			paymentMethod.checkErrorCGnotExist();

			ZephyrUtilities.addAttachment(1852305);

			ZephyrUtilities.addComentary(1852305, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1852305, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1852305, "2");

			ZephyrUtilities.addComentary(1852305, e.getMessage());

			ZephyrUtilities.addAttachment(1852305);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A DETALLE TARJETA REGALO
	@Test(dataProvider = "payment_methods")
	public void TC1852309(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1852309);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			CardInfoPage infoGC = new CardInfoPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1852309").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1852309").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardGift();

			detailCard.clickBtnCardInfo();
			
			infoGC.clickBtnInfo();

			infoGC.checkCardGiftInfo();

			ZephyrUtilities.addAttachment(1852309);

			infoGC.clickBtnCloseInfoPop();

			ZephyrUtilities.addAttachment(1852309);

			ZephyrUtilities.addComentary(1852309, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1852309, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1852309, "2");

			ZephyrUtilities.addComentary(1852309, e.getMessage());

			ZephyrUtilities.addAttachment(1852309);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A MOVIMIENTOS TARJETA REGALO
	@Test(dataProvider = "payment_methods")
	public void TC1853359(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1853359);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1853359").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1853359").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardGift();

			detailCard.clickBtnCardMovements();

			detailCard.checkMovements();

			ZephyrUtilities.addAttachment(1853359);

			detailCard.clickMovement();

			detailCard.checkInfoMovement();

			ZephyrUtilities.addAttachment(1853359);

			ZephyrUtilities.addComentary(1853359, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1853359, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1853359, "2");

			ZephyrUtilities.addComentary(1853359, e.getMessage());

			ZephyrUtilities.addAttachment(1853359);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A MOVIMIENTOS TARJETA REGALO (Sin movimientos)
	@Test(dataProvider = "payment_methods")
	public void TC1853358(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1853358);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1853358").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1853358").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCGWithoutMovements();

			detailCard.clickBtnCardMovements();

			detailCard.checkLblNotMovements();

			ZephyrUtilities.addAttachment(1853358);

			ZephyrUtilities.addComentary(1853358, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1853358, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1853358, "2");

			ZephyrUtilities.addComentary(1853358, e.getMessage());

			ZephyrUtilities.addAttachment(1853358);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// ERROR RECARGA TARJETA REGALO
	@Test(dataProvider = "payment_methods")
	public void TC1853500(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1853500);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1853500").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1853500").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardGift();

			detailCard.clickBtnGiftCardRecharge();

			detailCard.enterInputRechargeNumberCard(dataJSON.get("TC1853500").get("cardNumber"));

			detailCard.enterInputRechargePINCard(dataJSON.get("TC1853500").get("PIN"));
			
			Utilities.clickAcceptKeyboard();

			detailCard.clickBtnContinueRecharge();

			detailCard.checkLblErrorRechargeGC();

			ZephyrUtilities.addAttachment(1853500);

			ZephyrUtilities.addComentary(1853500, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1853500, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1853500, "2");

			ZephyrUtilities.addComentary(1853500, e.getMessage());

			ZephyrUtilities.addAttachment(1853500);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// TRANSPASO A TARJETA REGALO (Multiples tarjetas)
	@Test(dataProvider = "payment_methods")
	public void TC1853631(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1853631);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1853631").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1853631").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardGift();

			detailCard.clickBtnGiftCardTransfer();

			detailCard.checkMultipleCardsToTransfer();

			ZephyrUtilities.addAttachment(1853631);

			detailCard.clickBtnMultipleCard();

			detailCard.checkPageOrigenDestinationTrans();

			ZephyrUtilities.addAttachment(1853631);

			ZephyrUtilities.addComentary(1853631, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1853631, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1853631, "2");

			ZephyrUtilities.addComentary(1853631, e.getMessage());

			ZephyrUtilities.addAttachment(1853631);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// TRANSPASO A TARJETA REGALO (1 sola)
	@Test(dataProvider = "payment_methods")
	public void TC1853597(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1853597);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1853597").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1853597").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardGift();

			detailCard.clickBtnGiftCardTransfer();

			detailCard.checkPageOrigenDestinationTrans();

			ZephyrUtilities.addAttachment(1853597);

			ZephyrUtilities.addComentary(1853597, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1853597, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1853597, "2");

			ZephyrUtilities.addComentary(1853597, e.getMessage());

			ZephyrUtilities.addAttachment(1853597);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A MOVIMIENTOS TARJETA ABONO (Con movimientos)
	@Test(dataProvider = "payment_methods")
	public void TC1855779(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1855779);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1855779").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1855779").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardAbono();

			detailCard.clickBtnCardMovements();

			detailCard.checkMovements();

			ZephyrUtilities.addAttachment(1855779);

			detailCard.clickMovement();

			detailCard.checkInfoMovement();

			ZephyrUtilities.addAttachment(1855779);

			ZephyrUtilities.addComentary(1855779, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1855779, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1855779, "2");

			ZephyrUtilities.addComentary(1855779, e.getMessage());

			ZephyrUtilities.addAttachment(1855779);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A MOVIMIENTOS TARJETA ABONO (Sin movimientos)
	@Test(dataProvider = "payment_methods")
	public void TC1855770(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1855770);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1855770").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1855770").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCAWithoutMovements();

			detailCard.clickBtnCardMovements();

			detailCard.checkLblNotMovements();

			ZephyrUtilities.addAttachment(1855770);

			ZephyrUtilities.addComentary(1855770, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1855770, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1855770, "2");

			ZephyrUtilities.addComentary(1855770, e.getMessage());

			ZephyrUtilities.addAttachment(1855770);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// INGRESAR A DETALLE TARJETA ABONO
	@Test(dataProvider = "payment_methods")
	public void TC1855781(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1855781);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			CardInfoPage infoGC = new CardInfoPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1855781").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1855781").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardAbono();

			detailCard.clickBtnCardInfo();

			infoGC.checkCardAbonoInfo();

			infoGC.clickBtnInfo();

			ZephyrUtilities.addAttachment(1855781);

			infoGC.clickBtnCloseInfoPop();

			ZephyrUtilities.addAttachment(1855781);

			ZephyrUtilities.addComentary(1855781, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1855781, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1855781, "2");

			ZephyrUtilities.addComentary(1855781, e.getMessage());

			ZephyrUtilities.addAttachment(1855781);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// RECARGA TARJETA ABONO
	@Test(dataProvider = "payment_methods")
	public void TC1856011(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1856011);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1856011").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1856011").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardAbono();

			detailCard.clickBtnAbonoCardRechargeReturn();

			detailCard.checkCodQRCardAbono();

			ZephyrUtilities.addAttachment(1856011);

			ZephyrUtilities.addComentary(1856011, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1856011, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1856011, "2");

			ZephyrUtilities.addComentary(1856011, e.getMessage());

			ZephyrUtilities.addAttachment(1856011);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	// ERROR RECARGA TARJETA ABONO
	@Test(dataProvider = "payment_methods")
	public void TC1856013(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1856013);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			MyAccountPage account = new MyAccountPage(driver);

			DigitalWalletPage wallet = new DigitalWalletPage(driver);

			PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);

			DetailCardPage detailCard = new DetailCardPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1856013").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1856013").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnMiCuenta();

			account.clickBtnCarteraDigital();

			wallet.clickBtnMediosPago();

			paymentMethod.checkPMPage();

			paymentMethod.clickDetailCardAbono();

			detailCard.clickBtnAbonoCardRecharge();

			detailCard.enterInputRechargePINCard(dataJSON.get("TC1856013").get("cardNumber"));

			detailCard.enterInputRechargeNumberCard(dataJSON.get("TC1856013").get("PIN"));
			
			Utilities.clickCancelKeyboard();

			ZephyrUtilities.addAttachment(1856013);

			detailCard.clickBtnContinueRecharge();

			detailCard.checkErrorCardNotExist();

			ZephyrUtilities.addAttachment(1856013);

			ZephyrUtilities.addComentary(1856013, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1856013, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1856013, "2");

			ZephyrUtilities.addComentary(1856013, e.getMessage());

			ZephyrUtilities.addAttachment(1856013);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "payment_methods")
	public Object[][] getDataProviderSearch() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_PAYMENT_METHODS));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}

}
