package com.phonegap.HelloWorldPlugin;

import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;

public class HelloWorldPlugin extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		this.addService("HelloWorld", "com.phonegap.HelloWorldPlugin.HelloWorld");
        super.loadUrl("file:///android_asset/www/index.html");
    }
}