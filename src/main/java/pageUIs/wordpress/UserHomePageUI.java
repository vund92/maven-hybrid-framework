package pageUIs.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//a[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/ancestor::header/following-sibling::div//time[text()='%s']"; 
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/ancestor::header//following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE="xpath=//article//a[text()='%s']/ancestor::header//following-sibling::div//span[@class='author vcard']/a[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//*[@id='wp-block-search__input-1']";
	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";
}
