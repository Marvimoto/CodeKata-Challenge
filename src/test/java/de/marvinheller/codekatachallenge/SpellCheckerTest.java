package de.marvinheller.codekatachallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SpellCheckerTest {

    private static SpellChecker spellChecker;
    private static List<String> words;

    @BeforeAll
    static void init() throws IOException {
        spellChecker = new SpellChecker();
        String file = "src/main/resources/wordlist.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        words = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }
        reader.close();
    }

    @Test
    void testAllWordsSpelledCorrect() {
        for (String word : words) {
            Assertions.assertTrue(spellChecker.isSpelledCorrect(word));
        }

    }
}
