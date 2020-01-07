package lab01;

public class CoinFlipExperiment {
	public static void main(String[] args) {
		int amount = coinFlipExperiment();
		System.out.println("Win/loss amount: " + amount);
	}
	
	static public int coinFlipExperiment() {
		int count = 0, winnings = 0;
		double flip = Math.random();
		while (count <= 100) {
		  if (flip < 0.505) {
		    winnings++;
		  }
		  else {
		    winnings--;
		  }
		  count++;
		  flip = Math.random();
		}
		return winnings;
	}
}
