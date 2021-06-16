package Lesson7;

public class SimpleClass {

    @BeforeSuite
    public void print1() {
        System.out.println("before suite");
    }

    @Test(priority = 2)
    public void print2() {
        System.out.println(2);
    }

    @Test(priority = 3)
    public void print3() {
        System.out.println(3);
    }

    @Test(priority = 4)
    public void print4() {
        System.out.println(4);
    }

    @AfterSuite
    public void print5() {
        System.out.println("after suite");
    }

}
