package predictive;

/**
 * @version 2020-2-9
 * @author Hsin yi Chiu
 * a class to store word and its correspond signature
 */
public class WordSig implements  Comparable<WordSig> {

    private  String words;
    private String signature;

    /**
     * a constructor of words and signature
     * @param words is the words from the dictionary
     * @param signature is the matched signature of the words
     */
    public WordSig(String words, String signature){
        this.words= words;
        this.signature= signature;
    }

    /**
     * a String to display the word and its signature
     * @return words and signature
     */
    @Override
    public String toString() {
        return signature+" : "+ words;
    }

    /**
     * getter to get the word
     * @return the words
     */
    public String getWords() {
        return words;
    }

    /**
     * getter to get the signature
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * a compareTo method to store the words based on the signature
     * @param ws its include the words and the signature
     * @return 0 is that the same signature/ 1 is if the given signature is greater than the compared signature
     *          -1 is if the given signature is smaller than the compared signature
     */
    @Override
    public int compareTo(WordSig ws) {

//        return this.signature.compareTo(ws.signature);


        if(this.signature.compareTo(ws.signature)>0){
            return 1;
        }
        else if(this.signature.compareTo(ws.signature)<0){
            return -1;
        }
        else {
            return 0;
        }
    }

}
