QA-Test README:
1. Setting up the project:
Export all the files in Eclipse (including referenced libararies).
2. Testing on browser types:
a) 	For testing on Chrome: Change the String value “chromePath” (in file QA-Test/src/testSetup/baseSetup.java) to the path on your local machine where chromedriver.exe is located.
b)	For testing on Internet Explorer: Change the String value “iePath” (in file QA-Test/src/testSetup/baseSetup.java) to the path on your local machine where explorer.exe is located.

c) 	For testing on Safari: Install the plugin “SafariDriver.safariextz” and enable webdriver in safari browser preferences.
3. Testing the script:
a)	For testing in a specified browser: change the parameter with name “browserName” (in file QA-Test/testing.xml) to “firefox”, “chrome”, “internet explorer” or “safari”.
	For ex. <parameter name="browserName" value="firefox" />
b) 	Give the URL using parameter with name “webUrl” in the same file as mentioned above.
	For ex. <parameter name="webUrl" value="http://selenium.couponapitest.com/" />

