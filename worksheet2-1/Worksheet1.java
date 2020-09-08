
/**
 * @author Hsin Yi Chiu
 * @version 2020-01-17
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 {

    // Exercise 1

    /**
     * a time complexity of O(n) to get the number of m^n
     * if m and n is negative number then will throw an exception
     * however if m = 0 and n is any positive number then the result should be 0
     * if m = 0 and n =0 then the result is 1 or nan, here we define the result as 1
     * others positive number with exponent number 0 will be 1
     * the method is to get the number of m^n
     * @param m the raising integer
     * @param n the exponent number
     * @return the result of the m^n
     */
    static int power(int m, int n) {


        if(m<0 || n<0) {
            throw new IllegalArgumentException("input needs to be positive number");
        }
        else{
            if(n==0){
                return 1;
            }
            else if(n==1){
                return m;
            }
            else{
                return m*power(m,n-1);
            }
        }
    }

    /**
     * a time complexity of O(log(n)) which is the faster way to get the number of m^n
     * if m and n is negative number then will throw an exception
     * however if m = 0 and n is any positive number then the result should be 0
     * if m = 0 and n =0 then the result is 1 or nan, here we define the result as 1
     * others positive number with exponent number 0 will be 1
     * the method is to get the number of m^n
     * @param m the raising integer
     * @param n the exponent number
     * @return the result of m^n
     */
    static int fastPower(int m, int n) {
        if(m<0 || n<0){
            throw new IllegalArgumentException("input needs to be positive number");
        }
        else{
            if(n==0){
                return 1;
            }
            else if(n==1){
                return m;
            }
            else if(n%2==0){
                return m*fastPower(m,n-1);
            }
            else{
                return (m*fastPower(m,n/2))*(fastPower(m,n/2));
            }
        }
    }

    // Exercise 2

    /**
     * To swap the negative number to positive and positive number to negative
     * 1. check if the list is empty
     * 2. base case--> to check if tail of the list is empty, if yes, return a empty list with the swapped number
     * 3. recursion--> if there are still numbers in the list, put the "-" in front to swap the number from positive
     * to negative and negative to positive
     *
     * @param a is a list to contain positive and negative number
     * @return the swap result
     */
    static List<Integer> negateAll(List<Integer> a) {

        if(a.isEmpty()){
            return new List();
        }

        if(a.getTail().isEmpty()){
            return new List(- a.getHead(),new List());
        }
        else{
            return new List(-a.getHead(), negateAll(a.getTail()));
            }
        }

    // Exercise 3

    /**
     * to check if the integer number x is included in the list and get the position of the x in the list as a
     * 1. if the list is empty then throw the exception
     * 2. base case --> if the number is equal to the first number get from list, then don't need to count again the position
     * thus return 0
     * 3. recursion --> if the number is different then count the position, which adds the 1 and return the tail of the list
     *
     * @param x is the integer number that we want to find in the list
     * @param a is the list
     * @return the position of x in the list a
     */
    static int find(int x, List<Integer> a) {

        // replace this by your code
        if(a.isEmpty()){
            throw new IllegalArgumentException("cannot find the value");
        }
        else{
            if(x==a.getHead()){
                return 0;
            }
            else{
                return 1+find(x, a.getTail());
            }
        }
    }

    // Exercise 4

    /**
     * to find if the list is all even number
     * 1. base case ==> if any number cannot be divided by 2 return false
     *              ==> if the tail is empty, which means all the number in the list can be divided by 2, therefore return true
     * 2. recursion ==> return the tail of the list if the head number can be divided
     * @param a is any real number if can be divided by 2 then it is even number
     * @return true for all the number is even, false for odd
     */
    static boolean allEven(List<Integer> a) {

        if(a.isEmpty()) {
            return true;
        }
        if(a.getHead() % 2 != 0){
            return false;
        }

        else{
//            return allEven(new List(a.getTail().getHead(),a.getTail().getTail()));
            return allEven(a.getTail());
        }
    }



    // Exercise 5

    /**
     * a method to find the even number by using recursion
     * 1.  if the number can be divided by 2 then it is a even number
     * 2.  if not, then continue the recursion
     * 3.  if all the number is odd then return empty list
     * @param a is the list to find the even number
     * @return all the even number in the list
     */
    static List<Integer> evenNumbers(List<Integer> a) {


            if(a.isEmpty()){
                return new List();
            }
            else if(a.getHead() % 2 != 0){
                return evenNumbers(a.getTail());
            }
            else {
                return new List(a.getHead(), evenNumbers(a.getTail()));
            }

    }

//    Exercise 6

    /**
     *Given a list of integers a to check if the list is a descending order list
     * 1. if first number is less than the second number --> false
     * 2. others --> true (base on the vacuum truth, the empty list is return true)
     * @param a is a list to check if it is a descending order list
     * @return true for a descending order list
     */
    static boolean sorted(List<Integer> a) {

        if(a.isEmpty()){
            return true;
        }
        else{
            if(a.getTail().isEmpty()){
                return true;
            }
            if(a.getHead()<a.getTail().getHead()){
                return false;
            }
            else {
                return sorted(a.getTail());
            }
        }
    }

    // Exercise 7

    /**
     * to merge two list to one list with descended order
     * 1. if a value get from list a is greater than b then the number from list a will be put into the new list as the first number
     * 2. however if the value from list b is greater than list a then b will be put into as the first number in the new list
     * 3. then we will do the recursion for the rest number in a/b( the tail number) and merge it with the rest list
     * 4. if a is empty first, which means the last number in b is smaller than in a, therefore will return the rest number in list b
     * 5. same situation for list b
     * @param a a list with sorted number
     * @param b a list with sorted number
     * @return the new list which merge the number from list a and b and has been sorted
     */
    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        if(a.isEmpty() && b.isEmpty()){
            return new List();
        }
        else {
            if(a.isEmpty()){
                return b;
            }
            else if(b.isEmpty()){
                return a;
            }
            else if(a.getHead()>b.getHead())
                return new List(a.getHead(), merge(a.getTail(),b));
            else {
                return new List(b.getHead(),merge(b.getTail(),a));
            }
        }


    }

    // Exercise 8

    /**
     * Given a sorted list a, this method must return a copy of the list a with all duplicate copies removed.
     * 1. if a is a empty list, then return a empty list
     * 2. base case==> if the tail is empty then return the last number in a
     * 3. recursion ==> if the number is not equal then return the head number of the list and the rest tail number
     *                  if the number is equal then only return the rest tail number
     * @param a a sorted descended list
     * @return
     */
    static List<Integer> removeDuplicates(List<Integer> a) {

        if(a.isEmpty()){
           return new List();
        }
        else{
            if(a.getTail().isEmpty()){
                return a;
            }
            else if(!a.getHead().equals(a.getTail().getHead())){
                return new List(a.getHead(), removeDuplicates(a.getTail()));
            }
            else {
                return removeDuplicates(a.getTail());
            }
        }


    }

    public static void main(String [] args){
//        long startTime=System.nanoTime();
//        System.out.println(power(2,3));
//       long endTime= System.nanoTime();
//       long totalTime = endTime-startTime;
//       System.out.println(totalTime);
//
//        startTime=System.nanoTime();
//        System.out.println(fastPower(2,3));
//        endTime= System.nanoTime();
//        totalTime = endTime-startTime;
//        System.out.println(totalTime);

//        List a = new List(10, new List());
//        System.out.println(find(0,a));
    }

}

