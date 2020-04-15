package de.marvinheller.codekatachallenge;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BloomFilterTest {

    @Test
    public void testBloomFilter() {
        String input1 = "Test123";
        String input2 = "/§Test§=)";
        String input3 = "IudjaSdkcC";
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add(input1);
        bloomFilter.add(input2);
        System.out.println(bloomFilter.getBitSet());

        Assertions.assertTrue(bloomFilter.probablyContains(input1));
        Assertions.assertTrue(bloomFilter.probablyContains(input2));
        Assertions.assertFalse(bloomFilter.probablyContains(input3));

    }
}
