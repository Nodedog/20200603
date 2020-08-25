/*
*
*   start和run 的区别
*
* */
public class Test {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("哈哈哈");
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        t.run();
    }
}
