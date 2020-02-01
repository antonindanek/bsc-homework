package homework.data.parser;

import java.util.Currency;

import org.apache.log4j.Logger;

public class CurrencyParser implements Parser<Currency> {

    private static final Logger log = Logger.getLogger(CurrencyParser.class);

    @Override
    public Currency parse(String input) {

        try {
            Currency parsedValue = Currency.getInstance(input.toUpperCase());
            return parsedValue;
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error(input + " is not a valid ISO 4217 currency");
            return null;
        }

    }

}
