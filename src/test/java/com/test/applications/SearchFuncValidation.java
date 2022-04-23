package com.test.applications;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.generic.SupplyHousePageObjectModel;
import com.util.BaseConfig;
import com.util.BrowserCheck;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.listener.ListenerTestNG.class)
public class SearchFuncValidation {
	
	WebDriver driver;
	SupplyHousePageObjectModel spm;
	SoftAssert soft;
	
	@BeforeTest
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = BrowserCheck.pickBrowser("chrome");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testFunction() throws Throwable {
		driver.navigate().to(BaseConfig.getConfig("URL"));

		spm = new SupplyHousePageObjectModel(driver);
		soft = new SoftAssert();

		spm.getEnterSearchText().sendKeys(BaseConfig.getConfig("SearchText1"));
		spm.getEnterSearchText().click();
		
		List<WebElement> searchKeyUnbold = spm.getSuggestionTextUnbold();
		soft.assertNotEquals(searchKeyUnbold, "bold");
		//Assert.assertNotEquals(searchKeyUnbold, "bold");
		
//		List<WebElement> fontWeight = spm.getOtherTextSuggestion();
//		soft.assertEquals(fontWeight, "bold");
		//Assert.assertTrue(fontWeight.equals("strong"));
		
		List<WebElement> suggestionDup1 = spm.getListSuggestions();
		List<WebElement> suggestionDup2 = spm.getListSuggestions();
		Assert.assertEquals(suggestionDup1, suggestionDup2);
		
		List<WebElement> suggestion = spm.getListSuggestions();
		soft.assertEquals(suggestion.size()<=5, true);
		//Assert.assertEquals(suggestion.size()<=5, true);
		
		List<WebElement> categories = spm.getListCategories();
		soft.assertEquals(categories.size()<=3, true);
		//Assert.assertEquals(categories.size()<=3, true);
		
		List<WebElement> prodSuggestion = spm.getListProdSuggestion();
		soft.assertEquals(prodSuggestion.size()<=5, true);
		//Assert.assertEquals(prodSuggestion.size()<=5, true);
		
		List<WebElement> imgSearch = spm.getListImgSearch();

		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfAllElements(imgSearch));
		
		soft.assertTrue(spm.getListImgSearch().get(2).isDisplayed());
		

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		soft.assertAll();
	}
	
	
}
