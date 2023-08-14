package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostCategoriesPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.AdminPostTagPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

@Epic("Regression Tests")
@Feature("Wordpress-Admin Tests")
public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Title " + randomNumber;
	String editPostBody = "Edit Body " + randomNumber;
	String authorName = "Automation Admin";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url"); 
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver (browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		showBrowserConsoleLogs(driver);
		
		log.info("Pre-Condition Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value:  " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}
	
	@Description("Create New Post")
	@Story("Create New Post") 
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 1: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl();
		
		log.info("Create_Post - Step 03: Click to 'Add New' button"); 
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 04: Enter to post title"); 
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Enter to post body"); 
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click to 'Publish' button"); 
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Verify 'Post published' message is displayed"); 
		adminPostAddNewPage.isPostPublishMessageDisplayed("Post published.");
	}

	@Description("Search Post")
	@Story("Search Post") 
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Search_Post Step 02: Enter to Search textbox"); 
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03: Click to 'Search Posts' button"); 
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'"); 
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));
		
		log.info("Search_Post Step 05: Verify Search table contains '" + authorName + "'"); 
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.endUserUrl);
		
		log.info("Search_Post - Step 07: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle)); 
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
		
		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor displayed at Post detail page"); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle)); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(currentDay));
	}

	@Description("Edit Post")
	@Story("Edit Post") 
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.adminUrl);
		
		log.info("Edit_Post - Step 02: Click to 'Posts' menu link"); 
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Edit_Post - Step 03: Enter to Search textbox"); 
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Edit_Post Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit_Post - Step 05: Click to Post title link and navigate to Edit Post page"); 
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		log.info("Edit_Post Step 04: Enter to post title"); 
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);
		
		log.info("Edit_Post - Step 05: Enter to post body"); 
		adminPostAddNewPage.enterToEditPostBody(editPostBody);
		
		log.info("Edit_Post - Step 06: Click to 'Update' button"); 
		adminPostAddNewPage.clickToPublishOrUpdateButton();
		
		log.info("Edit_Post - Step 07: Verify 'Post updated.' message is displayed"); 
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed ("Post updated."));
		
		log.info("Edit_Post - Step 08: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Edit_Post Step 09: Enter to Search textbox"); 
		adminPostSearchPage.enterToSearchTextbox (editPostTitle);
		
		log.info("Edit_Post - Step 10: Click to 'Search Posts' button"); 
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit_Post - Step 11: Verify Search table contains '" + editPostTitle + "'"); 
		verifyTrue (adminPostSearchPage.isPostSearchTableDisplayed ("title", editPostTitle));
		
		log.info("Edit_Post - Step 12: Verify Search table contains '" + authorName + "'"); 
		verifyTrue (adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Edit_Post Step 13: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.endUserUrl);
		
		log.info("Edit_Post Step 14: Verify Post infor displayed at Home page"); 
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName)); 
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));
		
		log.info("Edit_Post Step 15: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);
		
		log.info("Edit_Post - Step 16: Verify Post infor displayed at Post detail page"); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle)); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostBody)); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(authorName)); 
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(currentDay));
	}
	
	@Description("Delete Post")
	@Story("Delete Post")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(this.adminUrl);

		log.info("Delete_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete_Post Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete_Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Delete_Post - Step 06: Select 'Move to Trash item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

		log.info("Delete_Post - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

		log.info("Delete_Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 10: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Delete_Post - Step 11: Verify 'No posts found. message is displayed"); 
		verifyTrue (adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));
		
		log.info("Delete_Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.endUserUrl);
		
		log.info("Delete_Post - Step 13: Verify Post title undisplayed at Home page"); 
		verifyTrue(userHomePage.isPostInforUndisplayedWithPostTitle(editPostTitle));
		
		log.info("Delete_Post - Step 14: Enter to Search textbox"); 
		userHomePage.enterToSearchTextbox(editPostTitle);
		
		log.info("Delete_Post - Step 15: Click to 'Search' button"); 
		userSearchPostPage = userHomePage.clickToSearchButton();
		
		log.info("Delete_Post - Step 16: Verify 'Nothing Found' message is displayed"); 
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed());
	}
	
	@Parameters({"envName"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserDriver(envName);
	}
	
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostCategoriesPO adminPostCategoriesPage;
	AdminPostTagPO adminPostTagPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;

}
