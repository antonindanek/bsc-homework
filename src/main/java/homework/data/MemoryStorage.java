package homework.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class MemoryStorage implements Storage {
    
    private static final Logger log = Logger.getLogger(MemoryStorage.class);
    
    // eager initialization
    private static final MemoryStorage instance = new MemoryStorage();

    private MemoryStorage(){}
    
    private Map<Currency, List<Integer>> storage = Collections.synchronizedMap(new HashMap<Currency, List<Integer>>());
    
    public static MemoryStorage getInstance() {
        return instance;
    }
    
    @Override
    public void save(Currency currency, int amount) {

        List<Integer> paymentsInCurrency = storage.get(currency);
        
        if(paymentsInCurrency == null) {
            // first payment in currency
            paymentsInCurrency = Collections.synchronizedList(new ArrayList<Integer>());
            paymentsInCurrency.add(amount);
            
            storage.put(currency, paymentsInCurrency);
            
        } else {
            paymentsInCurrency.add(amount);
            
        }
        
        log.info("New payment saved: " + currency.getDisplayName() + " " + amount);
        
    }

    @Override
    public Map<Currency, List<Integer>> readAll() {

        return storage;
    }

    @Override
    public void removeAll() {

        storage.clear();
    }

    @Override
    public boolean isEmpty() {

        return storage.isEmpty();
    }

}
