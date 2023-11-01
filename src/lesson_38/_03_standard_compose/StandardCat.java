package lesson_38._03_standard_compose;

import java.io.Serializable;
import java.util.StringJoiner;

public class StandardCat implements Serializable {

    static final long serialVersionUID = 1L;

    static String staticField = "Static";
    final String name;
    transient StandardBox box;
    String newField = "NNN";

    public StandardCat(String name, StandardBox box) {
        this.name = name;
        this.box = box;
    }

    String doSmth() {
        return "gdgdd";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "StandardCat" + "[", "]")
                .add("static='" + staticField + "'")
                .add("name='" + name + "'")
                .add("box=" + box)
                .add("newField='" + newField + "'")
                .toString();
    }
}
