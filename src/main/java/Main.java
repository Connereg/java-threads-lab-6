import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newFixedThreadPool(1);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            executor.submit(new PrimeLogger(num));
        }
    }


}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        if (isPrime()) {
            System.out.println("this number is prime: " + num);
        }
        else {
            System.out.println("This number is NOT prime: " + num);
        }
    }

    public boolean isPrime() {
        if(num<=1)
        {
            return false;
        }
        for(int i=2 ;i<num/2; i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }


}
