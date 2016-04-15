import com.kursova.kep.entity.BaseEntity;
import com.kursova.kep.entity.Department;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mr. Skip.
 */

public class Test2 {
    private static HashMap<String, String> columnsName = new HashMap<>();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Inner inner = new Inner();

        Method method = inner.getClass().getMethod("getInt", String.class);

        System.out.println(method.invoke(inner, "d"));
    }

}
class Inner{
    public int getInt(String s){
        return 1;
    }
}