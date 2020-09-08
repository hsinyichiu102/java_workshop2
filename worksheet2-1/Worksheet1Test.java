import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
* @author Hsin Yi Chiu
* @version 2020-01-25
* Worksheet1 test
*/

class Worksheet1Test {

    //1
    @Test
    public void testPower(){
        // test 2^3 =8 of power and fastPower method
        int a= Worksheet1.power(2,3);
        int b= Worksheet1.fastPower(2,3);
        assertEquals(a,8);
        assertEquals(a,b);

        // as defined, 0^0 =1
        int c = Worksheet1.fastPower(0,0);
        int d= Worksheet1.power(0,0);
        assertEquals(c,1);
        assertEquals(c,d);

        // as defined, 0^1=0
        int e= Worksheet1.power(0,1);
        int f= Worksheet1.fastPower(0,1);
        assertEquals(e,0);
        assertEquals(e,f);

        // test the large exponent number for power and fastPower method
        int g = Worksheet1.power(2,10);
        int h = Worksheet1.fastPower(2,10);
        assertEquals(g,1024);
        assertEquals(g,h);

        //n^1 = n
        int i= Worksheet1.power(3,1);
        int j= Worksheet1.fastPower(3,1);
        assertEquals(i,3);
        assertEquals(i,j);

        // test if the exception is correct if the exponent or the number is negative
        Throwable exception = assertThrows(IllegalArgumentException.class,()-> {Worksheet1.power(-2,1);});
        Throwable exception1 = assertThrows(IllegalArgumentException.class,()-> {Worksheet1.fastPower(2,-1);});

    }

    //2
    @Test
    public void testNegateAll(){

        // test the positive to negative
        List<Integer> test= new List(-9, new List(-4, new List(-3,
                new List(-2, new List()))));
        List<Integer> checkTest= new List(9, new List(4, new List(3,
                new List(2, new List()))));
        assertEquals(Worksheet1.negateAll(test),checkTest);

        // test the negative to positive
        test= new List(-10, new List(-111, new List(-55,
                new List(-2, new List()))));
        checkTest= new List(10, new List(111, new List(55,
                new List(2, new List()))));
        assertEquals(Worksheet1.negateAll(test),checkTest);

        // test the mixed list
        test= new List(-1, new List(2, new List(-3,
                new List(0, new List()))));
        checkTest= new List(1, new List(-2, new List(3,
                new List(0, new List()))));
        assertEquals(Worksheet1.negateAll(test),checkTest);

        // only single positive number inside
        test= new List(1, new List());
        checkTest= new List(-1, new List());
        assertEquals(Worksheet1.negateAll(test),checkTest);

        // only single negative number inside
        test= new List(-1, new List());
        checkTest= new List(1, new List());
        assertEquals(Worksheet1.negateAll(test),checkTest);
    }


    @Test
    public void testNegateAll1(){
        // test the empty list
        List<Integer> test= new List();
        List<Integer> checkTest= new List();
        assertEquals(Worksheet1.negateAll(test),checkTest);

        // test if only 0 in the list
        test= new List(0, new List());
        checkTest= new List(0, new List());
        assertEquals(Worksheet1.negateAll(test),checkTest);

    }

    //3
    @Test
    public void testFind(){
        // test if the value is in the list
        List<Integer> test= new List(9, new List(4, new List(3,
                new List(-2, new List()))));
        int actualPosition=0;
        assertEquals(Worksheet1.find(9,test),actualPosition);

        // test if the value is not in the list
        Throwable exception = assertThrows(IllegalArgumentException.class,()-> {Worksheet1.find(2,test);});
    }

    //4
    @Test
    public void testAllEven(){

        // all even list
        List test= new List(0, new List(-2, new List(-4,
                new List(2, new List()))));
        assertTrue(Worksheet1.allEven(test));

        // all odd list
        test= new List(1, new List(-1, new List(-5,
                new List(1, new List()))));
        assertFalse(Worksheet1.allEven(test));

        // mixed list
        test= new List(-2, new List(1, new List(5,
                new List(2, new List()))));
        assertFalse(Worksheet1.allEven(test));

        // if only 0
        test= new List(0,new List());
        assertTrue(Worksheet1.allEven(test));

        // if empty list
        List test1= new List();
        assertTrue(Worksheet1.allEven(test1));

        //single even element
        test= new List(2,new List());
        assertTrue(Worksheet1.allEven(test));

        //single odd element
        test= new List(1,new List());
        assertFalse(Worksheet1.allEven(test));
    }

    //5
    @Test
    public void testEvenNumber(){
        // all even list
        List test= new List(-10, new List(-112, new List(-56,
                new List(2, new List()))));
        List check=new List(-10, new List(-112, new List(-56,
                new List(2, new List()))));
        assertEquals(Worksheet1.evenNumbers(test),check);

        // all odd list
        test= new List(-11, new List(111, new List(5,
                new List(1, new List()))));
        check=new List();
        assertEquals(Worksheet1.evenNumbers(test),check);

        // mix list
        test= new List(10, new List(1, new List(6,
                new List(3, new List()))));
        check=new List(10, new List(6,new List()));
        assertEquals(Worksheet1.evenNumbers(test),check);

        // with 0 list
        test= new List(10, new List(1, new List(0,
                new List(3, new List()))));
        check=new List(10, new List(0,new List()));
        assertEquals(Worksheet1.evenNumbers(test),check);

        // if list is empty
        test= new List();
        check=new List();
        assertEquals(Worksheet1.evenNumbers(test),check);

        //single even list
        test= new List(10,  new List());
        check=new List(10, new List());
        assertEquals(Worksheet1.evenNumbers(test),check);

        //single odd list
        test= new List(1,  new List());
        check=new List();
        assertEquals(Worksheet1.evenNumbers(test),check);
    }

    //6
    @Test
    public void testSorted(){
        // a positive descended list
        List test= new List(10, new List(9, new List(8,
                new List(7, new List()))));
        assertTrue(Worksheet1.sorted(test));

        // a negative descended list
        test= new List(-2, new List(-3, new List(-4,
                new List(-5, new List()))));
        assertTrue(Worksheet1.sorted(test));

        // a mixed descended list
        test= new List(4, new List(3, new List(-4,
                new List(-5, new List()))));
        assertTrue(Worksheet1.sorted(test));

        // a non sorted mix number
        test= new List(-3, new List(1, new List(5,
                new List(6, new List()))));
        assertFalse(Worksheet1.sorted(test));

        // a empty list
        test= new List();
        assertTrue(Worksheet1.sorted(test));

        //single element
        test= new List(4,  new List());
        assertTrue(Worksheet1.sorted(test));
    }

    //7
    @Test
    public void testMerge(){
        // empty list for both a & b
        List testA= new List();
        List testB= new List();
        List check= new List();
        assertEquals(Worksheet1.merge(testA,testB),check);

        // sorted list a which numbers are bigger than b
        testA = new List(10, new List(8, new List()));
        testB = new List(7, new List(6, new List()));
        check= new List(10,new List(8, new List(7, new List( 6, new List()))));
        assertEquals(Worksheet1.merge(testA,testB),check);

        // sorted list a which numbers are smaller than b
        testA = new List(3, new List(2, new List()));
        testB = new List(7, new List(6, new List()));
        check= new List(7,new List(6, new List(3, new List (2, new List()))));
        assertEquals(Worksheet1.merge(testA,testB),check);

        // sorted list mixed number
        testA = new List(5, new List(2, new List()));
        testB = new List(4, new List(3, new List()));
        check= new List(5,new List(4, new List(3, new List (2, new List()))));
        assertEquals(Worksheet1.merge(testA,testB),check);

        // sorted list mixed negative number
        testA = new List(5, new List(-2, new List()));
        testB = new List(4, new List(-3, new List()));
        check= new List(5,new List(4, new List(-2, new List (-3, new List()))));
        assertEquals(Worksheet1.merge(testA,testB),check);

        // single element in both list
        testA = new List(5, new List());
        testB = new List(4, new List());
        check= new List(5,new List(4,  new List()));
        assertEquals(Worksheet1.merge(testA,testB),check);

        // one empty list
        testA = new List();
        testB = new List(4, new List());
        check= new List(4,new List());
        assertEquals(Worksheet1.merge(testA,testB),check);

    }

    //8
    @Test
    public void testRemove(){
        // if a is empty list
        List a = new List();
        List check = new List();
        assertEquals(Worksheet1.removeDuplicates(a),check);

        //if no duplicate number in the list
        a = new List(5, new List(-2, new List()));
        check= new List(5, new List(-2, new List()));
        assertEquals(Worksheet1.removeDuplicates(a),check);

        // with duplicate number
        a = new List(5, new List(5, new List(4, new List(4, new List()))));
        check= new List(5, new List(4, new List()));
        assertEquals(Worksheet1.removeDuplicates(a),check);

        // a single duplicate number
        a = new List(5, new List());
        check= new List(5,  new List());
        assertEquals(Worksheet1.removeDuplicates(a),check);

        // big number test
        a = new List(111, new List(111, new List(10, new List(5, new List()))));
        check= new List(111, new List(10, new List(5, new List())));
        assertEquals(Worksheet1.removeDuplicates(a),check);
    }
}