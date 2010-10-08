Eclipse Getting Started
===

All you need to do is ensure that `./libs/phonegap.jar`. Simply right click on `./libs` and select Build Path > Configure Build Path. Choose Java Build Path and select the Libraries tab. Click add Jars and select `phonegap.jar`. If you are building an Android project from the command line jar files found in libs are automatically compiled in. 

Terminal Getting Started
===

You will need to create a local.properties file with a path to your Android SDK install. Something like this:

	sdk.dir=/path/to/your/android-sdk-mac_86
	
Running `android update project -p .` will generate this file for you. From here start an AVD or plugin in a device and:

	ant debug install && adb logcat
	
This should build HelloWorldPlugin to your emulator or device. Sweet! Now, lets check out the code. 

Implementing your first Plugin
---

A PhoneGap/Android plugin consists of two parts: Java code and JavaScript code. The Java code will interact with the Android operating system and the JavaScript code wraps the exposed Java interfaces to create a more familiar feeling interface that suites the JavaScript language. 

Java
---

In this example `src/com/phonegap/HelloWorldPlugin/HelloWorldPlugin.java` is just a regular PhoneGap/Android starting Activity. Our plugin code is found in `src/com/HelloWorldPlugin/HelloWorld.java`. This is the simplest form of plugin:

	public class HelloWorld extends Plugin {
		public PluginResult execute(String action, JSONArray args, String callbackId) {
			if (action.equals("sayHello")) {
				return new PluginResult(PluginResult.Status.OK, "HELLO FROM NATIVE CODES!");
			} 
			else {
				return new PluginResult(PluginResult.Status.INVALID_ACTION);
			}
		}
	}
	
	<script src="http://gist.github.com/617582.js?file=HelloWorld.java"></script>

A plugin need only extend `Plugin` and implement an `execute`	method which, intuitively, returns a `PluginResult`. This form of the `execute` method signature requires an `action` which is a simple string to alias a JavaScript method, an array of arguments and a string identifier of the JavaScript method to execute upon completion. 

The PluginResult constructor is heavily overloaded and this is the simplest form. It takes status code and a string. We're still working on documenting the Plugin architecture for PhoneGap/Android so the best place to learn all about it is in the source here: http://github.com/phonegap-android/framework/src/com/phonegap/api

JavaScript
---

The other half of our plugin is this basic JavaScript wrapper found in `assets/www/helloworld.js`:

	var hello = function(win, fail) {
		PluginManager.addService("HelloWorld","com.phonegap.HelloWorldPlugin.HelloWorld");
		PhoneGap.execAsync(win, fail, "HelloWorld", "sayHello", []);
	};

The `PluginManager.addService` registers a Java Plugin to bind to the current WebView and `PhoneGap.execAsync` accepts a success callback, a failure callback, service to invoke, action (or method) on that service to call and finally an array of arguments to pass to the Java Plugin. More info on the JavaScript side of the plugin architecture can be found in `phonegap.js`. (Docs coming soon I promise!!!)

Running the Plugin
---

From here, all we need to do is include helloworld.js in our index.html file and call the new `hello` method once the device is ready. You can see this in `assets/www/index.html`
