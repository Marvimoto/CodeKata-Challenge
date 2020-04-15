package de.marvinheller.codekatachallenge;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpellChecker {

    private BloomFilter bloomFilter = new BloomFilter();

    public SpellChecker() {
        String file = "src/main/resources/wordlist.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> words = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();

            for (String word : words) {
                bloomFilter.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isSpelledCorrect(String word) {
        return bloomFilter.probablyContains(word);
    }

    public String generateRandomWord(int length, boolean capitalized) {
        String word = RandomStringUtils.random(length, true, false);

        // Capitalize random word
        if (capitalized) {
            word = word.toLowerCase();
            String firstLetter = word.substring(0, 1).toUpperCase();
            word = firstLetter + word.substring(1).toLowerCase();
        }
        return word;
    }
}
