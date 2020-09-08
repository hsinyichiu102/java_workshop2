package predictive;

import java.util.Scanner;

/**
 * @version 2020-02-19
 * @author Hsinyi Chiu
 * a commend line to get the word from the MapDictionary
 */

public class Sigs2WordsMap {

    public static void main(String[] args){
        System.out.println("please enter your dictionary path: ");
        Scanner s= new Scanner(System.in);
        String a = s.next();
        MapDictionary dic = new MapDictionary(a);
        for(String str:args){
            System.out.println(str+" : "+dic.signatureToWords(str));
        }
    }
}
