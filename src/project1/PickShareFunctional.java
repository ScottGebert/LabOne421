package project1;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class PickShareFunctional {
	public static ShareInfo findHighPrices(Stream<String> symbols) {
		return symbols.map(sym -> ShareUtil.getPrice(sym)) // gets the price for all symbols
				.filter(price -> ShareUtil.isPriceLessThan(500).test(price)) // returns prices less than 500
				.reduce((price1, price2) -> ShareUtil.pickHigh(price1, price2)) // returns highest price
				.orElse(new ShareInfo("Error", new BigDecimal(0))); // Error if the optional value is empty
		
	}
}
