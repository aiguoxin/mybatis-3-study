import java.util.Scanner;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private volatile int state = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (i % 2 != 0) {
                state = 2;
            } else {
                {
                    state = 1;
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i=i+2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <=n; i=i+2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split("=");
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(Integer.valueOf(strArray[1]));
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(x->System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(x->System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(x->System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}