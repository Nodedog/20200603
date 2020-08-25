/*
*
*                   线程常见的几个属性
*
*
*
* */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("啦啦啦线程"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程执行结束了");
            }
        };

        //这组属性,只要线程创建好就不会改变
        System.out.println(thread.getName());//线程名称
        System.out.println(thread.getId());//线程ID
        System.out.println(thread.getPriority());//线程优先级
        System.out.println(thread.isDaemon());//是否优先级

        //这三个属性会随着线程的运行过程而发生改变
        System.out.println(thread.isInterrupted());//是否被打断
        System.out.println(thread.isAlive());//是否存活
        System.out.println(thread.getState());//线程状态

        thread.start();

        while (thread.isAlive()){
            System.out.println(thread.isInterrupted());
            System.out.println(thread.getState());
            thread.sleep(300);
        }
    }
}
