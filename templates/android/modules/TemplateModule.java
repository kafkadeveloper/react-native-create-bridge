package com.{{app}}.{{template}};

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

public class {{template}}Module extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "{{template}}";
    private static ReactApplicationContext reactContext = null;

    public {{template}}Module(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        super(context);

        reactContext = context;
    }

    @Override
    public String getName() {
        // Tell React the name of the module
        return REACT_CLASS;
    }

    @Override
    public Map<String, Object> getConstants() {
        // Export any constants to be used in your native module
        final Map<String, Object> constants = new HashMap<>();
        constants.put("EXAMPLE", "example");

        return constants;
    }

    @ReactMethod
    public void exampleMethod () {
        // An example native method that you will expose to React
    }

    private static void emitDeviceEvent(String eventName, @Nullable WritableMap eventData) {
        // A method for emitting from the native side to JS
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, eventData);
    }
}