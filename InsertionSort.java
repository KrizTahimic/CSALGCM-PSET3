class InsertionSort
{
    public static long insertionSort(double[] number, int N)
    {
        long lInsertionSortCtr = 0;
        double key;
        int j,i;

        for (j = 2; j <= N; j++)
        { 
            key = number[j];
            for (i = j-1; i>0 ; i--)
            {
                lInsertionSortCtr++;
                if(number[i] > key)
                {
                    number[i+1] = number[i];
                }
                
            }
            number[i+1] = key;
        }

        return lInsertionSortCtr;
    }
}