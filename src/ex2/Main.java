package ex2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        byte[] inData = new byte[50];
        try (FileInputStream in = new FileInputStream("new.txt")) {
            in.read(inData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (byte b: inData) {
            System.out.print((char)b);
        }
    }
}
