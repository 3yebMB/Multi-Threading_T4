package ex1;

public class Main {

//    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        outputThread o = new outputThread();
        for (int i = 0; i < 3; i++) {
            new Thread(new ThreadClass(o, (char) ('A'+i))).start();
        }
    }
}
