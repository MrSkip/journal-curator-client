import com.kursova.kep.entity.BaseEntity;
import com.kursova.kep.entity.Department;
import com.kursova.kep.entity.Group;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr. Skip.
 */
public class Test3 {

    private static String string;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
//        System.out.println(Department.class);
//        System.out.println(Department[].class);
//        System.out.println(Group.class.getMethod("getSubjectSet").getReturnType());
//        System.out.println(List.class);
//        System.out.println(Class.forName("[Lcom.kursova.kep.entity.Department;"));
        System.out.println(Department[].class);
        string = "com.kursova.kep.entity.BaseEntity";
        Class aClass = Class.forName("[L" + string + ";");
        System.out.println(aClass.getTypeName().replace("[]", ""));
//        Class aClass1 = BaseEntity[].class;
//        System.out.println(Class.forName(string).newInstance());
//        System.out.println(Class.forName("[L" + string + ";") == BaseEntity[].class);
//        System.out.println(Arrays.toString(Department.class.getMethods()));
//        Department department = (Department) aClass.newInstance();
//        System.out.println(Arrays.toString(department.getClass().getMethods()));
//        System.out.println(aClass.newInstance());

    }

}
