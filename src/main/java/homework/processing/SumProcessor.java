package homework.processing;

import java.util.Currency;
import java.util.List;
import java.util.Map;

import homework.configuration.ConfigReader;
import homework.data.Storage;


public class SumProcessor extends Thread {
    
    private Storage storage;
    
    public SumProcessor(Storage storage) {

        this.storage = storage;
    }
    
    @Override
    public void run() {
        
        while(true) {
            printPaymentsPerCurrencies();
            
            try {
                Thread.sleep(ConfigReader.waitBetweenPrintsMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void printPaymentsPerCurrencies() {
        
        if(storage.isEmpty()){
            return;
        }
        
        System.out.println("|------|");
        for (Map.Entry<Currency, List<Integer>> entry : storage.readAll().entrySet()) {
            
            int amountInCurrency = entry.getValue().stream().reduce(Integer::sum).get();
            if(amountInCurrency != 0) {
                System.out.println(entry.getKey().getCurrencyCode() + " " + amountInCurrency);
            }
        }
        System.out.println("|------|");
        
    }
    
}
