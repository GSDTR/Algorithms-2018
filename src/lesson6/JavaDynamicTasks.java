package lesson6;

import kotlin.NotImplementedError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    //Трудоёмкость - O(m * n)
    //Ресурсоёмкость - O(m * n)
    public static String longestCommonSubSequence(String first, String second)
        throws NotImplementedError, IOException {
        first = first.replaceAll("\n", "");
        second = second.replaceAll("\n", "");
        int m = first.length();
        int n = second.length();
        int i, j;
        int[][] lcs = new int[m + 1][n + 1];
        for (i = 0; i < m + 1; i++) {
            lcs[i][0] = 0;
        }
        for (j = 0; j < n + 1; j++) {
            lcs[0][j] = 0;
        }
        for (i = 1; i < m + 1; i++) {
            for (j = 1; j < n + 1; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        StringBuffer str = new StringBuffer("");
        i = first.length();
        j = second.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i-1) == second.charAt(j-1)) {
                str.append(first.charAt(i-1));
                i = i - 1;
                j = j - 1;
            } else {
                if (lcs[i - 1][j] > lcs[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }
        str.reverse();
        return new String(str);
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Средняя
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        throw new NotImplementedError();
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Сложная
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    // Трудоёмкость - O(n * m)
    // Ресурсоёмкость - O(n * m)
    public static int shortestPathOnField(String inputName) throws IOException {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputName))) {
            for (String line; (line = bufferedReader.readLine()) != null;)
                numbers.add(line.replaceAll(" ", ""));
        }
        int height = numbers.size();
        int width = numbers.get(0).length();
        int[][] matrix = new int[height][width];
        matrix[0][0] = numbers.get(0).charAt(0) - 48;
        for (int i = 1; i < height; i++)
            matrix[i][0] = numbers.get(i).charAt(0) - 48 + matrix[i - 1][0];
        for (int i = 1; i < width; i++)
            matrix[0][i] = numbers.get(0).charAt(i) - 48 + matrix[0][i - 1];
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]))
                        + numbers.get(i).charAt(j) - 48;
            }
        }
        return matrix[height - 1][width - 1];
    }
    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
