package by.pr.constructors.simple;

/**
 * @author Pavel Radkevich
 * @since 4.03.23
 */
public class Person {

    private Address address;
    private String name;
    private int age;

    public Person() {
        this.name = "anonymous";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Address address, String name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
