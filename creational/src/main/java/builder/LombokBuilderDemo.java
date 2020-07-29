package builder;

/**
 * Lombok的Builder模式
 *
 * @author zhaohaoren
 */

class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*lombok开始*/

    /**
     * 关键4 构建对象
     */
    public static PersonBuilder bulder() {
        return new PersonBuilder();
    }

    /**
     * 关键1 构造
     */
    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    /**
     * 关键2 构建类
     */
    public static class PersonBuilder {
        /**
         * 关键3 属性copy
         */
        private String name;
        private String age;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(String age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}


/**
 * @author zhaohaoren
 */
public class LombokBuilderDemo {
    public static void main(String[] args) {
        Person p = Person.bulder().name("justin").age("24").build();
        System.out.println(p.getName());
    }
}
