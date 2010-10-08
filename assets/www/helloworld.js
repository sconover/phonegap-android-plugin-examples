var hello = function(win, fail) {
	PhoneGap.execAsync(win, fail, "com.phonegap.HelloWorldPlugin.HelloWorld", "sayHello", []);
};