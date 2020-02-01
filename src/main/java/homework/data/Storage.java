package homework.data;

import java.util.Currency;
import java.util.List;
import java.util.Map;


public interface Storage {

    void save(Currency Currency, int amount);
    
    Map<Currency, List<Integer>> readAll();
    
    void removeAll();

    boolean isEmpty();
    
}
