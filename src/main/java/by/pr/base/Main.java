package by.pr.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Radkevich
 * @since 4.03.23
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("by.pr.Main$Square");
        Class<?> colorClass = Class.forName("by.pr.Main$Color");

        printClassInfo(stringClass, hashMapClass, squareClass, colorClass, Collection.class);
    }

    private static void printClassInfo(Class<?>... classes) {
        System.out.println();
        for (Class<?> clazz : classes) {
            System.out.println(String.format("class name: %s, class package name : %s",
                    clazz.getSimpleName(),
                    clazz.getPackage().getName()));

            Class<?>[] clazzInterfaces = clazz.getInterfaces();

            for (Class<?> clazzInterface : clazzInterfaces) {
                System.out.println(String.format("class %s implements: %s",
                        clazz.getSimpleName(),
                        clazzInterface.getSimpleName()));
            }
            System.out.println("is array: " + clazz.isArray());
            System.out.println("is primitive: " + clazz.isPrimitive());
            System.out.println("is enum: " + clazz.isEnum());
            System.out.println("is interface: " + clazz.isInterface());
            System.out.println("is anonymous: " + clazz.isAnonymousClass());
            System.out.println();
            System.out.println();
        }
    }


    private enum Color {
        RED,
        GREEN,
        BLUE
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private static class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }
}
