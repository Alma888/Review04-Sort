import java.util.Arrays;

public class Sort {

  //直接插入排序
      //将无需区间的第一个数取出插入到有序区间中合适的位置去
    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){//无序区间
            //有序[0,i)
            //无序[i,array.length)
            int key=array[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(array[j]<=key){
                    break;
                }else {
                    array[j+1]=array[j];
                }
            }
            /**
             * 时间复杂度
             * 最好       平均          最坏
             * O(n)       O(n^2)        O(n^2
             * 数据有序                 数据逆序
             * 空间复杂度
             * O(1)
             * @param array
             */
            array[j+1]=key;
        }

    }

    public static void insertSort1(int[] array){
        for(int i=1;i<array.length;i++){//无序区间
            //有序[0,i)
            //无序[i,array.length)
            int key=array[i];
            int j=0;
            for(j=i-1;j>=0&&array[j]>key;j--){
                    array[j+1]=array[j];
            }
            array[j+1]=key;
        }

    }

    //希尔排序：将直接插排程序中的  -1换成-gap  即可
    public static void shellSort(int[] array){
        int gap=array.length;
        while (true){
            gap=(gap/3)+1;
            //gap=gap/2;
            insertSortWithGap(array,gap);
            if(gap==1){
                break;
            }
        }
    }
     public static void insertSortWithGap(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {//无序区间
            int key = array[i];
            int j = 0;
            for (j = i - gap; j >= 0 && array[j] > key; j -= gap) {
                array[j + gap] = array[j];

            }
            array[j + gap] = key;
        }
    }

    //直接选择排序
    public static void selectSort1(int[] array){
        //每次选择最大的数放到无序区间的最后
        for(int i=0;i<array.length-1;i++){
            //无序区间[0,array.length-i）
            //有序区间[array.length-i,array.length）
            int maxIndex=0;
            for(int j=1;j<array.length-i;j++){//无序区间遍历
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            swap(array,maxIndex,array.length-i-1);
        }
    }

    private static void swap(int[] array, int maxIndex, int i) {
        int t=array[maxIndex];
        array[maxIndex]=array[i];
        array[i]=t;
    }
    public static void selectSort2(int[] array){
        //每次选择最小的数字放到无序区间的最前面
        for (int i = 1; i < array.length ; i++) {
            //上面循环不管区间是[0，length-1)还是[1，length)，只要保证循环N-1次就行
            //有序区间[0，i-1)
            // 无序区间 [i-1, array.length)
            int minIndex = i-1;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i-1);
        }
    }

    //双向选择排序
    public static void selectSort3(int[] array){
        //每次同时选择出 最大值和最小值，
        // 将最大值放到无序区间最后面。
        // 将最小值放到无序区间最前面
        //无序区间：[begin,end]
        int begin=0;
        int end=array.length-1;
        //当无序区间只剩1个数就可以停下来，也就是begin==end
        while (begin<end){
            int maxIndex=begin;
            int minIndex=begin;
            for(int j=begin+1;j<end;j++){
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,minIndex,begin);
            if(maxIndex==begin){//***********细节处理***********
                maxIndex=minIndex;
            }
            swap(array,maxIndex,end);
            begin++;
            end--;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        //先升序建大堆
        createHeapBig(array);
        for (int i = 0; i < array.length - 1; i++) {
            // 无序 [0, array.length - i)
            // 交换 array[0], array[length - i - 1]
            // 无序 [0, array.length - i - 1)
            // 无序长度 array.length - i - 1
            // 下标 0 进行向下调整
            swap(array, 0, array.length - i - 1);
            shiftDownBig(array, 0, array.length - i - 1);
        }
    }

    private static void createHeapBig(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDownBig(array, i, array.length);
        }
    }

    //向下调整为大堆
    private static void shiftDownBig(int[] array, int i, int size) {
        while (2 * i + 1 < size) {
            int max = 2 * i + 1;
            if (max + 1 < size && array[max+1] > array[max]) {
                max = max + 1;
            }
            if (array[i] >= array[max]) {
                return;
            }
            swap(array, i, max);
            i = max;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSort = false;
                }
            }
            if (isSort) {
                return;
            }
        }
    }
        //测试以上方法代码的正确性（测试用例）
    public static void testRight(){
        int[] a = { 2, 3, 7, 9, 4, 5, 6, 9, 1, 4, 7, 8 };
        int[] b=a.clone();
       // insertSort(b);
       // shellSort(b);
       //selectSort1(b);
        selectSort2(b);
        System.out.println(Arrays.toString(b));

        int[] c=a.clone();
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        //数组的判断有它的特殊性，需要调Arrays.equal()方法
        System.out.println(Arrays.equals(b,c));

    }
    public static void main(String[] args) {
        testRight();

    }
}
