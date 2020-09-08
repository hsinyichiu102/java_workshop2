package predictive;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TreeDictionaryTest {

    @Test
    void test1(){
        String path = "/usr/share/dict/words";
        TreeDictionary actual= new TreeDictionary(path);
        //test only one number
        Set<String> expect= new HashSet<>();
        expect.add("a"); expect.add("b"); expect.add("c");
        assertEquals(expect,actual.signatureToWords("2"));

        // test long number
        expect= new HashSet<>();
        expect.add("dilo");expect.add("eiko");expect.add("filo");expect.add("film");
        assertEquals(expect,actual.signatureToWords("3456"));

        //test the number is not in the dic
        expect= new HashSet<>();
        assertEquals(expect,actual.signatureToWords("12"));

        //emtpy enter
        assertEquals(expect,actual.signatureToWords(" "));

    }

}