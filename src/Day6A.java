import java.util.Scanner;

public class Day6A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int mu = scanner.nextInt();
        int sigma = scanner.nextInt();
        double mu_sum = n * mu;
        double sigma_sum = Math.sqrt(n) * sigma;

        double result = cdf(x, mu_sum, sigma_sum);
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 10_000) / 10_000;
    }

    // return pdf(x) = standard Gaussian pdf
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    // return cdf(z) = standard Gaussian cdf using Taylor approximation
    public static double cdf(double z) {
        if (z < -8.0) return 0.0;
        if (z >  8.0) return 1.0;
        double sum = 0.0, term = z;
        for (int i = 3; sum + term != sum; i += 2) {
            sum  = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + sum * pdf(z);
    }

    // return cdf(z, mu, sigma) = Gaussian cdf with mean mu and stddev sigma
    public static double cdf(double z, double mu, double sigma) {
        return cdf((z - mu) / sigma);
    }
}
