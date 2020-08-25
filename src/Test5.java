import org.omg.PortableServer.THREAD_POLICY_ID;

/*
*
*       另一种线程中断的方法  interrupt
*
*
*Thread.currentThread().isInterrupted()
*调用interrupt方法 比较激烈
* thread.interrupt();
* */
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("lalalalalalala");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //如果没有break 等主线程运行到thread.interrupt();这里的时候
                        //输出System.out.println("lalalalala结束");
                        //还不会停止 继续一直打印System.out.println("lalalalalalala");
                        //加上break之后 当铺捉到异常直接结束循环,线程也就结束了
                        break;
                    }
                }
                System.out.println("lalalalala结束");
            }
        };
        thread.start();

        //sleep方法意思是当程序执行到这里时,会停下来1000ms=1s
        //sleep方法里面写的1000ms 但其实真正运行是等待的不一定是1000 误差一般<10ms
        //加入sleep的原因是:多线程之间是抢占式运行的 如果不规定sleep那么
        //主线程是执行thread.interrupt();还是执行while循环都是不一定的
        Thread.sleep(1000);
        System.out.println("对方不是lalalala");
        thread.interrupt();
        //相当于抛出一个异常
    }



}
