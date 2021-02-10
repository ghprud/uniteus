package uniteus;

import java.util.*;

public class Main{

	public static void main(String[] args){
		Prime prime = new Prime();

		System.out.println("----- tests (start)-------");

		System.out.println("checking the size of the prime numbers generated");
		boolean isNumberCorrect4True = prime.getNPrimesBasic(10).size() == 10;
		boolean isNumberCorrect0False = prime.getNPrimesBasic(10).size() == 0;
		boolean isNumberCorrect0True = prime.getNPrimesBasic(0).size() == 0;
		boolean isNumberCorrectNegTrue = prime.getNPrimesBasic(-1) == null;
		boolean isOnlyOnePrimeNumGen = prime.getNPrimesBasic(1).size() == 1;


		System.out.println("Is size correct for first 10 primes? --> " + isNumberCorrect4True);
		System.out.println("Is size correct for first 10 primes? --> " + isNumberCorrect0False);
		System.out.println("Is size correct for 0 primes? --> " + isNumberCorrect0True);
		System.out.println("Is size correct for negative input? --> " + isNumberCorrectNegTrue);
		System.out.println("Is size correct for first 1 prime number? --> " + isOnlyOnePrimeNumGen);



		boolean isPrime1 = prime.isPrime(1);
		boolean isPrime2 = prime.isPrime(2);
		boolean isPrimeNeg1 = prime.isPrime(-1);
		boolean isPrimeZero = prime.isPrime(0);
		boolean isPrime28 = prime.isPrime(28);
		boolean isPrime27 = prime.isPrime(27);
		boolean isPrime29 = prime.isPrime(29);

		System.out.println("Is 1 a prime nummber? --> " + isPrime1);
		System.out.println("Is 2 a prime number? --> " + isPrime2);
		System.out.println("Is -1 a prime number? --> " + isPrimeNeg1);
		System.out.println("Is 0 a prime nummber? --> " + isPrimeZero);
		System.out.println("Is 28 a prime number? --> " + isPrime28);
		System.out.println("Is 27 a prime number? --> " + isPrime27);
		System.out.println("Is 29 a prime number? --> " + isPrime29);


		Integer[][] primeTable = prime.buildPrimeMultTable(prime.getNPrimesBasic(15));

		boolean isNumber29 = (29 == primeTable[0][10]);
		boolean isNumber47 = (47 == primeTable[0][15]);
		boolean isNumber6 = (6 == primeTable[1][2]);

		System.out.println("Is number 29? --> " + isNumber29);
		System.out.println("Is number 47? --> " + isNumber47);
		System.out.println("Is number 6? --> " + isNumber6);

		System.out.println("------- tests (end) ---------");

		/*System.out.println(prime.getUptoNPrimes(10).toString());
        System.out.println(prime.getNPrimesBasic(10).toString());

        System.out.println(prime.buildPrimeMultTable(prime.getUptoNPrimes(10)).toString());*/

        prime.printMultiplicationChart(prime.buildPrimeMultTable(prime.getNPrimesBasic(15)));

        System.out.println("next chart");
        prime.printMultiplicationChart(prime.buildPrimeMultTable(prime.getNPrimesBasic(20)));
	}
}