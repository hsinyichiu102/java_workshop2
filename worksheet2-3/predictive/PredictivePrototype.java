package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Hsin Yi Chiu
 * @version 2020-02-08
 */
class PredictivePrototype{
    /**
     * a method to swap each letter to the corresponded number
     * Using StringBuffer as we can delete and append char directly based on the origin object
     * besides, we can use the compareTo method on the StringBuffer, which cannot be implement on String
     * Thus, considering the efficiency, if we use String, then there will be two for loop to check the
     * corresponded letter with the alphabet and get the position of the alphabet, which need to have
     * O(n^2), but as we can use the compareTo to get the relative position of the letter and directly
     * revise the letter to the number that we need.
     * @param word  is a String that user type in
     * @return the signature(number) of the word
     */

    public static String wordToSignature(String word) {

        Map<Character, Character> button = new HashMap<>();
        button.put('a','2'); button.put('b','2'); button.put('c','2');
        button.put('d','3'); button.put('e','3'); button.put('f','3');
        button.put('g','4'); button.put('h','4'); button.put('i','4');
        button.put('j','5'); button.put('k','5'); button.put('l','5');
        button.put('m','6'); button.put('n','6'); button.put('o','6');
        button.put('p','7'); button.put('q','7'); button.put('r','7'); button.put('s','7');
        button.put('t','8'); button.put('u','8'); button.put('v','8');
        button.put('w','9'); button.put('x','9'); button.put('y','9'); button.put('z','9');
        button.put('1',' '); button.put('*',' '); button.put('#',' '); button.put(' ',' ');
        button.put('2',' '); button.put('3',' '); button.put('4',' '); button.put('5',' ');
        button.put('6',' '); button.put('7',' '); button.put('8',' '); button.put('9',' ');
        button.put('^',' '); button.put('%',' '); button.put('$',' '); button.put('&',' ');
        button.put('@',' '); button.put('!',' '); button.put('(',' '); button.put(')',' ');
        button.put('+',' '); button.put('-',' ');

        StringBuffer lowerCase = new StringBuffer(word.toLowerCase());
        String temp = lowerCase.toString();
        char[] w = temp.toCharArray();
        String signature = "";
        for(int i=0; i<w.length;i++){
            signature= signature+button.get(w[i]);
        }

        return signature;
    }

    /**
     * get the signature and find out the matched words
     * if file(dictionary) still have line, then the loop will continue
     * if the word from dictionary is a consist from alphabet, then return true to get the word
     *
     * @param signature a number that to find out the word
     * @return the set of the word
     */
    public static Set<String> signatureToWords(String signature){
        try {
            Scanner s = new Scanner(new File("/usr/share/dict/words"));
            Set<String> word = new HashSet<>();
                    String a;
            while(s.hasNext()){
                a=s.next();
                if(wordToSignature(a).equals(signature)) {
                    if(isValidWord(a)==true){
                        word.add(a.toLowerCase());
                        }
                    }
            }
            return word;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * to check if the word is a alphabet word
     * @param word from the constructor to get if it is a alphabet word
     * @return true if it is a alphabet word
     */

    static boolean isValidWord(String word){
        char[] c = word.toCharArray();
        int count=0;
        for(int i=0; i<c.length;i++){
            if (c[i]>='a' && c[i]<='z'){
                count=count+1;
            }
            if (c[i]>='A' && c[i]<='Z'){
                count=count+1;
            }
        }
        if(word.length()==count){
            return true;
        }
        return false;
    }
}

