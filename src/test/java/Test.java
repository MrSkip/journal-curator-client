import com.kursova.kep.entity.Group;
import com.kursova.kep.rest.Client;

/**
 * Created by Mr. Skip.
 */

public class Test {

    public static void main(String[] args) throws Exception {
        Group departments = Client
                .get("group/1", Group.class)
                .build();
        Class aClass = Group.class;

//        System.out.println(Class.forName("com.kursova.kep.entity.Department").newInstance());
    }

}
