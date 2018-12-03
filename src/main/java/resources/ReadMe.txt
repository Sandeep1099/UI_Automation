I have used maven skeleton(we can remove jar dependecies using maven by defining dependcies in POM.xml file) for my assignment. Created Tests in src/test/java and my utilities in src/main/java
Created a base class in resources package for resuability of URL and browser 
Initialized value of browser and URL in data.properties(in resources package)
Created my test flow in Assignment.java(used concepts of TestNG annotations and assertions)
Used Relative and absolute Xpath(I have used Chropath plugin for Chrome to get Xpath in order to save time but more efficient and reliable way is to use customised xpath)
Please run the test through testng.xml(right click on testng.xml and run as testNG Suite) 
*note-need to install Testng plugin for Eclipse
*Also need to download browser drivers in order to invoke them in C drive(example,for chrome its chromedriver.exe)


"Reporting/Logging"
Used ExtentReporterNG.java for logging reports
Expand the test-output folder and click on ExtentreportsTestNG.html for the pass/fail report
click on Enable Dashboard in ExtentreportsTestNG.html in order to see pie charts, pass percentage etc.