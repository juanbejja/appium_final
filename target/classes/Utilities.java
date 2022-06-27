package eci.qa.appium;

import java.awt.AWTException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Rectangle;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {

	private Utilities() {
	}

	public static void scrollToElement(String elementId) {
		Base.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + elementId + ".*\"))"));
	}

	public static void clickByCoordinates(int x, int y) {
		TouchAction touchAction = new TouchAction(Base.getDriver());
		touchAction.tap(PointOption.point(x, y)).perform();
	}

	public static void mobileSwipeElementIOS(MobileElement el) {

		final int ANIMATION_TIME = 200;
		final HashMap<String, String> scrollObject = new HashMap<String, String>();

		scrollObject.put("direction", "left");

		scrollObject.put("element", el.getId());
		try {
			Base.getDriver().executeScript("mobile:swipe", scrollObject);
			Thread.sleep(ANIMATION_TIME);
		} catch (Exception e) {
			return;
		}
	}

	public static void scrollBottomAndroid() {
		try {
			Base.getDriver().findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
		} catch (InvalidSelectorException e) {
			// ignore
		}
	}

	public static void swipeElementAndroid(MobileElement el) throws Exception {
		final int ANIMATION_TIME = 200; // ms
		final int PRESS_TIME = 200; // ms
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		Rectangle rect = el.getRect();

		edgeBorder = 0;

		pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
		pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);

		try {
			new TouchAction(Base.getDriver()).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			throw new Exception(e);
		}
	}

	public static void swipeInElementIOS(MobileElement el, Direction dir) {
		final int ANIMATION_TIME = 200;
		final HashMap<String, String> scrollObject = new HashMap<String, String>();

		switch (dir) {

		case DOWN: // De abajo hacia arriba

			scrollObject.put("direction", "down");

			break;

		case UP: // De arriba hacia abajo

			scrollObject.put("direction", "up");

			break;

		case LEFT: // De izquierda a derecha

			scrollObject.put("direction", "left");

			break;

		case RIGHT:// De derecha a izquierda

			scrollObject.put("direction", "right");

			break;

		default:

			throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + dir + "' NOT supported");

		}

		scrollObject.put("element", el.getId());
		try {

			Base.getDriver().executeScript("mobile:swipe", scrollObject);

			Thread.sleep(ANIMATION_TIME);

		} catch (Exception e) {

			return;
		}
	}

	public static void clickSearchKeyboard() throws AWTException {
		if (Base.getProperty("SO").equals("iOS")) {
			Base.getDriver().findElement(By.xpath("//*[contains(@label,\"buscar\")]")).click();
		} else {

			((AndroidDriver<MobileElement>) Base.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

		}

	}

	public static void clickNextKeyboard() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		if (Base.getProperty("SO").equals("iOS")) {
			Base.getDriver().findElement(By.xpath("//*[contains(@label,\"siguiente\")]")).click();
		} else {
			((AndroidDriver<MobileElement>) Base.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

		}

	}

	public static void clickAcceptKeyboard() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		if (Base.getProperty("SO").equals("iOS")) {
			Base.getDriver().findElement(By.xpath("//*[contains(@label,\"aceptar\")]")).click();
		} else {
			// Revisat
			((AndroidDriver<MobileElement>) Base.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

		}

	}

	public static void clickCancelKeyboard() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		if (Base.getProperty("SO").equals("iOS")) {
			Base.getDriver().findElement(By.xpath("//*[contains(@label,\"Cancelar\")]")).click();
		} else {
			((AndroidDriver<MobileElement>) Base.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

		}

	}

	public static void getWebViews() {

		Set<String> contextNames = Base.getDriver().getContextHandles();

		for (String context : contextNames) {
			System.out.println(context);
		}

	}

	public static void changeContext(String context) throws Exception {
		try {

			Base.getDriver().context(context); // set context to WEBVIEW_1

		} catch (Exception e) {
			throw new Exception("El Webview: " + context + " no existe");
		}
	}

	public enum Direction {

		UP, DOWN, LEFT, RIGHT;

	}

	public static void swipeScreenAndroid(Direction dir) {
		System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

		// Animation default time:
		// - Android: 300 ms
		// - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		org.openqa.selenium.Dimension dims = Base.getDriver().manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(Base.getDriver()).press(pointOptionStart)
					// a bit more reliable when we add small wait
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
