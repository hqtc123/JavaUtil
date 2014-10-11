package annotation;

import java.lang.reflect.Method;

/**
 * Created by simu-hq on 2014/10/11.
 */
public class Example {
    @Todo(author = "some body")
    public void doSomething() {

    }

    @Author("he")
    public void testAuthor() {

    }

    //use annotation

    public static void main(String main[]) {
        Class example = Example.class;
        for (Method method : example.getMethods()) {
            Todo todoAnnotation = method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                System.out.println("Method: " + method.getName());
                System.out.println("Author: " + todoAnnotation.author());
            }

            //Wrong to do below because author annotation retentionPolicy
            //is source
            Author authorAnnotation=method.getAnnotation(Author.class); //wrong

        }
    }
}
