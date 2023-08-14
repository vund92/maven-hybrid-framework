package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String BODY_BUTTON = "css=p[class*='block-editor-default']"; 
	public static final String BODY_TEXTBOX = "css=p.block-editor-rich-text__editable"; 
	public static final String PUBLISH_BUTTON_BEFORE_CLICK = "css=div.edit-post-header__settings>button.editor-post-publish-button__button";
	public static final String PUBLISH_BUTTON_AFTER_CLICK = "css=div.editor-post-publish-panel__header-publish-button>button.editor-post-publish-button__button";
	public static final String PUBLISHED_OR_UPDATE_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "css=div[aria-label='Editor top bar'] button[class*= 'editor-post-publish-button']";

}
