package lh.pers.reflection;

public class People {

    private int age;
    public String name;
    public String sex;
    public String wife;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sing(){
        System.out.println("唱歌。。。");
    }

    private void dance(){
        System.out.println("跳舞。。。");
    }

    public boolean isBeautiful(String name){
        return true;
    }

    private String eat(String some){
        return "吃东西。。。";
    }

}
