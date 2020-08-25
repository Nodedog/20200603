
/*
*
*
*           线程中断
* 第一种温和的方式:设置一个boolean值 控制 输出的结束
*
*
*
* */
public class Test4 {
    private static boolean isquit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (!isquit){
                    System.out.println("lalalalalalalalal");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("lalala结束");
            }
        };
        thread.start();

        Thread.sleep(1000);
        System.out.println("对方不是lalala 赶紧结束");
        isquit = true;
    }


}
