import com.kursova.kep.entity.Group;

import java.util.List;

/**
 * Created by Mr. Skip.
 */
public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
//        System.out.println(Department.class);
//        System.out.println(Department[].class);
        System.out.println(Group.class.getMethod("getSubjectSet").getReturnType());
        System.out.println(List.class);
//        System.out.println(Class.forName("[Lcom.kursova.kep.entity.Department;"));
    }

}
