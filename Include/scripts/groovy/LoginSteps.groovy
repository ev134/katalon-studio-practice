import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

// copied the script from existing test
// add information in BDDLogin.feature (in Include)
// added feature file to loginBDD test
class LoginSteps {
	
	@Given("User navigates to login page")
	def navigateToLoginPage() {
		println "I am inside navigateToLoginPage"
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
	}
	
	@When("User enters (.*) and (.*)")
	def enterCredentials(String username, String password) {
		println "I am inside enterCredentials"
		println "Username: " + username
		println "Password: " + password
		WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), username)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), password)
	}
	
	@And("Click on login button")
	def clickLogin() {
		println "I am inside clickLogin"
		WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))
	}
	
	@Then("User is navigated to the homepage")
	def verifyHomePage() {
		println "I am inside verifyHomePage"
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/span_Admin'), 5)
		WebUI.closeBrowser()
	}
}