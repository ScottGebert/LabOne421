package project1;

public class test {
  private static long startTime;
  private static long endTime;

	public static void main(String[] args) {
		PickShareFunctional.init(Shares.symbols);
      int iterations = 3;
      ShareInfo p = null;
		
	    // Part B
      long totalTime = 0;
      for (int i = 0; i<iterations; i++) {
	    startTime = System.nanoTime();
        p = PickShareFunctional.findHighPrices(Shares.symbols.stream());
        endTime = System.nanoTime();
        totalTime += getTime();
      }
      System.out.println("Streamy High Priced Share: "+ p.toString());
	    printTime("findHighPrices time using stream: ", totalTime/iterations);
	
	    // Part C
      totalTime = 0;
      for (int i = 0; i<iterations; i++) {
        startTime = System.nanoTime();
        p = PickShareFunctional.findHighPrices(Shares.symbols.stream());
        endTime = System.nanoTime();
        totalTime += getTime();
      }
      System.out.println("Parallel Stream High Priced Share: "+ p.toString());
	    printTime("findHighPrices time using parallel stream: ", totalTime/iterations);

	}

  private static void printTime(String messgae, long time) {
    System.out.println(messgae + (time) + "ns");
  }

  private static long getTime() {
    return endTime - startTime;
  }

}
