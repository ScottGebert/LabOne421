package project1;

public class test {
  private static long startTime;
  private static long endTime;

	public static void main(String[] args) {
    // Part B
    startTime = System.nanoTime();
    ShareInfo pricesStream = PickShareFunctional.findHighPrices(Shares.symbols.stream());
    endTime = System.nanoTime();
    printTime("findHighPrices time using stream: ");

    // Part C
    startTime = System.nanoTime();
    ShareInfo pricesParallelStream = PickShareFunctional.findHighPrices(Shares.symbols.stream());
    endTime = System.nanoTime();
    printTime("findHighPrices time using parallel stream: ");

		System.out.println(PickShareFunctional.findHighPrices(Shares.symbols.stream()));
		System.out.println(PickShareFunctional.findHighPrices(Shares.symbols.parallelStream()));
	}

  private static void printTime(String messgae) {
    System.out.println(messgae + ((endTime - startTime)/1000000) + "ms");
  }

}
