package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);	
		pressKeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}
	
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		// Duyệt qua tất cả các page number (paging)
		for (int index = 1; index < totalPage; index++) {
			clickToElement(HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			// Get text của all row mỗi page đưa vào ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		
		// In tất cả giá trị row ra - tất cả các page
		for (String value : allRowValueAllPage) {
			//System.out.println("--------------------------------------------------");
			System.out.println(value);
		}
		
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		// Column Index dựa vào cột
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println("Column:  " + columnIndex);
		
		waitForElementVisible (HomePageUI. TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex)); 
		sendkeyToElement(HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
		
	}
	
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		selectItemInDefaultDropdown(HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber,
				String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(HomePageUI.LOAD_BUTTON);
		clickToElement(HomePageUI.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}
	
	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}
}
