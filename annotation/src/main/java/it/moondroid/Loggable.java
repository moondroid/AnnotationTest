package it.moondroid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by marco.granatiero on 27/02/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {

    public enum Type {
        INFO, DEBUG, WARNING, ERROR
    }

    boolean enabled() default true;

    Type logType() default Type.DEBUG;

}
