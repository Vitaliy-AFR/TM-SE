package org.example;

import lombok.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class LineReader {

    private final String INCORRECT_NUMBER_ENTERED = "Введено некорректное число";

    private static LineReader instance = new LineReader();
    private final Scanner scanner = new Scanner(System.in);

    private LineReader() {
    }

    public static LineReader getInstance() {
        return instance;
    }

    public String readString() {
        return scanner.nextLine();
    }

    public long readLong() {
        long number = 0;
        try {
            number = scanner.nextLong();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(INCORRECT_NUMBER_ENTERED);
            scanner.nextLine();
            throw new InputMismatchException();
        }
        return number;
    }

}
