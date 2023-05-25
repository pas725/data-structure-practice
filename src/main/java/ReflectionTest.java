import java.lang.reflect.Field;

/**
 * Created by psagar on 3/5/2018.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Address address = new Address("lane 1", "Pune");
        Person p = new Person(101, "John", address);
        System.out.println(getNestedValue(p, "person.address.city"));
    }

    static Field getField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (clazz.getSuperclass() != null) {
                return getField(clazz.getSuperclass(), fieldName);
            }
        }
        return null;
    }

    static Object getNestedValue(Object bean, String fieldName) {
        String nestedFields[] = fieldName.split("\\.");
        Class<?> currentClazz = bean.getClass();
        Object result = bean;
        try {
            for (int i=1; i<nestedFields.length; i++) {
                String f = nestedFields[i];
                Field field = getField(currentClazz, f);
                if (field != null) {
                    field.setAccessible(true);
                    result = field.get(result);
                    if (result != null) {
                        currentClazz = result.getClass();
                    }
                } else {
                    return null;
                }
            }
        } catch (IllegalAccessException ie) {
            return null;
        }
        return result;
    }

}

class Person {
    int id;
    String name;
    Address address;

    public Person(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}

class Address {
    String lane;
    String city;

    public Address(String lane, String city) {
        this.lane = lane;
        this.city = city;
    }
}