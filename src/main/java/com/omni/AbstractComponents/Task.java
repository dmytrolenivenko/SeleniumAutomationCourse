package com.omni.AbstractComponents;

public class Task {

    public static void main(String[] args) {

        System.out.println(stringShifter("Hello, Worlz", 1));
    }

    public static String stringShifter(String str, int num) {
        String[] alfabet = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"
        };
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char oldLetter = str.charAt(i);
            boolean found = false;
            for (int j = 0; j < alfabet.length; j++) {
                if (alfabet[j].equalsIgnoreCase(Character.toString(oldLetter))) {
                    String newLetter = alfabet[j + num];
                    builder.append(newLetter);
                    found = true;
                } /* else if (alfabet[j + num] > alfabet.length) {
                    System.out.println("Hell mate");
                    j = 0;
                } */
            }
            if (!found) {
                builder.append(oldLetter);
            }
        }
        return builder.toString();
    }
}
