package miscellaneous;

import java.lang.reflect.Field;

//Project: techbow
//Package: miscellaneous
//ClassName: Foo
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-28 星期四 0:27
public class Foo {
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person1 = new Person("VipMao", 24, "男" );
        Person person2 = new Person("VipMao", 24, "女" );
    
        //通过Class.getDeclaredField(String name)获取类或接口的指定属性值。
        Field f1 = person1.getClass().getDeclaredField("name");
        System.out.println("-----Class.getDeclaredField(String name)用法-------");
        System.out.println(f1.get(person1));
        System.out.println("-----Class.getDeclaredFields()用法-------");
        //通过Class.getDeclaredFields()获取类或接口的指定属性值。
        Field[] f2 = person1.getClass().getDeclaredFields();
        for (Field field : f2) {
            field.setAccessible(true);
            System.out.println(field.get(person1));
        }
        //修改属性值
        System.out.println("----修改name属性------");
        f1.set(person1, "Maoge");
        //修改后再遍历各属性的值
        Field[] f3 = person1.getClass().getDeclaredFields();
        for (Field fields : f3) {
            fields.setAccessible(true);
            System.out.println(fields.get(person1));
        }
        
    }
    
}

class Person {
    
    public String name;
    private Integer age;
    private String sex;
    
    public Person() {
    }
    
    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
}

