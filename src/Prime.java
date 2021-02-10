package uniteus;

import java.util.*;

public class Prime{

  // can we build a heuristics based algo to get the first N primes?
  // the below code only gets upto N primes, not the firts N primes..
  // there are a maximum of 4 primes between 1 to 10, or 11 to 20,
  // So, the first 10 primes will be in 1 to 30 range..
  // likewise, the first 15 primes will be in 1 to 50 range..
  // If we can get the upper limit, we can use the below method to generate only 
  // those many prime numbers...
  // Can we find a mathematical formula that given a number, can give
  public static ArrayList<Integer> getUptoNPrimes(int n){
    if ( n < 0){
        return null;
    }

    ArrayList<Integer> nPrimes = new ArrayList<>();
    boolean prime[] = new boolean[n + 1];        
    
    for (int i = 2; i <= n; i++){
      prime[i] = true;
    }

    for (int i = 2; i <= n; i++){
      if (prime[i] == true){
        //updating all the multiples
        for (int j = i * i; j <= n; j += i){
          prime[j] = false;
        }
      }
    }
    
    for (int i = 2; i <=n; i++){
      if(prime[i])
        nPrimes.add(i);
    }

    return nPrimes;
  }

  public static boolean isPrime(int n){
      // Check if number is less than
      // equal to 1
      if (n <= 1)
          return false;

      // Check if number is 2 or 3 or 5 or 7 or 11
      else if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11)
          return true;

      // Check if n is a multiple of 2 or 3 or 5 or 7 or 11
      else if (n % 2 == 0 || 
                n % 3 == 0 || 
                n % 5 == 0 || n % 7 == 0 ||
                n % 11 == 0) // cutting down the number of checks...
          return false;

      // just check the odds
      for (int i = 3; i <= Math.sqrt(n); i += 2) {
          if (n % i == 0)
              return false;
      }
      return true;
  }

  public static ArrayList<Integer> getNPrimesBasic(int n){
    if (n < 0){
        return null;
    }

    ArrayList<Integer> nPrimes = new ArrayList<>();
    int count = 0;
    int num = 2;

    while(count < n){
        if(isPrime(num)){
            nPrimes.add(num);
            count++;
        }
        num++;
    }  

   return nPrimes;
  } 

  public static Integer[][] buildPrimeMultTable(ArrayList<Integer> nPrimes){
    Integer[][] primeTable = new Integer[nPrimes.size()+1][nPrimes.size()+1];

    primeTable[0][0] = 1; 

    for (int row = 1; row <= nPrimes.size(); row++){
        primeTable[row][0] = nPrimes.get(row-1);
    }

    for (int col = 1; col <= nPrimes.size(); col++){
        primeTable[0][col] = nPrimes.get(col-1);
    }

   for (int row = 1; row <= nPrimes.size(); row++){
        for (int col = 1; col <= nPrimes.size(); col++){
            primeTable[row][col] = primeTable[row][0] * primeTable[0][col];
        }
    }

    return primeTable;
  }

  public static void printMultiplicationChart(Integer[][] primeTable){
    for (int row = 0; row < primeTable.length; row++){
        for (int col = 0; col < primeTable[0].length; col++){
            System.out.print(primeTable[row][col] + " ");
        }
        System.out.println();
    }
  }
}