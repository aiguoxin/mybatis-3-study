/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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

