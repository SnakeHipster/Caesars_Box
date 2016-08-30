package com.simon;

/**
 * Created by Simon on 30/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        if (args.length > 2 || args.length < 2 || !(args[0].equals("e") || args[0].equals("d"))) {
            displayHelp();
            System.exit(0);
        }
        if (args[0].equals("e")){
            encodeMessage(args[1]);
        } else if (args[0].equals("d")){
            decodeMessage(args[1]);
        }

        System.out.println("Woot!");
    }

    private static void encodeMessage(String arg) {
        System.out.println("encode");
    }

    private static void decodeMessage(String arg) {
        System.out.println("decode");
    }

    private static void displayHelp() {
        System.out.println("help");

    }
}

