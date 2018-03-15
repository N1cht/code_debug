package dataStructure.sort;

/**
 * Created by Sou1AtLab on 2018/3/12 0012.
 */
public class SortUtils {

    public static void main(String[] args) {
        int[] arr = new int[]{49,38,65,97,76,13,27,49};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] insertSort(int[] array){

        int length = array.length;
        if(length <= 1) return array;
        int temp;
        for(int i = 1;i < length; i++){
            temp = array[i];//哨兵
            for(int j = i - 1; j >= 0; j--){
                if(temp < array[j]){
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    //optimization: in each iteration get the max and the min number in array and then change their position.
    public static int[] selectSort(int[] array){

        int length = array.length;
        if(length <= 1) return array;

        int currentMinIndex = 0;
        for (int i = 0; i < length - 1; i++) {
            int temp = array[i];
            currentMinIndex = i;
            for (int j = i + 1; j < length; j++) {
                if(array [j] <= array[currentMinIndex]){
                    currentMinIndex = j;
                }
            }
            array[i] = array[currentMinIndex];
            array[currentMinIndex] = temp;
        }

        return array;
    }

    //optimization: if there is no swap between adjacent numbers in a iteration, the array is sorted already.
    public static int[] bubbleSort(int[] array){
        int length = array.length;
        if(length <= 1) return array;
        for (int i = length - 1; i > 0; i--) {
            int temp = 0;
            //boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //flag = true;
                }
            }

            //if (falg) break;
        }

        return array;
    }

    //use the maxHeap and minHeap to get array sorted asc or des.
    public static int[] heapSort(int[] array){

        int length = array.length;
        if(length <= 1) return array;

        for (int i = length - 1; i > 0 ; i--) {
            maxHeapSort(array, i);
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
        }

        return array;
    }

    //optimization: in each iteration chose three elements and sort them, use the median element as the guard.
    public static int[] quickSort(int[] array){

        partitionSort(array, 0, array.length - 1);
        return array;
    }


    private static void partitionSort(int[] array, int startIndex, int endIndex){

        if (startIndex >= endIndex) return;
        int guard = array[startIndex];

        int left = startIndex;
        int right = endIndex;
        while (left != right){

            while (left < right && array[right] >= guard){
                right--;
            }
            while (left < right && array[left] <= guard){
                left++;
            }

            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = guard;

        partitionSort(array, startIndex, left - 1);
        partitionSort(array, left + 1, endIndex);
    }

    private static void maxHeapSort(int[] array, int endIndex){

        if (endIndex >= 1 && endIndex <= array.length){
            for (int i = endIndex; i >= 0; i--) {
                int temp = array[i];
                if (array[(i - 1) / 2] < array[i]){
                    array[i] = array[(i - 1) / 2];
                    array[(i - 1) / 2] = temp;
                }
            }
        }
    }

    private static void minHeapSort(int[] array){
         int length = array.length;
         if (length > 1){
             for (int i = length - 1; i > 0; i--) {
                 int temp = array[i];
                 if (array[(i - 1) / 2] > array[i]){
                     array[i] = array[(i - 1) / 2];
                     array[(i - 1) / 2] = temp;
                 }
             }
         }
    }
}
