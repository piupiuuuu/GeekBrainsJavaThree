package Lesson1;

public class Apple extends Fruit {

    private static final float weight = 1.0f;

    public Apple() {
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public Apple getFruit() {
        return this;
    }

}
