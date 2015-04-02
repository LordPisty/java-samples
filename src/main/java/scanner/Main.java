package scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by screspi on 3/31/15.
 */
public class Main {

    public static void main(String... args) {
        final File file = new File("input.txt");
        try(final Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
