public class Day5D {
    public static void main(String[] args) {
        // What percentage scored higher than 80 in the exam?
        int mu = 70;
        int sigma = 10;
        double result = (1 - cdf(80, mu, sigma)) * 100;
        System.out.println(round(result));

        // Percentage with grade >= 60
        result = (1 - cdf(60, mu, sigma)) * 100;
        System.out.println(round(result));

        // Percentage failed the test (grade < 60)
        result = 100 - result;
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }

    // return pdf(x) = standard Gaussian pdf
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    // return pdf(x, mu, signma) = Gaussian pdf with mean mu and stddev sigma
    public static double pdf(double x, double mu, double sigma) {
        return pdf((x - mu) / sigma) / sigma;
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
