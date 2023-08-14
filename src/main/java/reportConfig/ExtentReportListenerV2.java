/*
 * package reportConfig;
 * 
 * import java.io.File; import java.util.Calendar; import java.util.Date; import
 * java.util.List; import java.util.Map; import org.testng.IReporter; import
 * org.testng.IResultMap; import org.testng.ISuite; import
 * org.testng.ISuiteResult; import org.testng.ITestContext; import
 * org.testng.ITestResult; import org.testng.Reporter; import
 * org.testng.xml.XmlSuite; import
 * com.relevantcodes.extentreports.ExtentReports; import
 * com.relevantcodes.extentreports.ExtentTest; import
 * com.relevantcodes.extentreports.LogStatus;
 * 
 * import commons.GlobalConstants;
 * 
 * //Trong truong hop ko can chup hinh thi implements IReporter //Trong truong
 * hop can chup hinh thi implements ITestListener ==> class ExtentTestListener
 * danh rieng cho viec chup hinh public class ExtentReportListenerV2 implements
 * IReporter { private ExtentReports extent; private ExtentTest test;
 * 
 * public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
 * String outputDirectory) { //extent = new
 * ExtentReports(System.getProperty("user.dir") +
 * "/extentReportV2/ExtentReport.html", true); extent = new
 * ExtentReports(GlobalConstants.EXTENT_REPORT_PATH +
 * "ExtentReportV2NoScreenShot.html", true); for (ISuite suite : suites) {
 * Map<String, ISuiteResult> result = suite.getResults();
 * 
 * for (ISuiteResult r : result.values()) { ITestContext context =
 * r.getTestContext(); buildTestNodes(context.getPassedTests(), LogStatus.PASS);
 * buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
 * buildTestNodes(context.getSkippedTests(), LogStatus.SKIP); } }
 * extent.flush(); extent.close(); }
 * 
 * private void buildTestNodes(IResultMap tests, LogStatus status) { if
 * (tests.size() > 0) { for (ITestResult result : tests.getAllResults()) { test
 * = extent.startTest(result.getMethod().getMethodName());
 * 
 * test.setStartedTime(getTime(result.getStartMillis()));
 * test.setEndedTime(getTime(result.getEndMillis()));
 * 
 * for (String group : result.getMethod().getGroups())
 * test.assignCategory(group);
 * 
 * if (result.getThrowable() != null) { test.log(status, result.getThrowable());
 * } else { test.log(status, "Test " + status.toString().toLowerCase() + "ed");
 * }
 * 
 * extent.endTest(test); } } }
 * 
 * private Date getTime(long millis) { Calendar calendar =
 * Calendar.getInstance(); calendar.setTimeInMillis(millis); return
 * calendar.getTime(); }
 * 
 * public void extendLog(String message) { test.log(LogStatus.INFO, message);
 * Reporter.log(message); } }
 */