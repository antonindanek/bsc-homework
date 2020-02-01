package homework.loading;

import java.util.Currency;
import java.util.Scanner;

import org.apache.log4j.Logger;

import homework.configuration.ConfigReader;
import homework.data.Storage;
import homework.data.parser.AmountParser;
import homework.data.parser.CurrencyParser;

public abstract class InputReader extends Thread {

	protected static final String PROMPT_MESSAGE = "Please provide input with format: '<currency> <amount>' e.g. USD 1000";

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

		if (inputArr.length == 1 && inputArr[0].equals(ConfigReader.getQuitKeyword())) {
			log.info("Exiting program");
			System.exit(0);
		}
		
		if (inputArr.length != 2) {
			log.error(PROMPT_MESSAGE);
			return;
		}

		Currency parsedCurrency = currencyParser.parse(inputArr[0]);
		Integer parsedAmount = amountParser.parse(inputArr[1]);

		if (parsedCurrency == null || parsedAmount == null) {
			log.error(PROMPT_MESSAGE);
			return;
		}

		storage.save(parsedCurrency, parsedAmount);
	}

}
