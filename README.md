# ui-assignement
UI Tech assignment for WooliesX


1. This framework contains Selenium code to drive the browser and test the web application.
2. Uses a Maven project structure and written in Java.
3. Tests are written in Gherkin and are stored in feature files.
4. The framework utilizes the Page Object pattern.
5. Cucumber report is used for reporting
6. Config is read through config.properties


# Pre-requisites
- Java
- Maven
  
# Setting up UI Automation
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
	- maven : https://github.com/ShwetaGou/ui-assignement.git

# Running features
- Goto project directory.
- Use "mvn clean install" command to run features and generate the result.
- Reports will be generated in the folder name inside target/cucumber-reports/advanced-reports -starting with  report-feature*.html