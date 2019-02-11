package ex1;

public class outputThread {
    private char l;
    private int counter = 0;

    public synchronized void printLetter(char ch) {
        for (int i = 0; i < 5; i++) {
            if (counter == 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (ch == 'C') counter++;
            System.out.print(ch);
            notify();
        }
    }
}
