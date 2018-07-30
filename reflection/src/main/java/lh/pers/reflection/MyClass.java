package lh.pers.reflection;

public class MyClass {

    public static void main(String[] args) {


    }

    private void getPeople() {
        //获取对象实例
        //1、
//        People p = new People();
//        Class cls = p.getClass();
        //2、
//        Class cls1 = People.class;
        //3、
        try {
            Class cls2 = Class.forName("lh.pers.reflection.People");
            System.out.println(cls2.getName());
            System.out.println(cls2.getCanonicalName());
            System.out.println(cls2.desiredAssertionStatus());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
