package lesson_38._03_standard_compose;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class StandardBox {
    List<String> things;

    public StandardBox(List<String> things) {
        this.things = things;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "StandardBox" + "[", "]")
                .add("things=" + things)
                .toString();
    }
}
