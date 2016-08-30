package com.simon;

/**
 * Created by Simon on 30/08/2016.
 */
public class Main {

    private static final int[] ENCRYPT_KEY = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};

    public static void main(String[] args) {
        System.out.println("Caesar's Box Message Encryption tool");
        if (args.length > 2 || args.length < 2 || !(args[0].equals("e") || args[0].equals("d"))) {
            displayHelp("");
        }
        if (args[0].equals("e")) {
            encodeMessage(args[1]);
        } else if (args[0].equals("d")) {
            decodeMessage(args[1]);
        }

        System.exit(0);
    }

    private static void encodeMessage(String original) {


        //Make String length multiple of 16
        int whitespace = original.length() % 16;
        boolean sideOfText = false;
        if (whitespace != 0)
            for (int i = whitespace; i < 16; i++) {
                if (sideOfText) {
                    original = original + "_";
                } else {
                    original = "_" + original;
                }
                sideOfText = !sideOfText;
            }

        String out = "";
        for (int j = 0; j < (original.length() / 16); j++) {
            for (int k : ENCRYPT_KEY) {
                out = out + original.charAt((j * 16) + k);
            }
        }
        System.out.println("Your encoded message is:");
        System.out.println(out);

    }

    private static void decodeMessage(String original) {
        //Validate is 16
        if (original.length() % 16 != 0) {
            displayHelp("You can only decode encrypted messages produced by this tool!");
        }
        String out = "";
        for (int j = ((original.length() / 16) - 1); j >= 0; j--) {
            for (int k = 15; k >= 0; k--) {
                out = original.charAt((j * 16) + ENCRYPT_KEY[k]) + out;
            }
        }
        System.out.println("Your decoded message reads:");
        System.out.println(out);
    }

    private static void displayHelp(String msg) {
        if(msg.equals("")){
            System.out.println("");
            System.out.println("  Call on Commandline with arguments:");
            System.out.println("    <option> <String messageToEncryptOrDecrypt>");
            System.out.println("");
            System.out.println("  Options:");
            System.out.println("    e - encrypt you message");
            System.out.println("    d - decrypt a message encrypted with this tool");
            System.out.println("");


        } else {
            System.out.println(msg);
        }
        System.exit(0);
    }
}

