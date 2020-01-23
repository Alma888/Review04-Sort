public class QuickSort {

    public static void quickSort(int[] array) {
        quickSortInter(array, 0, array.length - 1);
    }

    // [left, right]
    private static void quickSortInter(int[] a, int left, int right) {
        if (left >= right) {
            // 直到 长度 <= 1
            return;
        }
        // 1. 选择基准值 array[left]
        // 2. 做 partition
        int pivotIndex = partition1(a, left, right);
        // 左边小区间 [left, pivotIndex - 1]
        // 右边小区间 [pivotIndex + 1, right]
        // 3. 分别对左右小区间按同样方式处理
        quickSortInter(a, left, pivotIndex - 1);
        quickSortInter(a, pivotIndex + 1, right);
    }
    private static int partition1(int[] a, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = a[left];
        // [left, begin)        <= pivot
        // (end, right]         >= pivot
        while (begin < end) {
            while (begin < end && a[end] >= pivot) {
                end--;
            }
            while (begin < end && a[begin] <= pivot) {
                begin++;
            }
            swap(a, begin, end);
        }
        swap(a, left, begin);
        return begin;
    }

    //partition 之挖坑法
    private static int partition2(int[] a, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = a[left];
        // [left, begin)        <= pivot
        // (end, right]         >= pivot
        while (begin < end) {
            while (begin < end && a[end] >= pivot) {
                end--;
            }
            a[begin]=a[end];  //不断填坑
            while (begin < end && a[begin] <= pivot) {
                begin++;
            }
            a[begin]=pivot;      //最后填坑
            swap(a, begin, end);
        }
        swap(a, left, begin);
        return begin;
    }

    //partition 之前后下标法
    private static int partition3(int[] a, int left, int right) {
        // array[left]
        // [left + 1, right]
        int pivot = a[left];
        int d = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] < pivot) {
                swap(a, i, d++);
            }
        }

        swap(a, d - 1, left);
        return d - 1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
