package homework.loading;

import java.util.Currency;
import java.util.Scanner;

import org.apache.log4j.Logger;

import homework.data.Storage;
import homework.data.parser.AmountParser;
import homework.data.parser.CurrencyParser;

public abstract class InputReader extends Thread {

	protected static final String message = "Please provide input with format: '<currency> <amount>' e.g. USD 1000";

	private static final Logger log = Logger.getLogger(InputReader.class);

	private CurrencyParser currencyParser = new CurrencyParser();
	private AmountParser amountParser = new AmountParser();

	private Storage storage;

	public InputReader(Storage storage) {

		this.storage = storage;
	}

	protected void readAndStoreLine(Scanner sc) {

		String input = sc.nextLine();

		String[] inputArr = input.trim().split(" ");

		if (inputArr.length != 2) {
			log.error(message);
			return;
		}

		Currency parsedCurrency = currencyParser.parse(inputArr[0]);
		Integer parsedAmount = amountParser.parse(inputArr[1]);

		if (parsedCurrency == null || parsedAmount == null) {
			log.error(message);
			return;
		}

		storage.save(parsedCurrency, parsedAmount);
	}

}
