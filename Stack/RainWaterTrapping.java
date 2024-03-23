public class RainWaterTrapping {

   /* Given an array of N non-negative integers arr[] representing an elevation map where
    the width of each bar is 1, compute how much water it is able to trap after raining.*/
    public static void main(String[] args) {
        int arr[] = {3, 0, 0, 2, 0, 4};
        System.out.print("Water: " + getRailWaterTrapping(arr));
    }

    private static int getRailWaterTrapping(int[] arr) {

        int[] maxLeft = getMaxLeft(arr);
        int[] maxRight = getMaxRight(arr);
        int water = 0;

        for (int i = 0; i < arr.length; i++) {
            water += ((Math.min(maxLeft[i], maxRight[i]) - arr[i]));
        }
        return water;

    }

    private static int[] getMaxLeft(int[] arr) {
        int[] mxLeft = new int[arr.length];
        mxLeft[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            mxLeft[i] = (Math.max(mxLeft[i - 1], arr[i]));
        }
        return mxLeft;
    }

    private static int[] getMaxRight(int[] arr) {
        int[] mxRight = new int[arr.length];
        mxRight[arr.length - 1] = (arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            mxRight[i] = Math.max(mxRight[i + 1], arr[i]);
        }
        return mxRight;
    }
}
