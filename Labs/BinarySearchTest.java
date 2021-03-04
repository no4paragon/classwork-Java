import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        //int[] aiNumbers = new int[100];
        BinarySearchTest oTest = new BinarySearchTest();

        String[] asWords= new String[10];
        asWords[0] = "Word 1";
        asWords[1] = "Word 2";
        asWords[2] = "Word 3";
        asWords[3] = "Word 4";
        asWords[4] = "Word 5";
        asWords[5] = "Word 6";
        asWords[6] = "Word 7";
        asWords[7] = "Word 8";
        asWords[8] = "Word 9";
        asWords[9] = "Word 10";

        Arrays.sort(asWords);
        String iTargetName = "Word 5";

        long startTime;
        long elapsedTime;
        int iTargetIndex;

        //***********************************************//
        //***BEGIN Measure Binary Search First***

        startTime = System.nanoTime();
        iTargetIndex = oTest.findNumberBinarySearch(asWords, iTargetName, 0, asWords.length - 1);
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Binary Search Time: " + elapsedTime);


        //***End Measure Binary Search First***
        //***********************************************//

        //***********************************************//
        //***BEGIN Measure Linear Search Second***

        startTime = System.nanoTime();
        iTargetIndex = oTest.findNumberLinearSearch(asWords, iTargetName);
        elapsedTime = System.nanoTime() - startTime;

        //***End Measure Linear Search Second***

        //***********************************************//
        System.out.println("Linear Search Time: " + elapsedTime);


    }

    //Use recursive binary search to find index of target number.
    private int findNumberBinarySearch(String[] asNames, String iTarget, int iLow, int iHigh) {
        //find the middle index.
        int iMiddleIndex = (iLow + iHigh) / 2;
        //Check if value at middle index is target.
        if (asNames[iMiddleIndex].equals(iTarget)) {
            return iMiddleIndex;
        }
        //check if target is greater than value at middle index.
        else if (asNames[iMiddleIndex].compareTo(iTarget) > 0) {
            //Recursively call this method with new params.
            return findNumberBinarySearch(asNames, iTarget, iLow, iMiddleIndex - 1);
        }
        //check if target is less than value at middle index.
        else {
            //Recursively call this method with new params.
            return findNumberBinarySearch(asNames, iTarget, iMiddleIndex + 1, iHigh);

        }
    }

    private int findNumberLinearSearch(String[] asNames, String iTarget){
        //Loop through array and find target number.
        for (int i = 0; i < asNames.length; i++){
            if (iTarget.equals(asNames[i])){
                return i;
            }
        }
        return -1;
    }
}

