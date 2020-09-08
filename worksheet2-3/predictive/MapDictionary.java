package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Using a Map, data can be retrieved quickly by looking up a signature as in ListDictionary,
 * but now it does not require scanning either side of the index as earlier.
 * MapDictionary will also allow efficient insertion of new words in the dictionary while still allowing fast look-up.
 * @version 2020-2-17
 * @author Hsin Yi Chiu
 */
public class MapDictionary implements Dictionary{

    static Map<String, Set<String>> mDictionary= new HashMap<>();

    /**
     * a mapDictionary to import the word from the path and store the word into mDictionary for quick checking
     * @param path is the file path
     */
    public MapDictionary(String path) {

        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()) {
                String a = s.next().toLowerCase();
                if(PredictivePrototype.isValidWord(a)==true){
                    mDictionary.put(PredictivePrototype.wordToSignature(a)
                            ,setWord(PredictivePrototype.wordToSignature(a),a));
                }
            }

            }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * a method to match the signature and the word into a set
     * if mDictionary contains the key signature, then get the set of the signature
     * and put the word into the set
     * if no, then make a new key and put the word inside
     * @param signature is the key that store in the mDictionary
     * @param word is read from the path file and match it with the signature
     * @return the set of setWord
     */
    static Set<String> setWord(String signature, String word){
        Set<String> set = new HashSet<>();
         if(mDictionary.containsKey(signature)){
             set=mDictionary.get(signature);
             set.add(word);
             mDictionary.put(signature,set);
         }
         else {
             set.add(word);
             mDictionary.put(signature,set);
         }
         return set;
    }

    /**
     * a method signatureToWords that returns, in a Set<String>,
     * only the matching whole words for the given signature.
     * The character length of each returned word must be the same as the input signature.
     * @param signature get from the user to find the correspond word
     * @return the correspond word from the mDictionary
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        if(mDictionary.containsKey(signature)){
            return mDictionary.get(signature);
        }
        else{
            return new HashSet<>();
        }
    }

}
