package de.marvinheller.codekatachallenge;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.HashSet;

public class BloomFilter {

    private BitSet bitSet = new BitSet();


    public BloomFilter() {

    }

    public void add(String input) {
        // create hashes
        HashSet<Integer> hashes = this.hashInput(input);
        for (int hash : hashes) {
            if (!bitSet.get(hash)) {
                bitSet.set(hash);
            }
        }

    }

    public boolean probablyContains(String input) {
        HashSet<Integer> hashes = this.hashInput(input);
        for (int hash : hashes) {
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private HashSet<Integer> hashInput(String input) {
        HashSet<Integer> hashes = new HashSet<>();
        hashes.add(createMd5HashChars(input));
        hashes.add(createMd5Hash(input));
        return hashes;
    }

    private String createMd5Hex(String input) {
        try {
            // Create messageDigest object
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // Feeding the input into the object
            messageDigest.update(input.getBytes());
            byte[] digest = messageDigest.digest();

            // Convert digest to hex
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Function creates a md5 hex hash and sums up the values of the single
     * chars in the hex
     *
     * @param input Word to hash
     * @return integer hash
     */
    private int createMd5HashChars(String input) {
        String hashHex = createMd5Hex(input);
        // Fill a char array with chars from hex
        char[] hashChars = hashHex.toCharArray();
        int hash = 0;
        // Loop through chars and sum up the value of the char
        for (char ch : hashChars) {
            hash = hash + ch;
        }
        return hash;


    }

    private int createMd5Hash(String input) {
        String hashHex = createMd5Hex(input);

        // Fill a char array with chars from hex
        int hash = Math.abs(hashHex.hashCode());
        return hash;
    }

    public BitSet getBitSet() {
        return bitSet;
    }
}
