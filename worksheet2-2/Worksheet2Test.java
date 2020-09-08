import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author HSIN YI CHIU
 * @version 2020-01-28
 * This class contains the test cases for Worksheet2 solutions.
 *
 */

public class Worksheet2Test {
    //1
    @Test
    public void testNegateAll(){
        // test the empty tree
        Tree<Integer> a= new Tree<>();
        Tree<Integer> testA = new Tree<>();
        assertEquals(Worksheet2.negateAll(a),testA);

        // test the tree with value
        Tree<Integer> b = new Tree<>(10,new Tree<>(5,new Tree<>(2),new Tree<>(7)),
                new Tree<>(20, new Tree<>(15),new Tree<>(17)));
        Tree<Integer> testB= new Tree<>(-10,new Tree<>(-20,new Tree<>(-17),new Tree<>(-15)),
                new Tree<>(-5, new Tree<>(-7),new Tree<>(-2)));
        assertEquals(Worksheet2.negateAll(b),testB);

        // only have left tree
        Tree<Integer> c = new Tree<>(10,new Tree<>(5,new Tree<>(2),new Tree<>(7)),
                new Tree<>());
        Tree<Integer> testC= new Tree<>(-10,new Tree<>(),new Tree<>(-5,new Tree<>(-7),new Tree<>(-2)));
        assertEquals(Worksheet2.negateAll(c),testC);

        // only have right tree
        Tree<Integer> d = new Tree<>(10,new Tree<>(),
                new Tree<>(20, new Tree<>(15),new Tree<>(17)));
        Tree<Integer> testD= new Tree<>(-10,
                new Tree<>(-20, new Tree<>(-17),new Tree<>(-15)),new Tree<>());
        assertEquals(Worksheet2.negateAll(d),testD);

    }
    //2
    @Test
    public void testAllEven(){
        // empty tree
        Tree<Integer> a= new Tree<>();
        assertTrue(Worksheet2.allEven(a));

        // even tree
        Tree<Integer> b = new Tree<>(10,new Tree<>(4,new Tree<>(2),new Tree<>(8)),
                new Tree<>(20, new Tree<>(16),new Tree<>(18)));
        assertTrue(Worksheet2.allEven(b));

        //odd tree
        Tree<Integer> c = new Tree<>(11,new Tree<>(3,new Tree<>(1),new Tree<>(7)),
                new Tree<>(21, new Tree<>(11),new Tree<>(9)));
        assertFalse(Worksheet2.allEven(c));

        // mix tree
        Tree<Integer> d = new Tree<>(12,new Tree<>(0,new Tree<>(2),new Tree<>(8)),
                new Tree<>(20, new Tree<>(10),new Tree<>(9)));
        assertFalse(Worksheet2.allEven(d));

        //single odd tree
        Tree<Integer> e = new Tree<>(11);
        assertFalse(Worksheet2.allEven(e));

        // single even tree
        Tree<Integer> f = new Tree<>(12);
        assertTrue(Worksheet2.allEven(f));
    }

    //3
    @Test
    public void testDepth(){
        // empty tree
        Tree<Integer> a = new Tree<>();
        int findA= 1;
        assertEquals(Worksheet2.depth(a,findA),-1);

        // value in the left tree
        Tree<Integer> b = new Tree<>(10, new Tree<>(4), new Tree<>(20));
        int findB= 4;
        assertEquals(Worksheet2.depth(b,findB),1);

        // value in the right tree
        Tree<Integer> c = new Tree<>(10, new Tree<>(), new Tree<>(20));
        int findC= 20;
        assertEquals(Worksheet2.depth(c,findC),1);

        // value is the root
        Tree<Integer> d = new Tree<>(10, new Tree<>(), new Tree<>());
        int findD= 10;
        assertEquals(Worksheet2.depth(d,findD),0);

        // value not in the tree
        Tree<Integer> e = new Tree<>(10, new Tree<>(5), new Tree<>(20));
        int findE= 0;
        assertEquals(Worksheet2.depth(e,findE),-1);

    }

    //4
    @Test
    public void testPreorder(){
        //a preorder list
        Tree a = new Tree(10,
                new Tree(6),
                new Tree(20));
        List testA = new List(10, new List(6, new List(20, new List())));
        assertEquals(Worksheet2.preorder(a),testA);

        //a left-subtree only tree
        Tree b = new Tree(10,
                new Tree(6, new Tree(3),new Tree(7)),
                new Tree());
        List testB= new List(10, new List(6, new List(3, new List(7, new List()))));
        assertEquals(Worksheet2.preorder(b),testB);

        //a right-subtree only tree
        Tree c = new Tree(10,
                new Tree(),
                new Tree(18, new Tree(15),new Tree(21)));
        List testC= new List(10, new List(18, new List(15, new List(21, new List()))));
        assertEquals(Worksheet2.preorder(c),testC);

        //root only
        Tree d = new Tree(10,
                new Tree(),
                new Tree());
        List testD= new List(10, new List());
        assertEquals(Worksheet2.preorder(d),testD);

        //empty tree
        Tree e = new Tree();
        List testE=  new List();
        assertEquals(Worksheet2.preorder(e),testE);
    }

    //5
    @Test
    public void testIsSearchTree(){
        // not binary tree(left>right)
        Tree a = new Tree(10,
                new Tree(20, new Tree(21), new Tree(15)),
                new Tree(6, new Tree(8), new Tree(3)));
        assertFalse(Worksheet2.isSearchTree(a));

        // a binary tree
        Tree b = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        assertTrue(Worksheet2.isSearchTree(b));

        // root only tree
        Tree c = new Tree(10);
        assertTrue(Worksheet2.isSearchTree(c));

        // empty tree
        Tree d = new Tree();
        assertTrue(Worksheet2.isSearchTree(d));

        // right tree only
        Tree e = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(22), new Tree(15)));
        assertFalse(Worksheet2.isSearchTree(e));

        // left tree only
        Tree f = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree());
        assertTrue(Worksheet2.isSearchTree(f));

        // a binary tree left subtree longer than right
        Tree g = new Tree(10,
                new Tree(6, new Tree(3, new Tree(1), new Tree()), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        assertTrue(Worksheet2.isSearchTree(g));

        // LR case
        Tree h = new Tree(10,
                new Tree(6, new Tree(8), new Tree()),
                new Tree());
        assertFalse(Worksheet2.isSearchTree(h));

        // RL case
        Tree i = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree()));
        assertTrue(Worksheet2.isSearchTree(i));
    }

    //7
    @Test
    public void testMax(){
        // 1 level tree
        Tree a = new Tree(10,new Tree(5),new Tree(20));
        assertEquals(Worksheet2.max(a),20);

        // 2 level tree
        Tree b = new Tree(10,new Tree(),new Tree(20, new Tree(15),new Tree(25)));
        assertEquals(Worksheet2.max(b),25);

        // empty right tree
        Tree c = new Tree(10,new Tree(5),new Tree());
        assertEquals(Worksheet2.max(c),10);

        //empty tree
        Tree d= new Tree();
        Throwable exception = assertThrows(IllegalArgumentException.class,()-> {Worksheet2.max(d);});
    }

    //8
    @Test
    public void testDelete(){
        // delete left leaf
        Tree a = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testA =new Tree(10,
                new Tree(6, new Tree(3), new Tree()),
                new Tree(20, new Tree(15), new Tree(21)));
        assertEquals(Worksheet2.delete(a,8),testA);

        // delete right leaf
        Tree b = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testB =new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree()));
        assertEquals(Worksheet2.delete(b,21),testB);

        // delete left subtree node
        Tree c = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testC =new Tree(10,
                new Tree(3, (new Tree()), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        assertEquals(Worksheet2.delete(c,6),testC);

        // delete right subtree node
        Tree d = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testD =new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(15, new Tree(), new Tree(21)));
        assertEquals(Worksheet2.delete(d,20),testD);

        // delete root
        Tree e = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testE =new Tree(8,
                new Tree(6, new Tree(3), new Tree()),
                new Tree(20, new Tree(15), new Tree(21)));
        assertEquals(Worksheet2.delete(e,10),testE);

        // one left tree only -- delete leaf
        Tree f = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree());
        Tree testF =new Tree(10,
                new Tree(6, new Tree(3), new Tree()),
                new Tree());
        assertEquals(Worksheet2.delete(f,8),testF);


        // one left tree only -- delete node
        Tree g = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree());
        Tree testG =new Tree(10,
                new Tree(3, new Tree(), new Tree(8)),
                new Tree());
        assertEquals(Worksheet2.delete(g,6),testG);

        // one left tree only--delete root
        Tree h = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree());
        Tree testH =new Tree(6,
                new Tree(3, new Tree(), new Tree(8)),
                new Tree());
        assertEquals(Worksheet2.delete(h,10),testH);

        // one right tree only--delete leaf
        Tree i = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testI =new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree()));
        assertEquals(Worksheet2.delete(i,21),testI);

        // one right tree only--delete node
        Tree j = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testJ =new Tree(10,
                new Tree(),
                new Tree(15, new Tree(), new Tree(21)));
        assertEquals(Worksheet2.delete(j,20),testJ);

        // one right tree only--delete root
        Tree k = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree(21)));
        Tree testK =new Tree(20,
                new Tree(),
                new Tree(15, new Tree(), new Tree(21)));
        assertEquals(Worksheet2.delete(k,10),testK);

        // RL case
        Tree l = new Tree(10,
                new Tree(),
                new Tree(20, new Tree(15), new Tree()));
        Tree testL =new Tree(10,
                new Tree(),
                new Tree(15, new Tree(), new Tree()));
        assertEquals(Worksheet2.delete(l,20),testL);

        // LL case
        Tree m = new Tree(10,
                new Tree(6, new Tree(), new Tree(8)),
                new Tree());
        Tree testM =new Tree(10,
                new Tree(8, new Tree(), new Tree()),
                new Tree());
        assertEquals(Worksheet2.delete(m,6),testM);

        //THROW EXCEPTION
//        Tree n = new Tree(10,
//                new Tree(20, new Tree(21), new Tree(15)),
//                new Tree(6, new Tree(8), new Tree(3)));
//        Throwable exception = assertThrows(IllegalArgumentException.class,()-> {Worksheet2.delete(n,8);});
    }

    //9
    @Test
    public void testIsBalanceHeight(){
        Tree a = new Tree(10,
                new Tree(6, new Tree(3), new Tree(8)),
                new Tree(20, new Tree(15), new Tree(21)));
        assertTrue(Worksheet2.isHeightBalanced(a));

        Tree b = new Tree(10,
                new Tree(6, new Tree(3, new Tree(2),new Tree()), new Tree(8)),
                new Tree());
        assertFalse(Worksheet2.isHeightBalanced(b));

        Tree c = new Tree(10,
                new Tree(5, new Tree(3, new Tree(2), new Tree()),new Tree()),
                new Tree());
        assertFalse(Worksheet2.isHeightBalanced(c));

        Tree d = new Tree(10,
                new Tree(),
                new Tree(20,new Tree(18,new Tree(15),new Tree()),new Tree()));
        assertFalse(Worksheet2.isHeightBalanced(d));

        Tree e = new Tree(10,
                new Tree(5, new Tree(),new Tree()),
                new Tree());
        assertTrue(Worksheet2.isHeightBalanced(e));

        Tree f = new Tree(10,
                new Tree(),
                new Tree(20,new Tree(18,new Tree(),new Tree()),new Tree()));
        assertFalse(Worksheet2.isHeightBalanced(f));

        Tree g= new Tree();
        assertTrue(Worksheet2.isHeightBalanced(g));
    }
    //10 insert
    @Test
    public void testInsert(){
        //RR(LEFT TREE EMPTY)
        Tree a= new Tree(12,new Tree(),new Tree(13, new Tree(), new Tree()));
        Tree testA=new Tree<>(13,new Tree<>(12), new Tree<>(14));
        assertEquals(testA,Worksheet2.insertHB(a,14));

        // LL(RIGHT TREE EMPTY)
        Tree b = new Tree(12, new Tree(10, new Tree(), new Tree()),new Tree());
        Tree testB = new Tree(10, new Tree(8),new Tree(12));
        assertEquals(testB, Worksheet2.insertHB(b,8));

        //LL
        Tree<Integer> c =new Tree(40, new Tree(35,new Tree(34),new Tree()), new Tree(45));
        Tree testC= new Tree(40, new Tree(34,new Tree(20),new Tree(35)),new Tree(45));
        assertEquals(testC, Worksheet2.insertHB(c,20));

        //LR
        Tree<Integer> c1 =new Tree(40, new Tree(30,new Tree(34),new Tree(36)), new Tree(45));
        Tree testC1 = new Tree(36, new Tree(30, new Tree(34),new Tree()),new Tree(40, new Tree(37), new Tree(45)));
        assertEquals(testC1,Worksheet2.insertHB(c1,37));


        //RR
        Tree d = new Tree(45, new Tree(30), new Tree(60, new Tree(52),new Tree(61)));
        Tree testD = new Tree(60, new Tree(45,new Tree(30), new Tree(52)),
                new Tree<>(61,new Tree(),new Tree(62)));
        assertEquals(testD,Worksheet2.insertHB(d,62));

        //RL
        Tree d1 = new Tree(45, new Tree(30), new Tree(60, new Tree(52),new Tree(61)));
        Tree testD1= new Tree(52,new Tree(45,new Tree(30),new Tree(50)),new Tree(60, new Tree(), new Tree(61)));
        assertEquals(testD1,Worksheet2.insertHB(d1,50));

        // x= getValue
        Tree d2 = new Tree(45, new Tree(30), new Tree(60, new Tree(52),new Tree(61)));
        Tree testD2 = new Tree(45, new Tree(30), new Tree(60, new Tree(52),new Tree(61)));
        assertEquals(testD2,Worksheet2.insertHB(d2,60));

        // complicate one
        Tree<Integer> e = new Tree(7,
                new Tree(4, new Tree(2), new Tree()),
                new Tree(11, new Tree(10), new Tree(15, new Tree(14), new Tree(17))));
        Tree<Integer> testE = new Tree(7, new Tree(4, new Tree(2), new Tree()),
                new Tree(14, new Tree(11, new Tree(10), new Tree(12)),
                        new Tree(15, new Tree(), new Tree(17))));
        assertEquals(testE,Worksheet2.insertHB(e,12));
    }

    @Test
    public void testDeletion(){
        Tree a= new Tree(12,new Tree(),new Tree(13, new Tree(), new Tree(14)));
        Tree testA = new Tree(13,new Tree(), new Tree(14));
        assertEquals(testA,Worksheet2.deleteHB(a,12));

       // delete the number is not in the tree
        Tree<Integer> b = new Tree(7,
                new Tree(4, new Tree(2), new Tree()),
                new Tree(11, new Tree(10), new Tree(15, new Tree(14), new Tree(17))));
        assertEquals(b,Worksheet2.deleteHB(b,1));

        Tree d1 = new Tree(7, new Tree(4, new Tree(2), new Tree()),
                new Tree(14, new Tree(11, new Tree(10), new Tree(12)),
                        new Tree(15, new Tree(), new Tree(17))));
        Tree testC = new Tree(7, new Tree(4, new Tree(2), new Tree()),
                new Tree<>(12, new Tree<>(11, new Tree<>(10), new Tree<>()), new Tree<>(15,
                        new Tree<>(), new Tree<>(17))));
        assertEquals(testC,Worksheet2.deleteHB(d1,14));

    }

}