import com.kursova.kep.entity.Department;

import java.lang.reflect.Method;

/**
 * Created by Mr. Skip.
 */
public class Test4 {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Department.class.getMethod("getId");
        System.out.println(method.getDeclaringClass().getSimpleName());
    }

}
