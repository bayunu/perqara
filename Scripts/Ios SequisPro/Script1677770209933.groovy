import testing.*

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

Ios i = new Ios()

i.signIn()
i.signOut()

@TearDown
def TearDown() {
	Mobile.closeApplication()
}

@SetUp
def setUp() {
    Mobile.startApplication(GlobalVariable.appIDSequisPro, false)
}

