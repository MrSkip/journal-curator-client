import com.kursova.kep.entity.Department;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Mr. Skip.
 */
public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Department.class);
        System.out.println(Department[].class);
        System.out.println(Department.class.getPackage().getName());
        System.out.println(Class.forName("[Lcom.kursova.kep.entity.Department;"));
    }

}
