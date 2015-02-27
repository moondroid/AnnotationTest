package it.moondroid;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by marco.granatiero on 27/02/2015.
 */
public class LogMe {

    public static void withClass(Class className){

        for (Method method : className.getDeclaredMethods()) {

            Annotation annotation = method.getAnnotation(Loggable.class);
            Loggable loggable = (Loggable) annotation;
            if (loggable != null && loggable.enabled()) {
                Log.d(LogMe.class.getName(), "Executing " + method.getName());
                switch (loggable.logType()){
                    case INFO:
                        Log.i(LogMe.class.getName(), "Executing " + method.getName());
                        break;
                    case DEBUG:
                        Log.d(LogMe.class.getName(), "Executing " + method.getName());
                        break;
                    case WARNING:
                        Log.w(LogMe.class.getName(), "Executing " + method.getName());
                        break;
                    case ERROR:
                        Log.e(LogMe.class.getName(), "Executing " + method.getName());
                        break;
                }
            }
        }
    }
}
