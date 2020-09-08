package predictive;

import java.util.Set;

/**
 * @version 2020-2-9
 * @author Hsin Yi Chiu
 * The required method signatureToWords finds
 * the possible words that could correspond to a given signature and returns them as a set
 */
public interface Dictionary {
    public Set<String> signatureToWords(String signature);
}
