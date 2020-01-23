import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StudentSort {

    //方式1:假定该Student类是有比较器的，将student强转为Comparable<Student>类型
    public static void insertSort(Student[] students) {//插排
        for (int i = 1; i < students.length; i++) {
            Student k = students[i];
            int j = i - 1;
            //注意下面循环里的约束条件：引用的比较  不能直接student[j]>k
            //而要传入Comparable接口
            for (; j >= 0 && ((Comparable<Student>)students[j]).compareTo(k) > 0; j--) {
                students[j + 1] = students[j];
            }
            students[j + 1] = k;
        }
    }

    //方式2：传入比较器Comparator,就可以进行比较
    public static void insertSort(Student[] students, Comparator<Student> cmp) {
        for (int i = 1; i < students.length; i++) {
            Student k = students[i];
            int j = i - 1;
            for (; j >= 0 && cmp.compare(students[j], k) > 0; j--) {
                students[j + 1] = students[j];
            }
            students[j + 1] = k;
        }
    }

    public static class Cmp implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Student[] students = { new Student(), new Student(), new Student()};
        //insertSort(students);
        //Arrays.sort(students);
        //insertSort(students, new Cmp());
        Arrays.sort(students, new Cmp());
    }
}
