package lesson_38._03_standard_compose;

import lesson_38._02_stanard.Child;

import java.io.*;
import java.util.List;

public class Main {
    public static final String PATH_TO_OUTPUT = "src\\lesson_38\\resources\\output.file";

    public static void main(String[] args) {
        StandardCat vaska = new StandardCat("Vaska",
                new StandardBox(List.of("Ball", "Mouse")));

        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)) {

            oos.writeObject(vaska);

            StandardCat.staticField = "New Value";

            StandardCat catFromFile = (StandardCat) ois.readObject();

            System.out.println(catFromFile);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
