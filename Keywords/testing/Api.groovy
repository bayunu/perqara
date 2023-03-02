package testing

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject


public class Api {

	@Keyword

	def signUp() {
		ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Reqress/SignUp'))
		WS.verifyResponseStatusCode(response, 200)
	}

	def signIn() {
		ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Reqress/SignIn'))
		WS.verifyResponseStatusCode(response, 200)
	}

	def listUser() {
		ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Reqress/List User'))
		WS.verifyResponseStatusCode(response, 200)
	}

	def singleUser() {
		ResponseObject su = WS.sendRequest(findTestObject('Object Repository/Reqress/Single User'))
		ResponseObject sunf = WS.sendRequest(findTestObject('Object Repository/Reqress/Single User Not Found'))
		WS.verifyResponseStatusCode(su, 200)
		WS.verifyResponseStatusCode(sunf, 200) //Gagal karena respond nya 404
	}
}
