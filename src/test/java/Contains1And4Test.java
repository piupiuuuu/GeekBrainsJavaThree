import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Lesson6.IntegerArray;

public class Contains1And4Test {
    private IntegerArray integerArray;

    @BeforeEach
    public void init() {
        integerArray = new IntegerArray();
    }

    @Test
    @DisplayName("Тест 1")
    public void test1() {
        Assertions.assertFalse(integerArray.contains1And4(new int[] {1, 4, 3}));
    }

    @Test
    @DisplayName("Тест 2")
    public void test2() {
        Assertions.assertFalse(integerArray.contains1And4(new int[] {1, 1, 1}));
    }

    @Test
    @DisplayName("Тест 3")
    public void test3() {
        Assertions.assertFalse(integerArray.contains1And4(new int[] {4, 4, 4}));
    }


    @Test
    @DisplayName("Тест 4")
    public void test4() {
        Assertions.assertTrue(integerArray.contains1And4(new int[] {1, 4, 1, 4}));
    }
}
