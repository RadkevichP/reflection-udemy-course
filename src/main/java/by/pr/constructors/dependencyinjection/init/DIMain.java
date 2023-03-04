package by.pr.constructors.dependencyinjection.init;

import by.pr.constructors.dependencyinjection.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 4.03.23
 */
public class DIMain {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        TicTacToeGame game = createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    public static <T> T createObjectRecursively(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();
        for (Class<?> parameterType : constructor.getParameterTypes()) {
            Object parameterValue = createObjectRecursively(parameterType);
            constructorArguments.add(parameterValue);
        }

        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArguments.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor for class %s", clazz.getSimpleName()));
        }
        return constructors[0];
    }
}
