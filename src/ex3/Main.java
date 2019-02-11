package ex3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        ArrayList<FileInputStream> al = new ArrayList<>();
        FileOutputStream fos = null;

        for (int i = 0; i < 5; i++) {
            try {
                al.add(new FileInputStream("file_" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            Enumeration<FileInputStream> e = Collections.enumeration(al);
            SequenceInputStream sis = new SequenceInputStream(e);

            fos = new FileOutputStream("file_result.txt");

            byte[] data = new byte[100];
            int byteRead = sis.read(data);
            while (byteRead != -1) {
                fos.write(data, 0, byteRead);
                byteRead = sis.read(data);
            }
            fos.close();
            sis.close();
        } catch (FileNotFoundException excep) {
            excep.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

