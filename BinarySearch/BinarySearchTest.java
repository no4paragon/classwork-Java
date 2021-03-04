import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        int[] aiNumbers = new int[100];
        BinarySearchTest oTest = new BinarySearchTest();
        int iTargetIndex;

        for (int x = 0; x < aiNumbers.length; x++) {
            aiNumbers[x] = oRand.nextInt();
        }
        Arrays.sort(aiNumbers);
        int iRandIndex = oRand.nextInt(aiNumbers.length);
        int iTargetNum = aiNumbers[iRandIndex];
        System.out.println("Target num: " + iTargetNum);

        //int iTargetIndex = oTest.findNumberBinarySearch(aiNumbers, iTargetNum, 0, aiNumbers.length - 1);
        //System.out.println("B-Search Answer: " + iTargetIndex);
        //System.out.println("Target Index: " + iRandIndex);

        //Millis since 1970(epoch)
        System.out.println(System.currentTimeMillis());

        long startTime;
        long elapsedTime;

        //***********************************************//
        //***BEGIN Measure Binary Search First***

        startTime = System.nanoTime();
        elapsedTime = System.nanoTime() - startTime;
        iTargetIndex = oTest.findNumberBinarySearch(aiNumbers, iTargetNum, 0, aiNumbers.length - 1);

        System.out.println("Binary Search Time: " + elapsedTime);


        //***End Measure Binary Search First***
        //***********************************************//

        //***********************************************//
        //***BEGIN Measure Linear Search Second***

        startTime = System.nanoTime();
        elapsedTime = System.nanoTime() - startTime;
        iTargetIndex = oTest.findNumberLinerSearch(aiNumbers, iTargetNum);

        //***End Measure Linear Search Second***

        //***********************************************//
        System.out.println("Linear Search Time: " + elapsedTime);


    }

    //Use recursive binary search to find index of target number.
    private int findNumberBinarySearch(int[] aiNumbers, int iTarget, int iLow, int iHigh) {
        //find the middle index.
        int iMiddleIndex = (iLow + iHigh) / 2;
        //Check if value at middle index is target.
        if (aiNumbers[iMiddleIndex] == iTarget) {
            return iMiddleIndex;
        }
        //check if target is greater than value at middle index.
        else if (iTarget > aiNumbers[iMiddleIndex]) {
            //Recursively call this method with new params.
            return findNumberBinarySearch(aiNumbers, iTarget, iMiddleIndex + 1, iHigh);
        }
        //check if target is less than value at middle index.
        else {
            //Recursively call this method with new params.
            return findNumberBinarySearch(aiNumbers, iTarget, iLow, iMiddleIndex - 1);
        }
    }

    private int findNumberLinerSearch(int[] aiNumbers, int iTarget){
        //Loop through array and find target number.
        for (int i = 0; i < aiNumbers.length; i++){
            if (iTarget == aiNumbers[i]){
                return i;
            }
        }
        return -1;
    }
}

