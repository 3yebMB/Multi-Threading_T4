/**
 * Постраничный вывод информации из большого файла
 *
 * @author      Michael 3yeb <https://github.com/3yebMB>
 * @version     1.0
 * @since       1.0
 *
 * @param fs - размер файла
 * @param ps - размер страницы
 * @param rb - буфер для чтения страницы
 * @param ip - вводимая пользователем страница
 * @@return - в цикле выводим элементы rb.
 */

package ex4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomAccessFile f = null;
        long fs = 0;
        int ps = 1800;
        byte[] rb = new byte[ps];

        try {
            f = new RandomAccessFile("big_file.txt", "r");
            fs = f.length();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("В файле " + fs/ps + " страниц, введите номер страницы, которую нужно вывести : ");
        int ip = in.nextInt();

        try {
            f.seek(ip*ps);
            f.read(rb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (byte b : rb) {
            System.out.print((char)b);
        }
    }
}
