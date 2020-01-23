import java.util.Comparator;

class PersonNameComparator implements Comparator<Person>{//实现了一个比较器

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}

class PersonHeightComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return (int) ((o1.height-o2.height)*100);
    }
}
class ComplexComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.height < o2.height) {
            return -1;
        } else if (o1.height > o2.height) {
            return 1;
        }
        if (o1.weight < o2.weight) {
            return -1;
        } else if (o1.weight > o2.weight){
            return 1;
        }
        int r = o1.name.compareTo(o2.name);
        if (r != 0) {
            return r;
        }
        return o1.age - o2.age;
    }
}

public class Person implements Comparable<Person>{//该类可以和另一个Person类进行比较
    public String name;
    public int age;
    public double height;
    public int weight;
    public int level;
    public int gender;

    @Override
    public int compareTo(Person o) {
        return age-o.age;
        /*
        if(age<o.age){
            return -1;
        }else if(age==o.age){
            return 0;
        }else {
            return 1;
        }
        */
    }

    public static void main(String[] args) {
        Person p=new Person();
        p.name="James";
        p.age=18;
        p.height=1.85;
        Person q=new Person();
        q.name="Tom";
        q.age=20;
        q.height=1.70;
        /*
        int r=p.compareTo(q);
        if(r<0){
            System.out.println("p小于q");
        }else if(r==0){
            System.out.println("p等于q");
        }else {
            System.out.println("p大于q");
        }

        //构造一个比较器
        Comparator<Person> comparator=new PersonNameComparator();
        System.out.println("按照姓名比较");
        int s=comparator.compare(p,q);
        if(s<0){
            System.out.println("p小于q");
        }else if(s==0){
            System.out.println("p等于q");
        }else {
            System.out.println("p大于q");
        }
        */

        Comparator<Person> comparator=new PersonHeightComparator();
        System.out.println("按照身高的比较");
        int r=comparator.compare(p,q);
        if(r<0){
            System.out.println("p小于q");
        }else if(r==0){
            System.out.println("p等于q");
        }else {
            System.out.println("p大于q");
        }
    }
}
