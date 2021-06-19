import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Lesson6.IntegerArray;

public class ArrayAfterFourTest {

    private IntegerArray integerArray;

    @BeforeEach
    public void init() {
        integerArray = new IntegerArray();
    }

    @Test
    @DisplayName("Тест 1")
    public void test1() {
        Assertions.assertArrayEquals(new int[] {5,6,7}, integerArray.arrayAfterFour(new int[] {1,2,3,4,5,6,7}));
    }

    @Test
    @DisplayName("Тест 2")
    public void test2() {
        Assertions.assertArrayEquals(new int[] {5,6}, integerArray.arrayAfterFour(new int[] {1,4,2,4,3,4,5,6}));
    }

    @Test
    @DisplayName("Тест 3")
    public void test3() {
        Assertions.assertArrayEquals(new int[] {}, integerArray.arrayAfterFour(new int[] {1,2,3,4}));
    }

    @Test
    @DisplayName("Тест4")
    public void test4() {
        Assertions.assertThrows(RuntimeException.class, () -> integerArray.arrayAfterFour(new int[] {1,2,3}));
    }
}
