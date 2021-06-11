package Lesson6;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен
 * вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
 * Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор
 * тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * 3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод
 * вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */

public class IntegerArray {

    public int[] arrayAfterFour(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }

        if(!list.contains(4)) throw new RuntimeException();

        int index = list.lastIndexOf(4);
        int[] newArray = new int[array.length - index - 1];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i + index + 1];
            if(i == newArray.length - 1) break;
        }
        return newArray;
    }

    public boolean contains1And4(int[] array) {
        boolean b1 = false;
        boolean b4 = false;
        boolean b = false;

        for (int element : array) {
            if (element == 1) b1 = true;
            else if (element == 4) b4 = true;
            else b = true;
        }
        return b1 && b4 && !b;
    }

}
