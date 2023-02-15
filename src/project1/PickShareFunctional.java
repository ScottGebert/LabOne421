package project1;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickShareFunctional {
	private static Map<String, ShareInfo> sharePrices = null;
	
	/**
	 * Method to initialize the share prices. The method can take several minutes to run since
	 * we can only fetch 5 shares every minute. This must be called before any other methods.
	 * If it is not, then it will be called during the other method calls.
	 * 
	 * @param symbols : a stream of the share symbols to fetch
	 */
	public static void init(List<String> symbols) {
		if (sharePrices != null) {
			return;
		}
		
		sharePrices = new HashMap<>();
		
		for (String sym : symbols) {
			System.out.println("Calling " + sym);
			ShareInfo share = ShareUtil.getPrice(sym);
			while (share.price.intValue() == -1) {
				try {
					Thread.sleep(60000);
					System.out.println("Calling " + sym);
					share = ShareUtil.getPrice(sym);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			sharePrices.put(sym, share);
		}
	}
	
	/**
	 * Method that will find the highest share price from a stream of share symbols under $500
	 * 
	 * @param symbols : stream of symbols to find the highest price under $500 from
	 * @return highest price share under $500
	 */
	public static ShareInfo findHighPrices(Stream<String> symbols) {
		if (sharePrices == null) {
			init(symbols.toList());
		}
		
		return symbols.map(sym -> sharePrices.get(sym)) // gets the price for all symbols
				.filter(price -> ShareUtil.isPriceLessThan(500).test(price)) // returns prices less than 500
				.reduce((price1, price2) -> ShareUtil.pickHigh(price1, price2)) // returns highest price
				.orElse(new ShareInfo("Error", new BigDecimal(0))); // Error if the optional value is empty
		
	}
}
