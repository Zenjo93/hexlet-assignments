package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {

    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> notNullFieldNames = new ArrayList<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
           if (field.isAnnotationPresent(NotNull.class)) {
               field.setAccessible(true);
               if (field.get(address) == null) {
                   notNullFieldNames.add(field.getName());

               }
           }
        }

        return notNullFieldNames;
    }
}
// END
