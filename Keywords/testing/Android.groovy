package testing

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling


public class Android {
	@Keyword

	def openApp() {
		Mobile.startExistingApplication('com.glints.candidate')
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/LANJUT DENGAN EMAIL"), 0)
	}

	def signUp() {
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/DAFTAR SEKARANG"), 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Email anda"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Email anda"), "Jayakarta1@mailinator.com", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/LANJUTKAN"), 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Nama Depan"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Nama Depan"), "Jayakarta", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Nama Belakang"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Nama Belakang"), "Jayakarta", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Password"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Password"), "Jayakarta", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/Daftar Lokasi"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Lokasi"), "Jakarta", 0)
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/Get Lokasi"), 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - HP"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - HP"), "1234567890"+"\\n", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/DAFTAR"), 0)

		// Check Ketika Daftar Gagal Karena Email Sudah Terdaftar dan didirect ke SignIn
		if (Mobile.verifyElementVisible(findTestObject("Object Repository/AndroidGlints/MASUK SEKARANG"), 0, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject("Object Repository/AndroidGlints/MASUK SEKARANG"), 0)
			signIn()

		} else {

			Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Cari Jenis Pekerjaan"), 0)
			Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Daftar Cari Jenis Pekerjaan"), "QA", 0)
			Mobile.tap(findTestObject("Object Repository/AndroidGlints/Get Jenis Pekerjaan"), 0)

			Mobile.tap(findTestObject("Object Repository/AndroidGlints/SELANJUTNYA"), 0)

			Mobile.tap(findTestObject("Object Repository/AndroidGlints/Get Lokasi Kerja"), 0)

			Mobile.tap(findTestObject("Object Repository/AndroidGlints/TAMPILKAN LOWONGAN"), 0)
		}
	}

	def signIn() {
		// Check Ketika Ada Cache Email di Placeholder dan diapus
		if (Mobile.verifyElementVisible(findTestObject("Object Repository/AndroidGlints/Check Cache Email Sign In"), 0, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject("Object Repository/AndroidGlints/Check Cache Email Sign In"), 0)
			Integer x = Mobile.getElementWidth(findTestObject("Object Repository/AndroidGlints/Check Cache Email Sign In"), 0)
			Integer y = Mobile.getElementHeight(findTestObject("Object Repository/AndroidGlints/Check Cache Email Sign In"), 0)
			x-=(y/2)
			y*=3
			Mobile.tapAtPosition(x, y)
		}

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Email anda"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Email anda"), "Jayakarta1@mailinator.com", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/EditText - Kata sandi anda"), 0)
		Mobile.setText(findTestObject("Object Repository/AndroidGlints/EditText - Kata sandi anda"), "Jayakarta", 0)

		Mobile.tap(findTestObject("Object Repository/AndroidGlints/MASUK"), 0)
	}

	def signOut() {
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/PROFILE"), 0)
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/Settings"), 0)
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/Keluar"), 0)
		Mobile.tap(findTestObject("Object Repository/AndroidGlints/YA"), 0)
	}
}
