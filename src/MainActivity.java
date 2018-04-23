import java.util.Arrays;

public class MainActivity {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};    //6
//        int[] height = {4,2,3};   //1
        int[] height = {5, 4, 1, 2};    //0  //1+4=5-(3-1)-(3-(-2))=3-5
//        int[] height = {9, 6, 8, 8, 5, 6, 3};    //0  //1+4=5-(3-1)-(3-(-2))=3-5
//        2-4=-2 2-1=1 -1
        System.out.println(Arrays.toString(height));
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int length = height.length;
        int leftIdx = 0;
        int leftValue = -1;
        int currentValue;
        while (leftIdx < length) {
            currentValue = height[leftIdx];
            if (currentValue > leftValue) {
                leftValue = currentValue;
                leftIdx++;
            } else {
                break;
            }
        }

        int rightValue = -1;
        int rightIdx = length - 1;
        while (rightIdx >= leftIdx) {
            currentValue = height[rightIdx];
            if (currentValue > rightValue) {
                rightValue = currentValue;
                rightIdx--;
            } else {
                break;
            }
        }
        int result = 0;

        if (leftIdx < length) {
            int diff;
            int traceNumber = 0;
            for (int i = leftIdx; i <= rightIdx; i++) {
                currentValue = height[i];
                diff = leftValue - currentValue;
                if (diff > 0) {
                    traceNumber++;
                    result += diff;
                } else if (diff == 0) {
                    traceNumber = 0;
                } else {
                    traceNumber = 0;
                    leftValue = currentValue;
                }
            }
            diff = leftValue - rightValue;
            int lastIdx = rightIdx;
            int tempValue;
            if (diff > 0) {
                while (traceNumber > 0) {
                    tempValue = height[lastIdx--];
                    if (tempValue < rightValue) {
                        result += rightValue - leftValue;
                    } else {
                        rightValue = tempValue;
                        result += tempValue - leftValue;
                    }
                    traceNumber--;
                }
            }
        }
        return result;
    }

}
