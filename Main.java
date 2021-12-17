import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;  
import java.util.*;

public class Main {
    private final String strNumbersPathname = "Numbers.csv";
    private final String strResultsPathname = "Results.csv";    
    private double[] arrDoubleReserve; 
    private double[] arrDoubleMain;
    private final int[] nNCounts = {10, 100, 1000, 10000};
    private FileReader frNumbers;
    private PrintWriter pwNumbers;
    private File fResults;
    private FileWriter fwResults;
    private String strSplitBy = ",";

    private  void writeArrToResults (int N) throws IOException
    {
        for(int i=1; i<=N; i++)
        {
            fwResults.write(arrDoubleMain[i] + strSplitBy);
        }
        fwResults.write("\n");
    }

    private void hardCopy (double[] arrDouble, int N)
    {
        for (int i=1; i<=N; i++)
        {
            arrDouble[i]=arrDoubleReserve[i];
        }
    }

    private void hardCopyDescend (double[] arrDouble, int N)
    {
        
        for (int i=1; i<=N; i++)
        {
            arrDouble[i]=arrDoubleReserve[i];
        }
        // Sorting the array in descending order
        Arrays.sort(arrDouble);
        reverse(arrDouble);
    }
    public static void reverse(double[] array)
    {
  
        // Length of the array
        int n = array.length;
  
        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
  
            // Storing the first half elements temporarily
            double temp = array[i];
  
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
  
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

    public void run () throws IOException
    {
        pwNumbers = new PrintWriter(strNumbersPathname);
        
        // Generate Random Real Numbers
        arrDoubleReserve = new double[nNCounts[nNCounts.length-1]+1];
        arrDoubleReserve = NumbersGenerator.generateRandomReal(nNCounts[nNCounts.length-1]);

        frNumbers = new FileReader(strNumbersPathname);
        fResults = new File(strResultsPathname);
        fwResults = new FileWriter(fResults);

        


        

        // Loop to all N Sizes
        for(int i=0; i<nNCounts.length; i++)
        {
            arrDoubleMain = new double[nNCounts[i]+1];
            // Insertion Sort
            hardCopy(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," + SortingAlgorithms.INSERTION_SORT+ ","+ InsertionSort.insertionSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n"); // Move to next row

            // Selection Sort
            hardCopy(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," +SortingAlgorithms.SELECTION_SORT+ ","+ BubbleSort.bubbleSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n"); // Move to next row

            // Bubble Sort
            hardCopy(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," +SortingAlgorithms.BUBBLE_SORT+ ","+ BubbleSort.bubbleSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n\n"); // Move to next row
        }

        fwResults.write("\n\n\n\n");
        // B
        for(int i=0; i<nNCounts.length; i++)
        {
            arrDoubleMain = new double[nNCounts[i]+1];
            // Insertion Sort
            hardCopyDescend(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," + SortingAlgorithms.INSERTION_SORT+ ","+ InsertionSort.insertionSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n"); // Move to next row

            // Selection Sort
            hardCopyDescend(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," +SortingAlgorithms.SELECTION_SORT+ ","+ SelectionSort.selectionSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n"); // Move to next row

            // Bubble Sort
            hardCopyDescend(arrDoubleMain, nNCounts[i]);
            fwResults.write(nNCounts[i] +"," +SortingAlgorithms.BUBBLE_SORT+ ","+ BubbleSort.bubbleSort(arrDoubleMain, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults(nNCounts[i]);
            fwResults.write("\n\n"); // Move to next row
        }
        

        fwResults.close();  // Close Results File Reader
        frNumbers.close();  // Close Numbers File Reader&Writer
        
    }

    public static void main(String[] args) throws IOException
    {

        Main mMain = new Main();
        mMain.run();
    }
}
