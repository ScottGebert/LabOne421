package project1;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PickShareFunctional.findHighPrices(Shares.symbols.stream()));
		System.out.println(PickShareFunctional.findHighPrices(Shares.symbols.parallelStream()));
	}

}
