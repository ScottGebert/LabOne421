package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PickShareFunctionalTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		PickShareFunctional.init(Shares.symbols);
	}

	@Test
	void test_init() {		
		for (String share : PickShareFunctional.getSharePrices().keySet()) {
			assertTrue(Shares.symbols.contains(share), share + " is not in the share symbols list");
		}		
	}
	
	@Test
	void test_find_high_price() {
		ShareInfo highPrice = PickShareFunctional.findHighPrices(Shares.symbols.stream());
		
		double highest = 0;
		String highestShare = "";
		
		for (ShareInfo share : PickShareFunctional.getSharePrices().values()) {
			if (share.price.doubleValue() < 500 && share.price.doubleValue() > highest) {
				highest = share.price.doubleValue();
				highestShare = share.symbol;
			}
		}
		
		assertTrue(highest == highPrice.price.doubleValue() && highestShare.equals(highPrice.symbol), "Excected: " + new ShareInfo(highestShare, new BigDecimal(highest)) + "\nActual: " + highPrice);
	}

}
