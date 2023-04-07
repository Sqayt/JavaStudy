package ru.ivanovds.GB.Lesson2HM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_3 {

    private final static Scanner scanner = new Scanner(System.in);

    private static Logger logger = LogManager.getLogger(Task_3.class);

    public static void main(String[] args) {
        try {
            byte res = scanner.nextByte();
            writeFile(String.valueOf(res), "result.txt");
        } catch (InputMismatchException e) {
            logger.debug(e.getMessage(), "WriteFile");
        }

    }

    private static void writeFile(String text, String name) {
        try (BufferedWriter r = new BufferedWriter(new FileWriter(name, false))) {
            r.write(text);
            r.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
