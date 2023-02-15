package project1;

public class test {
  private static long startTime;
  private static long endTime;

	public static void main(String[] args) {
		PickShareFunctional.init(Shares.symbols);
		
	    // Part B
	    startTime = System.nanoTime();
	    System.out.println("Starting");
	    ShareInfo pricesStream = PickShareFunctional.findHighPrices(Shares.symbols.stream());
	    endTime = System.nanoTime();
	    printTime("findHighPrices time using stream: ");
	    System.out.println(pricesStream);
	
	    // Part C
	    startTime = System.nanoTime();
	    ShareInfo pricesParallelStream = PickShareFunctional.findHighPrices(Shares.symbols.stream());
	    endTime = System.nanoTime();
	    printTime("findHighPrices time using parallel stream: ");
	    System.out.println(pricesParallelStream);
	}

  private static void printTime(String messgae) {
    System.out.println(messgae + ((endTime - startTime)/1000000) + "ms");
  }

}
