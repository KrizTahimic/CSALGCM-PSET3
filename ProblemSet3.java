import java.util.*;

public class ProblemSet3 
{
    /*
    shellSort #2
    private static void insertionSort(Integer numbers[], int N, int h)
    {
        int key, j, i;
        
        for(j = h; j < N; i++)
        {
            key = numbers[j];
            for(i = j; i >= h && numbers[i - h] > key; i=-h)
            {
                numbers[i] = numbers[i - h];
            }
            numbers[i] = key;
        }

        insertionSort (numbers[], N, h)
        for (j = h; j <= N; j++)
        {   
            key = numbers[j];
            for (i = j; i >= h && numbers[i - h] > key; i=-h)
                numbers[i] = numbers[i - h];
            numbers [i] = key;
        }
    }*/

    private static int nInsertionSortCtr = 0;
    private static void insertionSort(Float numbers[], int N)
    {
        float key;
        int j, i;
        for(j = 1; j < N; j++)
        {
            key = numbers[j];
            for(i = j - 1; i > -1; i--)
            {
                if(numbers[i] > key)
                {
                    nInsertionSortCtr++;
                    numbers[i + 1] = numbers[i];
                }
            }
            numbers[i + 1] = key;
        }
    }

    private static int nSelectionSortCtr = 0;
    private static void selectionSort(Float numbers[], int N)
    {
        int i, m, j;
        float temp;
        for(i = 0; i < N; i++)
        {
            m = i;
            for(j = i + 1; j < N; j++)
            {
                if(numbers[j] < numbers[m])
                {
                    nSelectionSortCtr++;
                    m = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[m];
            numbers[m] = temp;
        }
    }

    private static int nBubbleSortCtr = 0;
    private static void bubbleSort(Float numbers[], int N)
    {
        int i, j;
        float temp;
        for(i = N; i >= 0; i--)
        {
            for(j = 1; j < i; j++)
            {
                if(numbers[j - 1] > numbers[j])
                {
                    nBubbleSortCtr++;
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void sortAndPrintResults(String strItem, int N, Float numbers[], Float numbers1[], Float numbers2[], Float numbers3[])
    {
        insertionSort(numbers1, N);
        selectionSort(numbers2, N);
        bubbleSort(numbers3, N);
        System.out.println(strItem);
        System.out.println("insertionSort = " + nInsertionSortCtr);
        System.out.println("selectionSort = " + nSelectionSortCtr);
        System.out.println("bubbleSort = " + nBubbleSortCtr + "\n");
        nInsertionSortCtr = 0;
        nSelectionSortCtr = 0;
        nBubbleSortCtr = 0;
        for(int i = 0; i < N; i++)
        {
            numbers1[i] = numbers[i];
            numbers2[i] = numbers[i];
            numbers3[i] = numbers[i];
        }
    }

    public static void main(String[] args)
    {
        Random rand = new Random();
        int N = 10; //number of elements in array
        Float[] numbers = new Float[N];
        Float[] numbers1 = new Float[N];
        Float[] numbers2 = new Float[N];
        Float[] numbers3 = new Float[N];
        for(int i = 0; i < N; i++)
        {
            numbers[i] = 0 + rand.nextFloat() * (1-0); //generate a pseudo-random num from 0 to 1
            numbers1[i] = numbers[i];
            numbers2[i] = numbers[i];
            numbers3[i] = numbers[i];
            //System.out.print(numbers[i] + "|"); //checker of array elements
        }
        //System.out.println();

        //A - pseudo-random numbers from 0 to 1
        sortAndPrintResults("A.)", N, numbers, numbers1, numbers2, numbers3);

        //B - same set of numbers but arranged in descending order
        Arrays.sort(numbers1, Collections.reverseOrder());
        Arrays.sort(numbers2, Collections.reverseOrder());
        Arrays.sort(numbers3, Collections.reverseOrder());
        sortAndPrintResults("B.)", N, numbers, numbers1, numbers2, numbers3);

        //C - last 40% of numbers arranged in ascending order
        Arrays.sort(numbers1, (int) (0.4 * N) - 1, N - 1);
        Arrays.sort(numbers2, (int) (0.4 * N) - 1, N - 1);
        Arrays.sort(numbers3, (int) (0.4 * N) - 1, N - 1);
        sortAndPrintResults("C.)", N, numbers, numbers1, numbers2, numbers3);
    }
}

/* 10
A.)
insertionSort = 26
selectionSort = 14
bubbleSort = 23

B.)
insertionSort = 45
selectionSort = 25
bubbleSort = 45

C.)
insertionSort = 14
selectionSort = 8
bubbleSort = 12*/

/*100
A.)
insertionSort = 4066
selectionSort = 326
bubbleSort = 2495

B.)
insertionSort = 4945
selectionSort = 2357
bubbleSort = 4944

C.)
insertionSort = 3112
selectionSort = 299
bubbleSort = 1656*/

/*1 000
A.)
insertionSort = 479542
selectionSort = 5273
bubbleSort = 245766

B.)
insertionSort = 499136
selectionSort = 160781
bubbleSort = 499020

C.)
insertionSort = 362915
selectionSort = 4965
bubbleSort = 154525*/

/*10 000
A.)
insertionSort = 49224640
selectionSort = 63537
bubbleSort = 25158858

B.)
insertionSort = 49985955
selectionSort = 2539368
bubbleSort = 49945066

C.)
insertionSort = 49029973
selectionSort = 62869
bubbleSort = 16150845*/