package predictive;

import java.util.Scanner;

/**
 * @version 2020-02-18
 * @author Hsin Yi Chiu
 * a commend line from the ented signaure to get the words
 */

public class Sigs2WordsTree {

    public static void main(

            String[] args){System.out.println("please enter your dictionary path: ");
        Scanner s= new Scanner(System.in);
        String a = s.next();
        TreeDictionary dic = new TreeDictionary(a);
        for(String str:args){
            System.out.println(str+" : "+dic.signatureToWords(str));
        }
    }
}
