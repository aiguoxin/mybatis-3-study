import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * CyclicBarrier每执行1次，4个线程同时执行，总有一个执行
 */
class FizzBuzz {
	private int n;
	private CyclicBarrier barrier = new CyclicBarrier(4);

	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				printFizz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 == 0) {
				printBuzz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				printFizzBuzz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				printNumber.accept(i);
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strArray = input.split("=");
		FizzBuzz fizzBuzz =new FizzBuzz(Integer.valueOf(strArray[1]));

		new Thread(() -> {
			try {
				fizzBuzz.fizz(() -> System.out.print("fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				fizzBuzz.buzz(() -> System.out.print("buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();


		new Thread(() -> {
			try {
				fizzBuzz.number(x->System.out.println(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}

