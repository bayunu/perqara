package testing

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Web {
	@Keyword
	def closeWeb() {
		WebUI.closeBrowser()
	}
	def openWeb() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://glints.com/id')
		WebUI.maximizeWindow()
	}
	
	def SignIn() {
		WebUI.click(findTestObject("Object Repository/WebGlints/Masuk"))
		WebUI.waitForElementVisible(findTestObject("Object Repository/WebGlints/Input Email"), 0)
		WebUI.setText(findTestObject("Object Repository/WebGlints/Input Email"),'jayakarta2@mailinator.com')
		WebUI.setText(findTestObject("Object Repository/WebGlints/Input Password"),'Jayakarta')
		WebUI.click(findTestObject("Object Repository/WebGlints/Show Password"))
		WebUI.click(findTestObject("Object Repository/WebGlints/button Masuk"))
	}
	
	def SignOut() {
		WebUI.click(findTestObject("Object Repository/WebGlints/Menu Saya"))
		WebUI.click(findTestObject("Object Repository/WebGlints/Keluar"))
	}
}
