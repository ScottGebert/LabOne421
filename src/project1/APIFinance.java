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

public class APIFinance {
//	private static final String BASE_URL = "https://www.alphavantage.co/query?";
//	private final static String apiKey = "YOUR_API_KEY_HERE";
//	
//	public static BigDecimal getPrice(final String symbol) {
//		BigDecimal price = new BigDecimal(0);
//		try {
//			URL url = new URL(BASE_URL + "function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey);
//			URLConnection connection = url.openConnection();
//			InputStreamReader inputStream = new	InputStreamReader(connection.getInputStream(), "UTF-8");
//			BufferedReader bufferedReader = new	BufferedReader(inputStream);
//			
//			String line;
//			while ((line = bufferedReader.readLine()) != null) {
//				if (line.contains("price")) {
//					price = new BigDecimal(line.split("\"")[3].trim());
//				}
//			}
//		} 
//		catch (IOException e) {
//			System.out.println("failure sending request");
//		}
//		
//		return price;
//	}

	public static final Map<String, Integer> symbols = Map.of("IBM", Integer.valueOf(100),
																"AAPL", Integer.valueOf(200),
																"AMZN", Integer.valueOf(300),
																"CSCO", Integer.valueOf(400),
																"SNE", Integer.valueOf(500), 
																"GOOG", Integer.valueOf(600),
																"MSFT", Integer.valueOf(700),
																"ORCL", Integer.valueOf(800),
																"FB", Integer.valueOf(900),
																"VRS", Integer.valueOf(1000));
	public static BigDecimal getPrice(final String symbol) {
		return new BigDecimal(symbols.get(symbol));
	}
}
