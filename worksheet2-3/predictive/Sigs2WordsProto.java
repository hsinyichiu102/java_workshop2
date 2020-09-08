package predictive;

/**
 * @version 2020-2-9
 * @author Hsin Yi Chiu
 * a commend line program to get the words from the signature
 */
class Sigs2WordsProto{

    public static void main (String[] args) {
        for(String s : args){
            System.out.println(s+" : "+predictive.PredictivePrototype.signatureToWords(s));
        }
    }
}