import com.kursova.kep.entity.Department;
import com.kursova.kep.rest.Client;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mr. Skip.
 */

public class Test {

    public static void main(String[] args) throws Exception {
        List<Department> departments = Client
                .get("department", Department[].class)
                .setVariable(
                        new HashMap<String, String>(){{
                            put("name", "Mula");
                        }})
                .build();
        System.out.println(departments);
    }

}
