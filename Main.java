import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.opencsv.CSVReader;

public class Main {
    private final static String strNumbersPathname = "Numbers.csv";
    private final static String strResultsPathname = "Results.csv";    
    private static double[] arrDouble; 
    private final static int[] nNCounts = {10, 100, 1000, 10000};
    private static File fNumbers;
    private static FileReader frNumbers;
    private static FileWriter fwNumbers;
    private static CSVReader reader = null;  
    private static File fResults;
    private static FileWriter fwResults;

    private static void writeArrToResults () throws IOException
    {
        for(int i=1; i<=NumbersGenerator.N; i++)
        {
            fwResults.write(arrDouble[i] + "\n");
        }
    }

    private static void resetDoubles (int N) throws IOException
    {
        frwNumbers.seek(0);
        arrDouble = new double[NumbersGenerator.N+1];
        for (int i=1; i<=N; i++)
        {
            System.out.print(i);
            arrDouble[i]=frwNumbers.readDouble();
            System.out.print(": "+arrDouble + ", ");

        }
    }

    public static void run () throws IOException
    {
        frwNumbers = new RandomAccessFile (strNumbersPathname, "rw");

        fResults = new File(strResultsPathname);
        fwResults = new FileWriter(fResults);
        
        // Generate Random Real Numbers
        arrDouble = new double[NumbersGenerator.N+1];
        arrDouble = NumbersGenerator.generateRandomReal();
        for(int i=1; i<=NumbersGenerator.N; i++)
        {
            frwNumbers.writeChars(arrDouble[i]+",");
        }
        


        

        // Loop to all N Sizes
        for(int i=0; i<nNCounts.length; i++)
        {
            resetDoubles(nNCounts[i]);
            
            fwResults.write(SortingAlgorithms.INSERTION_SORT+ ": "+ InsertionSort.insertionSort(arrDouble, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults();
            
            fwResults.write("\n"); // Move to next row
        }
        

        fwResults.close();  // Close Results File Reader
        frwNumbers.close();  // Close Numbers File Reader&Writer
    }

    public static void main(String[] args) throws IOException
    {
        Main.run();
    }
}
