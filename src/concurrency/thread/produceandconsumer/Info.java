package concurrency.thread.produceandconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class Info {
    private int age = 20;
    private String name = "He";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " 's age is :  " + this.age;
    }

    public synchronized void set(String name, int age) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        this.age = age;
        this.name = name;
    }

    public synchronized String get() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return this.toString();
    }
}
