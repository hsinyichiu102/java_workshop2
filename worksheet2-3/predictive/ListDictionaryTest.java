package predictive;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListDictionaryTest {
// please note that the words in "/usr/share/dict/words" are less than the words in the file when I downloaded.
// thus the test is based on the word that I can get from "/usr/share/dict/words".

    @Test
    public void test(){
        ListDictionary a = new ListDictionary("/usr/share/dict/words");
        Set<String> actualSet=new HashSet<>();
        actualSet.add("glor");
        actualSet.add("glop");
        assertEquals(actualSet,a.signatureToWords("4567"));
    }
    //check if the number is not correct
    @Test
    public void test2(){
        ListDictionary a = new ListDictionary("/usr/share/dict/words");
        Set<String> actualSet=new HashSet<>();
        assertEquals(actualSet,a.signatureToWords("123"));
    }

    // check the word is not in the dictionary
    @Test
    public void test3(){
        ListDictionary a = new ListDictionary("/usr/share/dict/words");
        Set<String> actualSet=new HashSet<>();
        assertEquals(actualSet,a.signatureToWords("46665"));
    }

    // check a alphabet
    @Test
    public void test4(){
        ListDictionary a = new ListDictionary("/usr/share/dict/words");
        Set<String> actualSet=new HashSet<>();
        actualSet.add("b");
        actualSet.add("c");
        assertEquals(actualSet,a.signatureToWords("2"));
    }


}