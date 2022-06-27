package eci.qa.appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {

	public static AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;
	private static Properties defaultProps = new Properties();

	public AppiumDriverLocalService startAppiumServer() {

		boolean flag = checkIfServerIsRunning(4723);

		if (!flag) {

			AppiumServiceBuilder builder;
			builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(4723);
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.RELAXED_SECURITY);
			service = AppiumDriverLocalService.buildService(builder);
			service.start();

		}
		return service;

	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		}
		return isServerRunning;
	}

	public static AppiumDriver<MobileElement> capabilities() throws Exception {

		addGlobalProperties();

		switch (getProperty("SO")) {

		case "ANDROID":

			driver = new AndroidDriver<>(new URL(Constantes.URL_APPIUM_SERVER), setCapabilitysAndroid());

			return driver;

		case "iOS":

			driver = new IOSDriver<>(new URL(Constantes.URL_APPIUM_SERVER), setCapabilitysiOS());

			return driver;

		default:
			throw new Exception("Error al levantar driver, SO inexistente");

		}
	}

	public static String getProperty(String key) {
		return defaultProps.getProperty(key);
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	private static DesiredCapabilities setCapabilitysiOS() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (getProperty("AMBIENTE").equals("PRE")) {

			capabilities.setCapability(MobileCapabilityType.APP, Constantes.APPDIR_PRE + ".app");

		} else if (getProperty("AMBIENTE").equals("PRO")) {

			capabilities.setCapability(MobileCapabilityType.APP, Constantes.APPDIR_PRO + ".app");

		} else {
			throw new Exception("El ambiente " + getProperty("AMBIENTE") + " No Existe");
		}

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty("IOS_DEVICE"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

//		capabilities.setCapability("useNewWDA", true);
//		capabilities.setCapability("usePrebuiltWDA", true);
//		capabilities.setCapability("avdArgs", "-http-proxy http://XY8776BE:BEJARAN0@proxycorp.geci:8080");
		return capabilities;

	}

	private static DesiredCapabilities setCapabilitysAndroid() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (getProperty("AMBIENTE").equals("PRE")) {

			capabilities.setCapability(MobileCapabilityType.APP, Constantes.APPDIR_PRE + ".apk");

		} else if (getProperty("AMBIENTE").equals("PRO")) {

			capabilities.setCapability(MobileCapabilityType.APP, Constantes.APPDIR_PRO + ".apk");

		} else {
			throw new Exception("El ambiente " + getProperty("AMBIENTE") + " No Existe");
		}

		capabilities.setCapability("avd", "EmuladorECI");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Base.getProperty("ANDROID_DEVICE_NAME"));
		capabilities.setCapability("avd", Base.getProperty("ANDROID_DEVICE_NAME"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability("avdLaunchTimeout",400000);
		capabilities.setCapability("avdReadyTimeout",400000);
//		capabilities.setCapability("chromedriverExecutable", "/Users/juan.pablo.bejarano/Desktop/chromedriver");
//		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//		capabilities.setCapability("avdArgs", "-http-proxy http://XY8776BE:BEJ4RAN0@proxycorp.geci:8080");
		return capabilities;

	}

	private static void addGlobalProperties() throws Exception {
		FileInputStream in = new FileInputStream(Constantes.GLOBAL_PROPERTIES);

		try {
			defaultProps.load(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al cargar global properties");
		} finally {
			in.close();
		}
	}

	public static File getScreenshot() throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return scrfile;
	}

}
