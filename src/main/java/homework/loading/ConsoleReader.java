package homework.loading;

import java.util.Scanner;

import homework.data.Storage;

public class ConsoleReader extends InputReader {

    public ConsoleReader(Storage storage) {
    	super(storage);
    }

    @Override
    public void run() {

        System.out.println(PROMPT_MESSAGE);

        try (Scanner sc = new Scanner(System.in)) {

            while (sc.hasNextLine()) {
                readAndStoreLine(sc);
            }
        }

    }



}
