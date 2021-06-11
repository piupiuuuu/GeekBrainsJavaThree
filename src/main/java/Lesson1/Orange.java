package Lesson1;

public class Orange extends Fruit {

    private static final float weight = 1.5f;

    public Orange() {
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public Orange getFruit() {
        return this;
    }

}
