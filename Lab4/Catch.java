

public class Catch {
    public static int binary_search(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if(guess == item)
                return mid;
            if(guess > item)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] list = new int[10];
        for(int i = 0; i < 10; i++)
            list[i] = i;
        System.out.println(binary_search(list, 7));
        System.out.println(binary_search(list, -1));
    }
}
