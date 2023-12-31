package lesson_38._02_stanard;

import java.io.Serializable;
import java.util.StringJoiner;

public class Child extends Parent implements Serializable {
    int childField;

    public Child(int childField) {
        System.out.println("Child constructor");
        this.childField = childField;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Child.class.getSimpleName() + "[", "]")
                .add("parentField=" + parentField)
                .add("childField=" + childField)
                .toString();
    }
}
