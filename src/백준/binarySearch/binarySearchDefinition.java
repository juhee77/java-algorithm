package 백준.binarySearch;

public class binarySearchDefinition {
    public static int binarySearch(int[] arr, int start, int end, int goal) {
        if (start > end) return -1;

        int mid = (start + end) / 2; //or (start+end) >> 1;
        if (arr[mid] == goal)
            return mid;
        else if (arr[mid] > goal)
            return binarySearch(arr, start, mid - 1, goal);
        else
            return binarySearch(arr, mid + 1, end, goal);

    }

    public static int binarySearch2(int[] arr, int start, int end, int goal) {

        while (start <= end) {
            int mid = (start + end) / 2; //or (start+end) >> 1;
            if (arr[mid] == goal)
                return mid;
            else if (arr[mid] > goal)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4,7,9,21,35,47,58,72};
        System.out.println(binarySearch(arr,0,arr.length-1,35));
        System.out.println(binarySearch2(arr,0,arr.length-1,35));
    }
}
