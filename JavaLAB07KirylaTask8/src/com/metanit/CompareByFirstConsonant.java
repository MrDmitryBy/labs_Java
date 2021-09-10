package com.metanit;

import java.util.Comparator;

public class CompareByFirstConsonant implements Comparator<String> {
    private final static Comparator<String> instance = new CompareByFirstConsonant();
    private final static String consonants = "ЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБ";

    public static Comparator<String> getInstance() {
        return instance;
    }

    public static boolean isConsonant(Character c) {
        return consonants.indexOf(Character.toUpperCase(c)) > -1;
    }

    private Character getFirstConsonant(String string) {
        for (int i = 0; i < string.length(); ++i)
            if (isConsonant(string.charAt(i)))
                return string.charAt(i);
        return Character.MIN_VALUE;
    }

    @Override
    public int compare(String a, String b) {
        Character consonantA = getFirstConsonant(a);
        Character consonantB = getFirstConsonant(b);
        return consonantA.compareTo(consonantB);
    }
}
