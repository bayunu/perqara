package testing

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable

public class Ios {

	@Keyword
	def signIn() {
		try {
			if (Mobile.verifyElementVisible(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Home']), 0, FailureHandling.OPTIONAL)) {
				Mobile.comment('Already Login')
				if (Mobile.verifyElementVisible(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeStaticText', [('staticText') : 'Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.']), 5, FailureHandling.OPTIONAL)) {
					Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Allow']), 0)
				}
			} else {
				Mobile.comment('Login First')
				Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Login']), 0)
				Mobile.setText(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeTextField', [('textField') : 'Masukkan username']), GlobalVariable.username, 0)
				Mobile.setText(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeSecureTextField', [('secureTextField') : 'Masukkan password']), GlobalVariable.password, 0)
				Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'ic16Show']), 0)
				Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Masuk']), 0)
			}
		} catch (Exception e) {
			e.printStackTrace()
			Mobile.comment('Failed Login')
		}
	}

	def signOut() {

		try {
			while (Mobile.verifyElementNotVisible(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Home']), 0, FailureHandling.OPTIONAL)) {
				Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Batal']), 0, FailureHandling.OPTIONAL)
				Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'ic24Disclosure']), 0, FailureHandling.OPTIONAL)
			}
			while (Mobile.verifyElementNotVisible(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeStaticText', [('staticText') : 'Log out']), 5,FailureHandling.OPTIONAL)) {
				SwipeRight()
			}

			Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeStaticText', [('staticText') : 'Log out']), 5)
			Mobile.tap(findTestObject('Object Repository/IOsSequisPro/XCUIElementTypeButton', [('button') : 'Log out']), 5)
		} catch (Exception e) {
			e.printStackTrace()
			Mobile.comment('Failed Logout')
		}
	}

	def SwipeRight() {

		int device_height = Mobile.getDeviceHeight()
		int device_width = Mobile.getDeviceWidth()

		int startX = 0
		int endX = device_width / 2
		int startY = device_height / 2
		int endY = startY

		Mobile.swipe(startX, startY, endX, endY)
	}
}