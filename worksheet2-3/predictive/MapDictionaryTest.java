package predictive;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapDictionaryTest {

    @Test
    public void test1(){
        //check a word
        String s = "/usr/share/dict/words";
        Set<String> expect = new HashSet<>();
        expect.add("cadi");
        expect.add("cafh");
        MapDictionary actual = new MapDictionary(s);
        assertEquals(expect,actual.signatureToWords("2234"));

        //check a alphabet
        Set<String> expect2= new HashSet<>();
        expect2.add("a");
        expect2.add("b");
        expect2.add("c");

        assertEquals(expect2,actual.signatureToWords("2"));

        //check word is not in the dict
        Set<String> expect3 = new HashSet<>();

        assertEquals(expect3,actual.signatureToWords("123"));

        //check if enter an empty word
        assertEquals(expect3,actual.signatureToWords(" "));
    }


}