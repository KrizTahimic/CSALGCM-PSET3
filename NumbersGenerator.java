import java.util.Random;

public class NumbersGenerator {

    public static double[] generateRandomReal(int N)
    {
        double[] arrDouble = new double[N+1]; // +1 bec req to start with index 1
        double fUpperBound = (double)1.0;
        Random rand = new Random();
        for(int i=1; i<=N; i++)
        {
            arrDouble[i]=rand.nextDouble(fUpperBound);
        }

        return arrDouble;
    }

    public static double[] ascendingReal(double[] arrDouble)
    {

        return arrDouble;
    }
}
