public class SelectionSort {
    public static long selectionSort(double[] numbers, int N)
    {
        long lSelectionSortCtr = 0;
        int j,i,m;

        for (i = 1; i <= N; i++)
        { 
            m = i;
            for (j = i+1; j <= N; j++)
            {
                lSelectionSortCtr++;
                if (numbers[j] < numbers[m])
                {
                    m = j; 
                }
            }
            
            //swap (numbers[i], numbers[m]);
            double dTemp;
            dTemp = numbers[i];
            numbers[i] = numbers[m];
            numbers[m] =dTemp;
        }

        return lSelectionSortCtr;
    }
}
