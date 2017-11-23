package accepted.Q001_Q100.Q041_Q050;

public class Q050 {
	
	public double pow(double x, int n) {

		int m = (n < 0) ? -n : n;
		double result;

		if (m == 0) {
			result = 1;
		} else if (m == 1) {
			result = x;
		} else {
			result = m % 2 == 0 ? pow(x * x, m / 2) : pow(x * x, m / 2) * x;
		}
		return (n < 0) ? 1 / result : result;
	}
	
}
