package utils;

import java.util.Arrays;

public class EnumTransformer {

    public static <E extends Enum<E>> String [] arrayEnumValues(Class<E> hola){
        return Arrays.stream(hola.getEnumConstants()).map(Enum::toString).toArray(String[]::new);
    }
}
