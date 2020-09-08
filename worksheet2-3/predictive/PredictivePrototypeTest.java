package predictive;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  HSIN YI CHIU
 * @version 2020-02-08
 */
class PredictivePrototypeTest {



    @Test
    void testWordToSignature(){
        // One Upper letter
        String word1= "Hello";
        String actual = PredictivePrototype.wordToSignature(word1);
        String getWord ="43556";
        assertEquals(actual,getWord);

        // all Upper Letter
        String word2 ="HOME";
        actual=PredictivePrototype.wordToSignature(word2);
        getWord="4663";
        assertEquals(actual,getWord);

        // all lower letter
        String word3="home";
        actual=PredictivePrototype.wordToSignature(word3);
        assertEquals(actual,getWord);

        //letter with non-alphabet
        String word4="abc123";
        actual=PredictivePrototype.wordToSignature(word4);
        getWord ="222   ";
        assertEquals(getWord,actual);

        //letter with sign
        String word5= "jio*&^";
        actual=PredictivePrototype.wordToSignature(word5);
        getWord="546   ";
        assertEquals(actual,getWord);

        // all non-alphabet
        String word6="124)(&";
        actual=PredictivePrototype.wordToSignature(word6);
        getWord="      ";
        assertEquals(actual,getWord);

    }
    @Test
    void testSignatureToWords(){
        // not match words
        String input = "123";
        String output ="   ";
        assertEquals(output,PredictivePrototype.wordToSignature(input));

        // 5 letter
        Set check = new HashSet();
        input="225";
        check.add("bal");
        check.add("aal");
        check.add("cal");
        assertEquals(check, PredictivePrototype.signatureToWords(input));

        // 4 ketter
        Set check2= new HashSet();
        input="5566";
        check2.add("klom");
        assertEquals(check2, PredictivePrototype.signatureToWords(input));

        //not match letter
        input= "234567";
        output ="      ";
        assertEquals(output,PredictivePrototype.wordToSignature(input));
    }

    @Test
    void testIsValidWord(){
        String word ="abc";
        assertTrue(PredictivePrototype.isValidWord(word));

        word= "ha";
        assertTrue(PredictivePrototype.isValidWord(word));

        word=" ";
        assertFalse(PredictivePrototype.isValidWord(word));

        word="*&^";
        assertFalse(PredictivePrototype.isValidWord(word));

        word="zxc&^";
        assertFalse((PredictivePrototype.isValidWord(word)));

        word="as asd";
        assertFalse(PredictivePrototype.isValidWord(word));
    }
}