package leetcode.simple;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class PrimeNo {

    public int countPrimeSetBits(int left, int right) {
        int total=0;
        for(int i=left;i<=right;i++){
            int oneBitCount = Integer.bitCount(i);
            if(isPrime(oneBitCount)){
                total++;
            }
        }
        return total;
    }

    private boolean isPrime(int number){
        if(number <=1 || number > 2 && number%2 == 0){
            return false;
        }else if(number ==2){
             return true;
        }

        for(int i=3;i<=Math.sqrt(number);i+=2){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(countPrimeSetBits(10,15));
    }
}
