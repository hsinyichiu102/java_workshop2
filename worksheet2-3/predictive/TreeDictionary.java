package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @version 2020-02-18
 * @author HSIN YI CHIU
 * a TreeDictionary to contain the word from path with a tree way
 * we can get the words by putting the signature and
 * the class will return whole the words
 */
public class TreeDictionary implements Dictionary {

    private TrieNode root;

    public TreeDictionary(String path) {
        root= new TrieNode();
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()) {
                String word = s.next().toLowerCase();
                if (PredictivePrototype.isValidWord(word) == true) {
                    setTree(word);
                }
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    /**
     * a method to insert the word on the correspond node
     * 1.  change the word to the correspond signature
     * 2. for loop to separate the signature to a single number
     * 3. int index to check the position of the node that include in the tree
     * 4. if the the position is empty, then make a new TrieNode to put in and put the corresponded word
     * 5. if the position is not empty, then just put the word into the corresponded position in the array
     * 6. thus the word is stored in the root based on the position, which is from 0 to 7, representing the number 2 to 9
     * @param word is a word from the path file
     */

    public void setTree(String word) {
        TrieNode p=root;
        String signature = PredictivePrototype.wordToSignature(word);
        for(int i =0; i<word.length();i++){
            char c = signature.charAt(i);
            int index= c-'2';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p.arr[index].word.add(word);
                p= temp;
            }else {
                p.arr[index].word.add(word);
                p=p.arr[index];
            }
        }


    }

    /**
     * a method to get the words from the signature
     * 1.  for loop to get the last node and the store the words in a Set s
     * 2. get the substring of the words based on the same length with the signature
     * 3. put the new words into another set searchWord and return it
     * @param signature is a String number from commend-line to search the word
     * @return the HashSet searchWord with the word relative with the signature
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        TrieNode p = root;
        Set<String> s;

        try{
            for(int i=0;i<signature.length();i++){
                char c= signature.charAt(i);
                int index= c-'2';
                p= p.arr[index];
            }
            s= p.word;
            Iterator it = s.iterator();
            Set<String> searchWord= new HashSet<>();
            int length = signature.length();
            while (it.hasNext()){
                String tempS= (String) it.next();
                searchWord.add(tempS.substring(0,length));
            }
            return searchWord;

        }catch(ArrayIndexOutOfBoundsException e){
            return new HashSet<>();
        }

    }

    /**
     * a TrieNode class to assemble the tree
     * TrieNode[] arr represent the node of tree and each node can have 8 branch
     * Set<String> word is to store the corresponded word with the node number
     */
    class TrieNode{
        TrieNode[] arr;
        Set<String> word;
        public TrieNode(){
            this.arr= new TrieNode[8];
            this.word= new HashSet<>();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "arr=" + Arrays.toString(arr) +
                    ", word=" + word ;
        }
    }
}