//Eyad Kathir 
// this code uses 117 randomly generated integers between 0-10000
// will print the results in p2output.txt file while having only 9 numbers per line 
// Will use Bubble sort, Selection Sort, Insertion Sort, Quick Sort , Merge Sort 
// Will keep track of the number of swaps and comparisons 

import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SortingAlgorithms {

    private static int swaps; // for counting the swaps 
    private static int comparisons; //for counting the comparisons

    // Method to fill the array with random numbers
    private static void fillArrayWithRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10001);
        }
    }

    // Implementing Bubble Sort Algorithm
    private static void bubbleSort(int[] array) {
        swaps = 0;
        comparisons = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    swaps++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //  Implementing Selection Sort Algorithm
    private static void selectionSort(int[] array) {
        swaps = 0;
        comparisons = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            swaps++;
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    //Implementing Insertion Sort Algorithm
    private static void insertionSort(int[] array) {
        swaps = 0;
        comparisons = 0;
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (array[j] > key) {
                    swaps++;
                    array[j + 1] = array[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    // Implementing Quick Sort Algorithm
    private static void quickSort(int[] array, int begin, int end) {
        swaps = 0;
        comparisons = 0;
        quickSortRecursive(array, begin, end);
    }

    private static void quickSortRecursive(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSortRecursive(array, begin, partitionIndex - 1);
            quickSortRecursive(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            comparisons++;
            if (array[j] <= pivot) {
                swaps++;
                i++;
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        swaps++;
        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;
        return i + 1;
    }

    //  Implementing Merge Sort Algorithm
    private static void mergeSort(int[] array, int l, int r) {
        swaps = 0;
        comparisons = 0;
        mergeSortRecursive(array, l, r);
    }

    private static void mergeSortRecursive(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortRecursive(array, l, m);
            mergeSortRecursive(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Main method to test the sorting algorithms
    public static void main(String[] args) {
        int[] randomNumbers = new int[117];
        fillArrayWithRandomNumbers(randomNumbers);

        try (PrintWriter out = new PrintWriter("p2Output.txt")) { //my object to write the sorting results
            // Bubble Sort
            int[] bubbleSorted = randomNumbers.clone();
            bubbleSort(bubbleSorted);
            saveArrayToFile(bubbleSorted, "Bubble Sort", out);// using out for printing to save the results to the p2 file

            // Selection Sort
            int[] selectionSorted = randomNumbers.clone();
            selectionSort(selectionSorted);
            saveArrayToFile(selectionSorted, "Selection Sort", out);// using out for printing to save the results to the p2 file

            // Insertion Sort
            int[] insertionSorted = randomNumbers.clone();
            insertionSort(insertionSorted);
            saveArrayToFile(insertionSorted, "Insertion Sort", out);// using out for printing to save the results to the p2 file

            // Quick Sort
            int[] quickSorted = randomNumbers.clone();
            quickSort(quickSorted, 0, quickSorted.length - 1);
            saveArrayToFile(quickSorted, "Quick Sort", out);// using out for printing to save the results to the p2 file

            // Merge Sort
            int[] mergeSorted = randomNumbers.clone();
            mergeSort(mergeSorted, 0, mergeSorted.length - 1);
            saveArrayToFile(mergeSorted, "Merge Sort", out);// using out for printing to save the results to the p2 file
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());// using catch method as throws statement for the printWriter method
        } // will use the System.out not out so the user sees the error instead of not getting error 
    }

    // Method to save the array to a file
    private static void saveArrayToFile(int[] array, String sortMethod, PrintWriter out) {
        out.println(sortMethod + " Results:");
        for (int i = 0; i < array.length; i++) {
            out.print(array[i] + " ");
            if ((i + 1) % 9 == 0) {
                out.println(); // using out.println instead of System.out.println to print in the file not the system output
            }
        }
        out.println("\nNumber of swaps: " + swaps); // using out.println instead of System.out.println to print in the file not the system output
        out.println("Number of comparisons: " + comparisons);// using out.println instead of System.out.println to print in the file not the system output
        out.println("--------------------------------------------");// using out.println instead of System.out.println to print in the file not the system output
    }
}
