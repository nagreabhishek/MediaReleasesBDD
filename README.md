The purpose of this project is to create an automated test suite to search media releases based on Ministers provided and reset filter.
Note:
- The testng.xml contains the TestRunner class, which has @DataProvider and @Test methods to start the project execution.
- Cucumber feature files are used to write test steps and furnish test data. Additionally, excel sheet or properties file can be used to furnish the test data.
- Screenshot is captured irrespective of the test run result.
- Allure report is generated once the execution is complete.

Project Structure:
- test.Runners package has the TestRunner class
- resources/features folder has the feature file
- BaseActions class has all the actions
- stepDefinition has the step definition file and hooks file
- globalParameters.properties has all the configurable items
- Report location: “/allure-results”

Project Execution:
1. To run the project from maven, use the “mvn clean test” command from the command line tool.
2. To run the project from runner file, run the TestRunner file under test.Runners.
3. To view report, run mvn allure:sure command from the command line tool.
Below is the generated sample allure report:
   
All the screenshots are present in README_UI.docx file