package lesson_39._01_training.utils;

import lesson_39._01_training.exceptions.TxtLineException;
import lesson_39._01_training.model.CatModel;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class CatUtils {
    public static final String PATH_TO_FILE = "src/lesson_39/_01_training/resources/save.csv";

    public static List<CatModel> extractFromFile() {
        List<CatModel> cats = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileInputStream(PATH_TO_FILE))){
            while (sc.hasNextLine()) {
                try {
                    cats.add(CatFactory.getInstance(sc.nextLine()));
                } catch (TxtLineException e) {
                    System.err.println(e);
                    System.err.println("Message: " + e.getCause().getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Exception in class: " + e.getClass().getName());
        }
        return cats;
    }

    public static void printCats(List<CatModel> cats) {
        cats.forEach(System.out::println);
    }
}
