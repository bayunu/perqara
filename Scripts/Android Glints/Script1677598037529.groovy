import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import testing.*

Android a = new Android()
a.openApp()
a.signUp()
a.signOut()
a.signIn()
a.signOut()

@TearDown
def TearDown() {
	Mobile.closeApplication()
}