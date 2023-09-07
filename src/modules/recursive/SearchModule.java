package modules.recursive;

public class SearchModule {

    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int target, int min, int max) {
        int mid;

        if(min > max ){
            return - 1;
        }else{
            mid = (min + max) / 2;

            if(data[mid] < target)
                return binarySearch(data, target, mid + 1, max);

            else if(data[mid] > target)
                return binarySearch(data, target, min, mid - 1);

            else
                return mid;
        }
    }

}
