package by.bsu.file;

import by.bsu.exception.FileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Yauheniya_Neliub on 1/23/2015.
 */
public class ReadFile {
    public void read(String filename) throws FileException {
        try (Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileException(e.getMessage(), e);
        }
    }
}
