public class BubbleSort {
    public static long bubbleSort(double[] numbers, int N)
    {
        long lBubbleSortCtr = 0;
        int j,i;

        for (i = N; i >= 1; i--)
        {
            for (j = 2; j <= i; j++)
            {
                lBubbleSortCtr++;
                if (numbers[j-1] > numbers[j])
                {
                    //swap(numbers[j-1], numbers[j]);
                    double dTemp;
                    dTemp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] =dTemp;

                }
            }
        }

        return lBubbleSortCtr;
    }
}
