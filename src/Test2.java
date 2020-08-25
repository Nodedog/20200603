public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread("这里可以起名字"){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        thread.start();
    }
}
