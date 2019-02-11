package ex1;

public class ThreadClass implements Runnable {

    outputThread ot;
    char aChar;


    public ThreadClass(outputThread ot, char aChar) {
        this.ot = ot;
        this.aChar = aChar;
    }

    @Override
    public void run() {
        ot.printLetter(aChar);
    }
}
