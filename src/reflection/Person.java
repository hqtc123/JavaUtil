package reflection;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-11
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 * 通过Class调用其他类中的构造函数 （也可以通过这种方式通过Class创建其他类的对象）
 * 如果要调用无参构造函数，一定要在类中显式定义无参构造函数
 */
public class Person {
    private int age;
    private String name;
    private String address;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + "   " + this.age + "   " + this.address;
    }
}
