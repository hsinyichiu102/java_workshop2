
/**
 * @author HSIN YI CHIU
 * @version 2020-01-27
 */

public class Worksheet2 implements Worksheet2Interface {


	// Exercise 1

	/**
	 * Given a tree of integers a, write a method that returns a new tree containing all the elements of
	 * a with their sign negated, i.e., positive integers become negative and negative integers become
	 * positive.
	 * 1. if the tree is empty, then return the tree self
	 * 2. if the tree is not empty, then go to else and get the value and turn the negative to positive and positive to negative
	 * @param a is a integer tree
	 * @return the opposite sign negated tree
	 */

	static Tree<Integer> negateAll(Tree<Integer> a) {
		if(a.isEmpty()){
			return a;
		}
		else {
			System.out.println(a.getValue());
			return new Tree(-a.getValue(), negateAll(a.getRight()), negateAll(a.getLeft()));
			}
		}


	// Exercise 2

	/**
	 * Given a tree of integers a, return a boolean value indicating whether all the values in its nodes are even,
	 * i.e., divisible by 2.
	 * 1. if the value in the tree cannot be divided by 2, then the whole tree is not even, thus return false
	 * 2. if the last value in the tree has no subtree then we can say the tree is all even number inside
	 * 		thus return true.
	 * @param a is the tree including all the value
	 * @return if all even return true, others false
	 */

	static boolean allEven(Tree<Integer> a) {

	if(a.isEmpty()){
		return true;
	}

	if(a.getValue()%2!=0){
		return false;
	}

	else {
		return allEven(a.getLeft())
				&& allEven(a.getRight());
	}

	}

	// Exercise 3

	/**
	 * to find the integer in which level of the tree
	 * if the integer is not in the tree, which means the integer is not in the left and right tree,
	 * then return -1
	 * Otherwise, we can know that the integer must be in the left or right tree
	 * if the integer is in left tree, which means we can assume that the right subtree is empty, then the right subtree return -1
	 * thus the return integer in left subtree must be greater than -1, then we only need to do the recursion of left tree
	 * for the opposite situation is same
	 * @param a is a binary tree
	 * @param x is the integer to be found in the tree
	 * @return the depth/ level where the integer is
	 */
	static int depth(Tree<Integer> a, int x) {
		if(a.isEmpty()){
			return -1;
		}
		if(a.getValue()==x){
			return 0;
		}
		else if(depth(a.getLeft(),x)== depth(a.getRight(),x)){
			return -1;
		}
		else if(depth(a.getLeft(),x)>depth(a.getRight(),x)){
			return 1+depth(a.getLeft(),x);
		}
		else {
			return 1+depth(a.getRight(),x);
		}
	}

	// Exercise 4

	/**
	 * traversing the whole value in the tree and put it into a new List
	 * however, the object got from the method preorder is an node from the tree, thus a helper(append) need to be use
	 * to get the item(value, string...) in the node
	 * @param a is a generic tree
	 * @param <E> is a generic type
	 * @return a generic list with all the traversed node
	 */

	static <E> List<E> preorder(Tree<E> a) {

		if(a.isEmpty()){
			return new List();
		}
		else {
			return append(new List(a.getValue(),preorder(a.getLeft())),(preorder(a.getRight())));
		}

	}

	/**
	 * to append the two list into one
	 * @param l the first list
	 * @param r the second list
	 * @param <E> a generic type
	 * @return an appended list
	 */
	static <E> List<E> append(List l, List r){
		if(l.isEmpty()){
			return r;
		}
		else {
			return new List(l.getHead(), append(l.getTail(),r));
		}
	}




	// Exercise 5

	/**
	 * to check if the tree is a binary tree
	 * @param a is a integer tree
	 * @return true if it is a binary tree
	 */

	static boolean isSearchTree(Tree<Integer> a) {
		if(a.isEmpty()){
			return true;
		}
		else{
			return sorted(inorder(a));
		}
	}

	/**
	 * to get an inorder list from the tree
	 * @param t is a integer tree
	 * @return an inorder list
	 */
	public static List inorder(Tree<Integer> t) {
		if (t.isEmpty())
			return new List();
		else {
			return append(inorder(t.getRight()),new List(t.getValue(),inorder(t.getLeft())));
		}
	}

	/**
	 * to check if the list is an in-oder list
	 * @param s is an appended list
	 * @return true if it is a in-order list
	 */
	public static boolean sorted(List<Integer> s){
		if(s.isEmpty()){
			return true;
		}
		if(s.getTail().isEmpty()){
			return true;
		}
		if(s.getHead()<s.getTail().getHead()){
			return false;
		}
		else {
			return sorted(s.getTail());
		}
	}



	// Exercise 6

	/**
	 * Given a binary search tree of integers a,
	 * write a method that prints the values stored in it in descending order.
	 * Do this without building a separate list of the values.
	 * @param a is a binary search tree
	 */
	static void printDescending(Tree<Integer> a) {
		if(a.isEmpty()){
			return;
		}
		else {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());

		}
	}

	// Exercise 7

	/**
	 * as a binary search tree, the big number is always in the right
	 * then, the deepest right leaf is the max number in the tree
	 * if the tree is empty then throw the exception
	 * @param a is a integer tree to find the max number
	 * @return the max number in the tree
	 */

	static int max(Tree<Integer> a) {
		if(a.isEmpty()){
			throw new IllegalArgumentException("empty tree");
		}
		if(a.getRight().isEmpty()){
			return a.getValue();
		}
		else{
			return max(a.getRight());
		}
	}

	// Exercise 8

	/**
	 * delete the value from the tree
	 * 1. check if the tree is a search tree; if yes, return exception
	 * 2. if the found value is less then the getValue from tree, then search the left tree only;
	 * 		others, checking the right tree
	 * 3. if right tree is empty then just return left tree
	 * @param a is a search tree
	 * @param x the value that need to be deleted
	 * @return the new search tree without x value
	 */

	static Tree<Integer> delete(Tree<Integer> a, int x) {

		if(a.isEmpty()){
			return a;
		}
		if(x<a.getValue()){
			return new Tree(a.getValue(),delete(a.getLeft(),x),
					a.getRight());
		}
		if(x>a.getValue()){
			return new Tree(a.getValue(),a.getLeft(),
					delete(a.getRight(),x));
		}
		if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
			return new Tree();
		}

		if(a.getRight().isEmpty()&& !a.getLeft().isEmpty()){
			return new Tree<>(a.getLeft().getValue(),
					delete(a.getLeft(),a.getLeft().getValue()),
					a.getRight());
			}
		if (!a.getRight().isEmpty()&& a.getLeft().isEmpty()){
			return new Tree(a.getRight().getValue(),
					a.getLeft(),
					delete(a.getRight(),a.getRight().getValue()));
			}
		return
				new Tree(max(a.getLeft()),delete(a.getLeft(),max(a.getLeft())),
						delete(a.getRight(),max(a.getLeft())));
		}



	// Exercise 9

	/**
	 * a height balanced tree, which the absolute different height between left tree and right tree is less than 1
	 * @param a is a tree
	 * @param <E> the generic type
	 * @return true if the tree is a height balance tree
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {

		if(a.isEmpty()){
			return true;
		}
		int left_height = a.getLeft().getHeight();
		int right_height = a.getRight().getHeight();
		if(Math.abs(left_height-right_height)>1){
			return false;
		}
		else {
			return true;
		}

	}
	// Exercise 10

	/**
	 * insert a number into the tree and get the AVL tree
	 * 1. if x is greater than a.getValue, then the value can only go to right subtree
	 * 2. if there is no value greater/smaller than x, then we can insert the value into the place
	 * 3. go to the method[rotation] to check if it is a AVL tree,
	 * 4. if no, rotate the position of the value
	 * 5. return the updated AVL tree
	 * 6. need to check again if the tree is AVL tree, thus the whole return result will be checked again by [rotation]
	 * @param a is the HBT tree
	 * @param x the value that is inserted
	 * @return the updated HBT with the x value inside
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if(a.isEmpty()){
			return new Tree<>(x);
		}
		if(x<a.getValue()){
			return rotation(new Tree(a.getValue(), rotation(insertHB(a.getLeft(),x)),a.getRight()));
		}
		if(x>a.getValue()){
			return rotation(new Tree<>(a.getValue(),a.getLeft(),
					rotation(insertHB(a.getRight(),x))));
		}

		else {
			return a;
		}
	}

	/**
	 * delete a number from the AVL tree and return the AVL tree
	 * 1. search the value from the AVL tree
	 * 2. if the value is greater than a.getValue, then x must be in right subtree
	 * 3. when x == a.getValue, then using method [delete] to remove the number
	 * 4. return the deleted tree and using method[rotation] to check if it is still a AVL tree
	 * 5. return the updated AVL tree
	 * @param a is a AVL tree
	 * @param x is the number that will be deleted from the tree
	 * @return the updated tree, if the value is not in the tree, return the original tree
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if(a.isEmpty()){
			return new Tree<>();
		}
//		if(x<a.getValue()){
//			return new Tree(a.getValue(),deleteHB(a.getLeft(),x),a.getRight());
//		}
//		if(x>a.getValue()){
//			return new Tree<>(a.getValue(),a.getLeft(),deleteHB(a.getRight(),x));
//
//		}
//		else {
			return rotation(delete(a,x));
		}
//	}

	/**
	 * rotate the tree to a AVL tree
	 * 1. check if the tree is AVL tree
	 * 2. separate to several situation to check
	 * a. if the tree is LL- CASE without the right subtree
	 * b, if the tree is RR- case without the left subtree
	 * c. if the tree is a BST
	 *   ==> LR/LL CASE
	 *   ==> RL/RR CASE
	 * 4. rotate if no matching the rule of AVL tree
	 * 5.  return the updated AVL tree
	 * @param a is a tree to check if it is a AVL tree
	 * @return the updated AVL tree
	 */
	static Tree<Integer> rotation(Tree<Integer> a) {
		if (isHeightBalanced(a) == true) {
			return a;
		}
		if (a.isEmpty()) return new Tree<>();


		if (a.getRight().isEmpty() && a.getLeft().isEmpty()) {
			return new Tree<>(a.getValue());
		}

		// left tree with left subtree
//		if(a.getRight().isEmpty() && !a.getLeft().getRight().isEmpty()){
//			return new Tree<>(a.getLeft().getValue(),
//					a.getLeft().getLeft(),
//					new Tree<>(a.getValue(), a.getLeft().getRight(),a.getRight()));
//		}

		// right tree with right subtree
//		if(a.getLeft().isEmpty() && !a.getRight().getLeft().isEmpty()){
//			return new Tree<>(a.getRight().getValue(),
//					new Tree<>(a.getValue(),a.getLeft(), a.getRight().getLeft()),
//					a.getRight().getRight());
//		}

		// LR only
		if (a.getRight().isEmpty()) {
			if(!a.getLeft().getRight().isEmpty()){
				return new Tree<>(a.getLeft().getRight().getValue(),
						new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
						new Tree<>(a.getValue(),a.getLeft().getRight().getRight(),a.getRight()));
			}
			return
					new Tree<>(a.getLeft().getValue(),a.getLeft().getLeft(),
							new Tree<>(a.getValue(),a.getLeft().getRight(),a.getRight()));
		}
		// RL/rr case
		if(a.getLeft().isEmpty()){
			if(!a.getRight().getLeft().isEmpty()) {
				return new Tree<>(a.getRight().getLeft().getValue(),
						new Tree<>(a.getValue(),a.getLeft(),a.getRight().getLeft().getLeft()),
						new Tree<>(a.getRight().getValue(),a.getRight().getLeft().getRight(),a.getRight().getRight()));
//						new Tree<>(a.getRight().getLeft().getValue(),
//						new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft()),
//						new Tree<>(a.getRight().getValue(), a.getRight().getLeft().getLeft(), a.getRight().getRight()));
			}
			return 	new Tree<>(a.getRight().getValue(), new Tree<>(a.getValue(),a.getLeft(),a.getRight().getLeft()),
					new Tree<>(a.getRight().getRight().getValue(),a.getRight().getLeft(),a.getRight().getRight().getRight()));
		}
		// search tree
		else {
				if (a.getRight().getHeight() - a.getLeft().getHeight() == 2) {
					//RR
					if (a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == 1) {
						return new Tree<>(a.getRight().getValue(),
								new Tree<>(a.getValue(),a.getLeft(),a.getRight().getLeft()),
								a.getRight().getRight());

					}
					//RL
					if (a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight() == -1) {
						return new Tree<>(a.getRight().getLeft().getValue(),
								new Tree<>(a.getValue(),a.getLeft(),a.getRight().getLeft().getLeft()),
								new Tree<>(a.getRight().getValue(),a.getRight().getLeft().getRight(),a.getRight().getRight()));

					}
					return new Tree<>(a.getValue(),a.getLeft(),rotation(a.getRight()));
				}
				if (a.getRight().getHeight() - a.getLeft().getHeight() == -2) {
					//LL
					if (a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == -1) {

						return new Tree<>(a.getLeft().getValue(),
								new Tree<>(a.getLeft().getLeft().getValue(),a.getLeft().getLeft(), a.getRight().getLeft()),
								new Tree<>(a.getValue(),a.getLeft().getRight(),a.getRight()));

//								new Tree<>(a.getLeft().getValue(),
//								new Tree<>(a.getLeft().getLeft().getValue(),
//										delete(delete(a.getLeft(), a.getLeft().getValue()),
//												a.getLeft().getLeft().getValue())
//										, new Tree<>()),
//								new Tree<>(a.getValue(), a.getLeft().getRight(), a.getRight()));
					}

					//LR
					if (a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight() == 1) {
						return	(new Tree<>(a.getLeft().getRight().getValue(),
								new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(),a.getLeft().getRight().getLeft()),
								new Tree<>(a.getValue(),a.getLeft().getRight().getRight(),a.getRight())));

					}
					return new Tree<>(a.getValue(),rotation(a.getLeft()),a.getRight());
				}
		}
			return new Tree<>(a.getValue(),rotation(a.getLeft()),rotation(a.getRight()));
//				new Tree<>(a.getValue(), rotation(a.getLeft()), rotation(a.getRight()));
		}



	public static void main(String[] args) {
		
	}


}


