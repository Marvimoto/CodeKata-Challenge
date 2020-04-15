package de.marvinheller.codekatachallenge;

import java.nio.charset.Charset;
import java.util.Random;

public class CodeKataChallenge {

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();

        // Generate random words to check
        int generatedWords = 10000000;
        int correctWords = 0;
        for (int i = 0; i < generatedWords - 1; i++) {
            String randomWord = spellChecker.generateRandomWord(5, true);

            if (spellChecker.isSpelledCorrect(randomWord)) {
                generatedWords++;
            }
        }

        System.out.println(correctWords + "/" + generatedWords + " false positives");
    }


}
