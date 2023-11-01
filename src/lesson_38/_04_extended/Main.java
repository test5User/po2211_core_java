package lesson_38._04_extended;

import java.io.*;

public class Main {

    private static final String PATH_TO_FILE = "src/lesson_38/resources/output.file";

    public static void main(String[] args) {
        try (FileOutputStream fou = new FileOutputStream(PATH_TO_FILE);
             ObjectOutput oos = new ObjectOutputStream(fou);
             FileInputStream fis = new FileInputStream(PATH_TO_FILE);
             ObjectInput ois = new ObjectInputStream(fis)) {

            ExtFile extFile = new ExtFile("Vasia", "Pupkin", "My$uperPa$$!");
            System.out.println(extFile);
            oos.writeObject(extFile);
            System.out.println("______________________________");
            ExtFile fromFile = (ExtFile) ois.readObject();
            System.out.println(fromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
