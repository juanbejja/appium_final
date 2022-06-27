package eci.qa.appium;

import java.time.LocalDateTime;

public class Constantes {

	private Constantes() {
	}

	public static final String GLOBAL_PROPERTIES = System.getProperty("user.dir")
			+ "/src/main/java/eci/qa/appium/global.properties";

	public static final String APPDIR_PRE = "/Users/" + System.getProperty("user.name") + "/Desktop/elcorteinglesPRE";

	public static final String APPDIR_PRO = "/Users/" + System.getProperty("user.name") + "/Desktop/elcorteinglesPRO";

	public static final String EXECUTIONS = "executions";

	public static final String CONTENT_TYPE = "application/json";

	public static final String AUTHORIZATION = "Basic WFk4Nzc2QkU6QkVKNFJBTk8=";

	public static final String JSON_LOGIN = "src/main/resources/login.json";

	public static final String JSON_PERFIL = "src/main/resources/perfil.json";

	public static final String JSON_SEARCH = "src/main/resources/search.json";
	
	public static final String JSON_CART = "src/main/resources/cart.json";
	
	public static final String JSON_APPOINTMENT = "src/main/resources/appointment.json";
	
	public static final String JSON_PAYMENT_METHODS = "src/main/resources/payment_methods.json";
	
	public static final String TESTOK_MSG = "TEST EJECUTADO CORRECTAMENTE, FECHA EJECUCION: " + LocalDateTime.now();
	
	public static final String STATUS_OK = "1";
	
	public static final String STATUS_KO = "2";

	public static final String URL_APPIUM_SERVER = "http://127.0.0.1:4723/wd/hub";

	public static final String JSON_PARKING = "src/main/resources/parking.json";

}
