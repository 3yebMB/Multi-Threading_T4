/**
 * Постраничный вывод информации из большого файла
 *
 * @author      Michael 3yeb <https://github.com/3yebMB>
 * @version     1.0
 * @since       1.0
 *
 * @paran fn - имя файла
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
        final String fn = "big_file.txt";
        RandomAccessFile f = null;
        long fs = 0;
        int ps = 1800;
        byte[] rb = new byte[ps];
        long t = System.currentTimeMillis();

        try {
            f = new RandomAccessFile(fn, "r");
            fs = f.length();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Размер файла %s - %.2f Мб.\n", fn, (float)fs/1024/1024);
        System.out.println("С начала запуска программы прошло " + (System.currentTimeMillis()-t) + " мс\n");

        Scanner in = new Scanner(System.in);
        System.out.println("В файле " + fs/ps + " страниц, введите номер страницы, которую нужно вывести : ");
        int ip = in.nextInt();
        t = System.currentTimeMillis();

        try {
            f.seek(ip*ps);
            f.read(rb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (byte b : rb) {
            System.out.print((char)b);
        }

        System.out.println("\n\nНа операцию вывода требуемой страницы понадобилось "+ (System.currentTimeMillis()-t) + " мс");
    }
}
