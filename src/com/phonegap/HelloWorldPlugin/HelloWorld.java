package com.phonegap.HelloWorldPlugin;

import org.json.*;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;


public class HelloWorld extends Plugin {
	
	
	/**
	 * Executes the request and returns PluginResult.
	 * 
	 * @param action 		The action to execute.
	 * @param args 			JSONArry of arguments for the plugin.
	 * @param callbackId	The callback id used when calling back into JavaScript.
	 * @return 				A PluginResult object with a status and message.
	 */
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		if (action.equals("sayHello")) {
			return new PluginResult(PluginResult.Status.OK, "HELLO FROM NATIVE CODES!");
		} 
		else {
			return new PluginResult(PluginResult.Status.INVALID_ACTION);
		}
	}
}

