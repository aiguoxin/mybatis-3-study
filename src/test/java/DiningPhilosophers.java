import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    private ReentrantLock[] lockList = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};

    //限制 最多只有4个哲学家去持有叉子
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = (philosopher + 1) % 5;	//左边的叉子 的编号
        int rightFork = philosopher;	//右边的叉子 的编号

        eatLimit.acquire();	//限制的人数 -1

        lockList[leftFork].lock();	//拿起左边的叉子
        lockList[rightFork].lock();	//拿起右边的叉子

        pickLeftFork.run();	//拿起左边的叉子 的具体执行
        pickRightFork.run();	//拿起右边的叉子 的具体执行

        eat.run();	//吃意大利面 的具体执行

        putLeftFork.run();	//放下左边的叉子 的具体执行
        putRightFork.run();	//放下右边的叉子 的具体执行

        lockList[leftFork].unlock();	//放下左边的叉子
        lockList[rightFork].unlock();	//放下右边的叉子

        eatLimit.release();//限制的人数 +1
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split("=");
        int n = Integer.valueOf(strArray[1]);

        DiningPhilosophers philosophers = new DiningPhilosophers();

        for(int i = 0; i< 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    philosophers.wantsToEat(finalI,
                            () -> System.out.print(String.format("[%d,1,1]", finalI)),
                             () -> System.out.print(String.format("[%d,2,1]", finalI)),
                            () -> System.out.print(String.format("[%d,0,3]", finalI)),
                            () -> System.out.print(String.format("[%d,1,2]", finalI)),
                            () -> System.out.print(String.format("[%d,2,2]", finalI)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
