package predictive;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @version 2020-2-9
 * @author Hsin Yi Chiu
 * Write a constructor for the class ListDictionary that takes a String path to the dictionary,
 * reads stores it in an ArrayList. Each entry of the ArrayList must be a pair,
 * consisting of the word that has been read in and its signature.
 * For this purpose, you will need to create a class named WordSig that pairs words and signatures (see the hints).
 * The wordToSignature method will be the same so you can re-use the code from the first part.
 * The signatureToWords method must be re-written
 * as an instance method in the List- Dictionary class to use the stored dictionary.
 * The ArrayList<WordSig> must be stored in sorted order and
 * the signatureToWords method must use binary search to perform the look-ups.
 */
pulic class ListDictionary implements Dictionary{

    static ArrayList<WordSig> store;

    /**
     * constructor to get the path of the file
     * get the dictionary and store it to the store with the signature and the word
     * @param path is the file path
     */
    public ListDictionary(String path){
            store= new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()){
                String a = s.next().toLowerCase();
                if(predictive.PredictivePrototype.isValidWord(a)==true){
                    store.add(new WordSig(a,PredictivePrototype.wordToSignature(a)));
                }
            }
            Collections.sort(store);
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * a method to get the words witch is matched the signature
     * @param signature is the number to search the matched words
     * @return a set of the words witch matched the signature or if the signature is wrong number then return null
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        //Set sw to store the matched words
        Set<String> sw= new HashSet<>();
        ArrayList<String> words = new ArrayList<>();
        for(int i=0; i<store.size();i++){
            words.add(store.get(i).getSignature());
        }

            // using binary-search to search the position of a word matched signature
            // as known binary-search can get one matched signature, and the array of the store has already sorted.
            // thus the front of the position a and back of it might also be the same number
        int a = Collections.binarySearch(store,new WordSig("",signature));
//            sw.add(store.get(a).getWords());
            // using while loop to check the signature if it is same

           while (a>=0 && store.get(a).getSignature().equals(signature)){
               sw.add(store.get(a).getWords());
               a+=1;
           }

           while (a>0&&store.get(a).getSignature().equals(signature)){
               sw.add(store.get(a).getWords());
               a -= 1;
           }

        return sw;

    }


}

