var hello = function(win, fail) {
	if (window['HelloWorld'] == undefined)
		PluginManager.addService("HelloWorld","com.phonegap.HelloWorldPlugin.HelloWorld");
	PhoneGap.execAsync(win, fail, "HelloWorld", "sayHello", []);
};