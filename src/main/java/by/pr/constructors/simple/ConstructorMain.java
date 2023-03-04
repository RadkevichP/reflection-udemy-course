package by.pr.constructors.simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Radkevich
 * @since 4.03.23
 */
public class ConstructorMain {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        printConstructorData(Class.forName("by.pr.constructors.simple.Person"));

        Address address = createInstanceWithArguments(Address.class, "Sugiharos", 2);

        Person person = createInstanceWithArguments(Person.class, address, "Perez", 33);
        System.out.println(person);
    }


    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
            if (declaredConstructor.getParameterTypes().length == args.length) {
                return (T) declaredConstructor.newInstance(args);
            }
        }
        System.out.println("No matching constructors were found");
        return null;
    }


    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), declaredConstructors.length));

        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            List<Object> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(Class::getSimpleName)
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }
        System.out.println();
        System.out.println();
    }
}
