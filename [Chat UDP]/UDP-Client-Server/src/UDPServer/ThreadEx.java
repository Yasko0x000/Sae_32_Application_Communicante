
package UDPServer;

import java.util.ArrayList;

class MyThread extends Thread {

    int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10000));
        } catch (InterruptedException e) {
        }
        System.out.println("Hello from thread " + id);
    }
}

public class ThreadEx {

    public static void main(String[] args) {
        ArrayList<MyThread> t = new ArrayList<>();
        int nr = Integer.parseInt(args[0]);

        for (int i = 0; i < nr; i++) {
            MyThread temp = new MyThread(i);
            t.add(temp);
            temp.start();
        }

        try {
            for (int i = 0; i < nr; i++) {
                t.get(i).join();
            }
        } catch (InterruptedException e) {
        }
    }
}
