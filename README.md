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

![image](https://github.com/user-attachments/assets/52003836-ddc0-4922-998a-054aa8134cde)


Project Execution:
1a. To run the project from maven, use the “mvn clean test” command from the command line tool.
1b. To run the project from runner file, run the TestRunner file under test.Runners.
2. To view report, run mvn allure:sure command from the command line tool.
Below is the generated sample allure report:
 
 
![image](https://github.com/user-attachments/assets/3a1aebe9-2130-4f99-aeb8-080ded59eb26)
