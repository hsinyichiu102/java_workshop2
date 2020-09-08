package predictive;

import java.util.Scanner;

/**
 * @version 2020-2-11
 * @author Hsin Yi Chiu
 *
 * a commend line for the ListDictionary
 * to try
 * $ time java -cp .. predictive.Sigs2WordsList 455 4567 456 456 678 89 34
 * the result
 * real	0m2.981s
 * user	0m3.080s
 * sys	0m0.213s
 *
 * compare with Sig2WordsProto
 * $ time java -cp .. predictive.Sig2WordsProto 455 4567 456 456 678 89 34
 * real	0m4.472s
 * user	0m5.839s
 * sys	0m0.320s
 *
 * Although there is only 2 sec difference between this two class
 * however, if we have much bigger amount signature, then the time will be better for ListDictionary
 */

public class Sigs2WordsList {

    public static void main(String[] arg) {
        System.out.println("please enter your dictionary path: ");
        Scanner s= new Scanner(System.in);
        String a = s.next();
        ListDictionary dic = new ListDictionary(a);
        for(String str:arg){
            System.out.println(str+" : "+dic.signatureToWords(str));
        }
    }
}

