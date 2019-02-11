package ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        ArrayList<FileInputStream> al = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                al.add(i, new FileInputStream("file_" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Enumeration<FileInputStream> e = Collections.enumeration(al);
        }
    }
}
