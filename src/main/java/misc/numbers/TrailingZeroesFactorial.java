package misc.numbers;

public class TrailingZeroesFactorial {
	public static void main(String[] args){
		int n = 11;
		int twos = 0;
		int fives = 0;
		for(int i=2;i<=n;i+=2){
			int j = i;
			while(j>0 && j%2==0){
				twos++;
				j = j%2;
			}
		// System.out.println("Twos = "+twos);
		}
		
		for(int i=5;i<=n;i+=5){
			int j = i;
			while(j>0 && j%5==0){
				fives++;
				j = j%5;
			}
			// System.out.println("fives = "+fives);
		}
		
		System.out.println(Math.min(twos,fives));
	}
}
