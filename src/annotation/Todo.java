package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by simu-hq on 2014/10/11.
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Todo {
    public enum Priority{
        LOW,MEDIUM,HIGH
    }

    public enum Status{
        STARTED,NOT_STARTED
    }

    String author() default "hqtc123";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
