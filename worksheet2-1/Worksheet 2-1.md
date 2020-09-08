## Worksheet 2-1

#### Exercise 1: Powers of integers (10%)
> static int power(int m, int n)
> static int fastPower(int m, int n)
> Code the two recursive algorithms discussed in class for raising integer m to the power of integer n (both non-negative). You can test them by checking to see if both the algorithms produce the same results.

#### Exercise 2: Negate a list (5%)
> static List<Integer> negateAll(List<Integer> a)
> Given a list of integers a, write a method that returns a new list with all the elements of a with sign negated, i.e., positive integers become negatives and negative integers become positives. Example:
>> [2, -5, 8, 0] ==> [-2, 5, -8, 0]

#### Exercise 3: Searching for an element (10%)
> static int find(int x, List<Integer> a) 
	Given an integer x which is assumed to be in the list a, write a method that returns the position of the first occurrence of x in a. Positions are counted as 0, 1, 2, . . .. If x does not appear in the list, you should throw an IllegalArgumentException. Examples:
>> x: 3   a: [7, 5, 3, 8]   ==>   2
>> x: 2   a: [7, 5, 3, 8]   ==> IllegalArgumentException

#### Exercise 4: Check for even numbers (10%)
> static boolean allEven(List<Integer> a)
	Given a list of integers a, return a boolean value indicating whether all its elements are even, i.e., divisible by 2.

> Think: What should be returned if the list is empty?

#### Exercise 5: Find the even numbers (10%)
>static List<Integer> evenNumbers(List<Integer> a)
	Given a list of integers a, return a new list which contains all the even elements of a. The elements should appear in the result in the same relative order as in a. Example:
>> [2, 3, -5, 8, -2]   ==>   [2, 8, -2]

#### Exercise 6: Sortedness (15%)
>static boolean sorted(List<Integer> a)
	Given a list of integers a, this method must return a boolean value indicating whether a is sorted in descending order. (There can be duplicate copies of elements. But, sortedness would require that all the duplicate copies would appear together.)

#### Exercise 7: Merging (20%)
> static List<Integer> merge(List<Integer> a, List<Integer> b)
	Given two sorted lists a and b, your method must return a new sorted list that contains all the elements of a and all the elements of b. Any duplicate copies of elements in a or b or their combination are retained. Examples:
>> a: [8, 5, 5, 2]   b: [9, 8, 7, 5]   ==>   [9, 8, 8, 7, 5, 5, 5, 2]
>> a: [8, 5, 5, 2]   b: [9]   ==>   [9, 8, 5, 5, 2]

#### Exercise 8: Remove duplicates (20%)
> static List<Integer> removeDuplicates(List<Integer> a)
	Given a sorted list a, this method must return a copy of the list a with all duplicate copies removed. Example:
>> [9, 8, 8, 7, 5, 5, 5, 2] ==> [9, 8, 7, 5, 2]
>(Hint: Please feel free to define helper functions!)
>
> The naturally immediate solution for this problem requires O(n2) time for producing its result. But, we are really only interested in using this function for the case of lists sorted in descending order. For sorted lists, the problem can be solved more efficiently, in O(n) time. To receive full credit, you should produce an O(n) program which works for sorted lists. We will only test the function for sorted lists.
