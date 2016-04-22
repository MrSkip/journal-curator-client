import com.kursova.kep.entity.Group;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Mr. Skip.
 */
public class Test4 {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Method method = Group.class.getMethod("getSubjectSet");
        String someString = "1";
        System.out.println(someString.matches("[A-Za-zА-Яа-яїЇіІєЄ @.-]"));
    }

}
