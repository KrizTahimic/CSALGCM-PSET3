import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;  

public class Main {
    private final String strNumbersPathname = "Numbers.csv";
    private final String strResultsPathname = "Results.csv";    
    private double[] arrDouble; 
    private final int[] nNCounts = {10, 100, 1000, 10000};
    private FileReader frNumbers;
    private PrintWriter pwNumbers;
    private File fResults;
    private FileWriter fwResults;
    private String strSplitBy = ",";

    private  void writeArrToResults () throws IOException
    {
        for(int i=1; i<=NumbersGenerator.N; i++)
        {
            fwResults.write(arrDouble[i] + "\n");
        }
    }

    private void resetDoubles (int N) throws IOException
    {
        BufferedReader brNumbers = new BufferedReader(frNumbers);
        System.out.println("%%%%%%%%%%%%%%" + brNumbers.readLine());

        String strTemp = new String();
        
        arrDouble = new double[NumbersGenerator.N+1];
        if((strTemp=brNumbers.readLine()) != null)
        {
            String[] strTempLine = brNumbers.readLine().split(strSplitBy);
            for (int i=1; i<=N; i++)
            {
                System.out.print(i);
                arrDouble[i]=Double.parseDouble(strTempLine[i-1]);
                System.out.print(": "+arrDouble + ", ");
            }
        }
        else
        {
            System.out.println("Null Buffered Reader");
        }
        
        brNumbers.close();

    }

    public void run () throws IOException
    {
        pwNumbers = new PrintWriter(strNumbersPathname);
        
        // Generate Random Real Numbers
        arrDouble = new double[NumbersGenerator.N+1];
        arrDouble = NumbersGenerator.generateRandomReal();

        StringBuilder strbDoubles = new StringBuilder();
        for(int i=1; i<=NumbersGenerator.N; i++)
        {
            strbDoubles.append(arrDouble[i]+",");
            System.out.println(arrDouble[i]+",");
        }
        pwNumbers.write(strbDoubles.toString());
        pwNumbers.close();

        frNumbers = new FileReader(strNumbersPathname);
        fResults = new File(strResultsPathname);
        fwResults = new FileWriter(fResults);

        System.out.println(strbDoubles);
        BufferedReader brNumbers = new BufferedReader(frNumbers);
        System.out.println("$$$$$$$$$$$" + brNumbers.readLine());
        strbDoubles = null;
        


        

        // Loop to all N Sizes
        for(int i=0; i<nNCounts.length; i++)
        {
            resetDoubles(nNCounts[i]);
            
            fwResults.write(SortingAlgorithms.INSERTION_SORT+ ": "+ InsertionSort.insertionSort(arrDouble, nNCounts[i]) + ","); // Write to Results File
            writeArrToResults();
            
            fwResults.write("\n"); // Move to next row
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
