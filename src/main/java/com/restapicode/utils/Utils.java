package com.restapicode.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Utils {
    public static byte[] makeSHA1fromArgs(byte[]... args) {
        MessageDigest md = null;
        byte[] result = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            for (int i = 0; i < args.length; i++) {
                md.update(args[i]);
            }
            result = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static BigInteger getX(byte[] salt, String username, String password) {
        // generate h1 - username:password
        String prepared = String.format("%s:%s", username, password).toUpperCase();
        byte[] h1 = makeSHA1fromArgs(prepared.getBytes(StandardCharsets.UTF_8));

        // generate h2 - salt + h1
        byte[] hashX = makeSHA1fromArgs(salt, h1);

        // reverse h2
        ArrayUtils.reverse(hashX);

        // construct h2Bigint
        return new BigInteger(hashX);
    }

    private static byte[] finishVerifier(BigInteger source) {
        // reverse ver
        byte[] reverseVer = source.toByteArray();
        ArrayUtils.reverse(reverseVer);
        return reverseVer;
    }

    public static byte[] calculateSRP6TCVerifier(String username, String password, byte[] salt){
        BigInteger TC_g = BigInteger.valueOf(7);
        BigInteger TC_N = new BigInteger("894B645E89E1535BBDAD5B8B290650530801B18EBFBF5E8FAB3C82872A3E9BB7", 16);

        //compute x
        BigInteger x = getX(salt, username, password);

        //return g.modPow(x, N);
        BigInteger ver = TC_g.modPow(x, TC_N);
        return finishVerifier(ver);
    }

    public static Boolean verifySRP6(String username, String password, byte[] salt, byte[] verifier){
        byte[] generated = calculateSRP6TCVerifier(username, password, salt);
        return Arrays.equals(generated, verifier);
    }

    public static byte[] generateRandomSalt(int numBytes) {
        byte[] salt = new byte[numBytes];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }
}
