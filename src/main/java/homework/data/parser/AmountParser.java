package homework.data.parser;

import org.apache.log4j.Logger;


public class AmountParser implements Parser<Integer> {
    
    private static final Logger log = Logger.getLogger(AmountParser.class);
    
    @Override
    public Integer parse(String input){
        
        try {
            int parsedValue = Integer.parseInt(input);
            return parsedValue;
        } catch (NumberFormatException e) {
            log.error(input + " is not an integer");
            return null;
        }
        
    }

}
