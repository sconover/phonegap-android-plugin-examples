var hello = function(win, fail) {
	PluginManager.addService("HelloWorld","com.phonegap.HelloWorldPlugin.HelloWorld");
	PhoneGap.execAsync(win, fail, "HelloWorld", "sayHello", []);
};