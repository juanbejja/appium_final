package eci.qa.page_objects.search;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ItemPage {

	@AndroidFindBy(xpath = "//div[@data-synth=\"LOCATOR_GUIA_TALLAS\"]")
	@iOSXCUITFindBy(xpath = "//*[@value='ELIGE TALLA']")
	private MobileElement btnSelectSize;

	@AndroidFindBy(xpath = "//button[@id=\"js_add_to_cart_mobile\"]")
	@iOSXCUITFindBy(xpath = "//*[@label='Añadir a la cesta']")
	private MobileElement btnAddCart;

	@iOSXCUITFindBy(xpath = "//*[@label='COMPRAR EN UN CLIC']")
	private MobileElement btnBuyOneClick;

	@AndroidFindBy(xpath = "//li[@class=\"clickTail\"][@link_index=\"2\"]")
	@iOSXCUITFindBy(xpath = "//*[@value='S']")
	private MobileElement optSizeSmall;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//XCUIElementTypeButton[3]")
	@AndroidFindBy(id = "com.elcorteingles.app:id/toolbar_shopping_cart_text")
	private MobileElement iconCartItems;

	public ItemPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void checkItemPage() {
		if (Base.getProperty("SO").equals("iOS")) {
			btnAddCart.isDisplayed();
			btnBuyOneClick.isDisplayed();
			btnSelectSize.isDisplayed();
		} else {
			Base.getDriver().findElement(By.xpath("//div[@data-synth=\"LOCATOR_GUIA_TALLAS\"]")).isDisplayed();
		}
	}

	public void selectSize() throws Exception {
		if (Base.getProperty("SO").equals("iOS")) {
			btnSelectSize.click();
			if (Base.getProperty("AMBIENTE").equals("PRO")) {
				optSizeSmall.click();
			} else if (Base.getProperty("AMBIENTE").equals("PRE")) {
				Base.getDriver().findElement(By.xpath("//*[@value='7-8 AÑOS (128 CM)']")).click();
			}
			iconCartItems.isDisplayed();
		} else {
			Base.getDriver().findElement(By.xpath("//div[@data-synth=\"LOCATOR_GUIA_TALLAS\"]")).click();
			Base.getDriver().findElement(By.xpath("//li[@class=\"clickTail\"][@link_index=\"2\"]")).click();
			Utilities.changeContext("NATIVE_APP");
			iconCartItems.isDisplayed();
		}
		Thread.sleep(2000);
	}

	public void validateItemAdded() throws Exception {
		int numItemsBefore = 0;

		System.out.println("sixe: " + iconCartItems.getText());

		switch (Base.getProperty("SO")) {

		case "iOS":
			if (!iconCartItems.getText().contains("vacía")) {
				numItemsBefore = Integer.parseInt(iconCartItems.getText().replaceAll("[\\D]", ""));
			}

			btnAddCart.click();
			break;

		case "ANDROID":
			if (!iconCartItems.getText().isEmpty()) {
				numItemsBefore = Integer.parseInt(iconCartItems.getText().replaceAll("[\\D]", ""));
			}
			Utilities.changeContext("WEBVIEW_com.elcorteingles.app");
			Base.getDriver().findElement(By.xpath("//button[@id=\"js_add_to_cart_mobile\"]")).click();
			Thread.sleep(4000);
			Utilities.changeContext("NATIVE_APP");
			break;

		}

//		if (Base.getProperty("SO").equals("iOS")) {
//
//			if (iconCartItems.getText().contains("vacía")) {
//				numItemsBefore = 0;
//			} else {
//				numItemsBefore = Integer.parseInt(iconCartItems.getText().replaceAll("[\\D]", ""));
//			}
//
//			btnAddCart.click();

//		} else if (Base.getProperty("SO").equals("ANDROID")) {
//
//			if (iconCartItems.getText().isEmpty()) {
//				numItemsBefore = 0;
//			} else {
//				numItemsBefore = Integer.parseInt(iconCartItems.getText().replaceAll("[\\D]", ""));
//			}
//			Utilities.changeContext("WEBVIEW_com.elcorteingles.app");
//			Base.getDriver().findElement(By.xpath("//button[@id=\"js_add_to_cart_mobile\"]")).click();
//			Thread.sleep(4000);
//			Utilities.changeContext("NATIVE_APP");
//		}

		int numItemsAfter = Integer.parseInt(iconCartItems.getText().replaceAll("[\\D]", ""));

		if (numItemsAfter != numItemsBefore + 1) {
			throw new Exception("Error al Anadir Item a la Cesta");
		}
	}

}
