package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

public class APIFinance {
	private static final String BASE_URL = "https://www.alphavantage.co/query?";
	private final static String apiKey = "1WZL1PWUNIJXRFOZ";
	
	public static BigDecimal getPrice(final String symbol) {
		BigDecimal price = new BigDecimal(0);
		try {
			URL url = new URL(BASE_URL + "function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey);
			URLConnection connection = url.openConnection();
			InputStreamReader inputStream = new	InputStreamReader(connection.getInputStream(), "UTF-8");
			BufferedReader bufferedReader = new	BufferedReader(inputStream);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				if (line.contains("price")) {
					price = new BigDecimal(line.split("\"")[3].trim());
				}
				else if (line.contains("Note")) {
					price = new BigDecimal(-1);
				}
			}
		} 
		catch (IOException e) {
			System.out.println("failure sending request");
		}
		
		return price;
	}

  // Get price - needs to be refactored to get all share data in one call
//  public static BigDecimal getPrice(final String symbol) {
//    try {
//      URL url = new URL(BASE_URL + "function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey);
//      URLConnection connection = url.openConnection();
//      InputStreamReader inputStream = new InputStreamReader(connection.getInputStream(), "UTF-8");
//      BufferedReader bufferedReader = new BufferedReader(inputStream);
//
//      Optional<BigDecimal> price = bufferedReader.lines()
//          .filter(line -> line.contains("price"))
//          .map(line -> new BigDecimal(line.split("\"")[3].trim()))
//          .findFirst();
//
//      return price.orElse(BigDecimal.ZERO);
//    } catch (Exception e) {
//      System.out.println("failure sending request");
//      return BigDecimal.ZERO;
//    }
//  }

  // public static final Map<String, Integer> symbols = Map.of("IBM",
  // Integer.valueOf(100),
  // "AAPL", Integer.valueOf(200),
  // "AMZN", Integer.valueOf(300),
  // "CSCO", Integer.valueOf(400),
  // "SNE", Integer.valueOf(500),
  // "GOOG", Integer.valueOf(600),
  // "MSFT", Integer.valueOf(700),
  // "ORCL", Integer.valueOf(800),
  // "FB", Integer.valueOf(900),
  // "VRS", Integer.valueOf(1000));
  // public static BigDecimal getPrice(final String symbol) {
  // return new BigDecimal(symbols.get(symbol));
  // }
}
