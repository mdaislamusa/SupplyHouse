package com.generic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplyHousePageObjectModel {
	
	public SupplyHousePageObjectModel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@type='search']")
	private WebElement EnterSearchText;

	@FindBy(xpath="(//*[@type='submit'])[1]")
	private WebElement SearchSubmit;

	@FindBy(xpath="//*[@type='submit']")
	private List<WebElement> ListSearchSubmit ;

	@FindBy(xpath="//*[@class='sc-bdVaJa cvqffm']/div/div")
	private List<WebElement> ListSuggestions;
	
	@FindBy(xpath="//*[@class='sc-bdVaJa HeaderSearchSuggestionText-h71b5o-0 emXVVU']//*[@class='unbold']")
	private List<WebElement> ListSearchKeyUnbold;

	@FindBy(xpath="//*[@class='HeaderSearchSuggestions__HeaderSearchCategorySuggestionsContainer-sc-1vd0egg-1 eHNHta']/div/div")
	private List<WebElement> ListCategories;
	
	@FindBy(xpath="//*[@class='sc-bdVaJa sc-bwzfXH HeaderSearchSuggestions__HeaderSearchProductSuggestionsContainer-sc-1vd0egg-0 bCtpcH']/div/div")
	private List<WebElement> ListProdSuggestion;
	
	@FindBy(xpath="//*[@class='sc-bdVaJa sc-bwzfXH kXJQuI']/img")
	private List<WebElement> ListImgSearch;
	
	@FindBy(xpath="//*[@class='sc-bdVaJa sc-bwzfXH HeaderSearchSuggestionContainer-q09cda-0 hcgpku']//b/text()")
	private List<WebElement> otherTextSuggestion;
	
	@FindBy(css="span[class='unbold']")
	private List<WebElement> SuggestionTextUnbold;

	public List<WebElement> getSuggestionTextUnbold() {
		return SuggestionTextUnbold;
	}

	public List<WebElement> getOtherTextSuggestion() {
		return otherTextSuggestion;
	}

	public List<WebElement> getListImgSearch() {
		return ListImgSearch;
	}

	public List<WebElement> getListProdSuggestion() {
		return ListProdSuggestion;
	}

	public WebElement getEnterSearchText() {
		return EnterSearchText;
	}

	public List<WebElement> getListSuggestions() {
		return ListSuggestions;
	}

	public WebElement getSearchSubmit() {
		return SearchSubmit;
	}

	public List<WebElement> getListSearchSubmit() {
		return ListSearchSubmit;
	}

	public List<WebElement> getSuggestions() {
		return ListSuggestions;
	}

	public List<WebElement> getListCategories() {
		return ListCategories;
	}

	public List<WebElement> getListSearchKeyUnbold() {
		return ListSearchKeyUnbold;
	}
	


}
