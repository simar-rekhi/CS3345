// deploying recursion-based algorithm to find the maximum subsequence sum of an array
public class recursive_algo {

    public static int maxSubSequenceSum(int[] arr, int left_index, int right_index) {

        //defining base case
        if (left_index == right_index) {
            if (arr[left_index] > 0) {
                return arr[left_index];
            } else {
                return 0;
            }
        }

        // building our recursive case
        // step 1: dividing in the middle
        int middle_index = (left_index + right_index) / 2;
        int maxLeft = maxSubSequenceSum(arr, left_index, middle_index);
        int maxRight = maxSubSequenceSum(arr, middle_index + 1, right_index);

        // step 2: after calculating absolute right and left subsequence sums, we also need to find the across sum
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        int maxRightBorderSum = 0, rightBorderSum = 0;

        for (int i = middle_index; i >= left_index; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        for (int i = middle_index + 1; i <= right_index; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeft, maxRight, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] arr = {-2, 11, -4, 13, -5, -2};
        int maxSum = maxSubSequenceSum(arr, 0, arr.length - 1);
        System.out.println("Maximum Subsequence Sum is: " + maxSum);
    }
}