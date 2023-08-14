package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage{
	
	WebDriver driver;
	
	public AdminUserPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public int getUserNumberAtUI() {
		waitForElementVisible(AdminUserPageUI.TOTAL_NUMBER_TEXT); 
		String totalNumber = getElementText(AdminUserPageUI.TOTAL_NUMBER_TEXT);
		return Integer.parseInt(totalNumber.split(" ")[0]);
	}

	public int getUserNumberAtDB(){
		Connection conn = MySQLConnUtils.getMySQLConnection();
		System.out.println("Opened connection: " + conn);
		Statement statement;
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				totalUsers.add(rs.getInt(1));
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return totalUsers.size();
	}

}
