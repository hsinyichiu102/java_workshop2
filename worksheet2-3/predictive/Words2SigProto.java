package predictive;

/**
 * @author Hsin Yi Chiu
 * @version 2020-2-9
 * a commend line to get the signature from the words
 */
class Words2SigProto {
    public static void main(String[] args){
        for(String s : args){
            System.out.println(s+" : "+predictive.PredictivePrototype.wordToSignature(s));
        }
    }

}