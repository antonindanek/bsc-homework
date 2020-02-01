package homework;

import homework.data.MemoryStorage;
import homework.data.Storage;
import homework.loading.ConsoleReader;
import homework.loading.InputFileReader;
import homework.processing.SumProcessor;

import org.apache.log4j.Logger;


public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    
    public static void main(String[] args) {
        
        log.info("Welcome to Antonin's homework for .BSC");
        
        Storage storage = MemoryStorage.getInstance();
        
        new InputFileReader(storage, args).start();
        new ConsoleReader(storage).start();
        new SumProcessor(storage).start();
    }
    
}
