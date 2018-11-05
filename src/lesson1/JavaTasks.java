package lesson1;

import kotlin.NotImplementedError;

import java.io.*;
import java.util.*;

import static java.lang.Integer.min;

@SuppressWarnings("unused")
public class JavaTasks {
    /**
     * Сортировка времён
     *
     * Простая
     * (Модифицированная задача с сайта acmp.ru)
     *
     * Во входном файле с именем inputName содержатся моменты времени в формате ЧЧ:ММ:СС,
     * каждый на отдельной строке. Пример:
     *
     * 13:15:19
     * 07:26:57
     * 10:00:03
     * 19:56:14
     * 13:15:19
     * 00:40:31
     *
     * Отсортировать моменты времени по возрастанию и вывести их в выходной файл с именем outputName,
     * сохраняя формат ЧЧ:ММ:СС. Одинаковые моменты времени выводить друг за другом. Пример:
     *
     * 00:40:31
     * 07:26:57
     * 10:00:03
     * 13:15:19
     * 13:15:19
     * 19:56:14
     *
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortTimes(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка адресов
     *
     * Средняя
     *
     * Во входном файле с именем inputName содержатся фамилии и имена жителей города с указанием улицы и номера дома,
     * где они прописаны. Пример:
     *
     * Петров Иван - Железнодорожная 3
     * Сидоров Петр - Садовая 5
     * Иванов Алексей - Железнодорожная 7
     * Сидорова Мария - Садовая 5
     * Иванов Михаил - Железнодорожная 7
     *
     * Людей в городе может быть до миллиона.
     *
     * Вывести записи в выходной файл outputName,
     * упорядоченными по названию улицы (по алфавиту) и номеру дома (по возрастанию).
     * Людей, живущих в одном доме, выводить через запятую по алфавиту (вначале по фамилии, потом по имени). Пример:
     *
     * Железнодорожная 3 - Петров Иван
     * Железнодорожная 7 - Иванов Алексей, Иванов Михаил
     * Садовая 5 - Сидоров Петр, Сидорова Мария
     *
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortAddresses(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка температур
     *
     * Средняя
     * (Модифицированная задача с сайта acmp.ru)
     *
     * Во входном файле заданы температуры различных участков абстрактной планеты с точностью до десятых градуса.
     * Температуры могут изменяться в диапазоне от -273.0 до +500.0.
     * Например:
     *
     * 24.7
     * -12.6
     * 121.3
     * -98.4
     * 99.5
     * -12.6
     * 11.0
     *
     * Количество строк в файле может достигать ста миллионов.
     * Вывести строки в выходной файл, отсортировав их по возрастанию температуры.
     * Повторяющиеся строки сохранить. Например:
     *
     * -98.4
     * -12.6
     * -12.6
     * 11.0
     * 24.7
     * 99.5
     * 121.3
     */
    // Трудоёмкость - O(n)
    // Ресурсоёмкость - O(n)
    static public void sortTemperatures(String inputName, String outputName)
            throws IllegalArgumentException, IOException{
        LinkedList<Double> listOfTemperatures = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputName));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            double temperature = Double.parseDouble(currentLine);
            if ((temperature >= -237.0) || (temperature <= 500.0))
                listOfTemperatures.add(temperature);
            }
        Collections.sort(listOfTemperatures);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputName));
        for (double i: listOfTemperatures) {
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * Сортировка последовательности
     *
     * Средняя
     * (Задача взята с сайта acmp.ru)
     *
     * В файле задана последовательность из n целых положительных чисел, каждое в своей строке, например:
     *
     * 1
     * 2
     * 3
     * 2
     * 3
     * 1
     * 2
     *
     * Необходимо найти число, которое встречается в этой последовательности наибольшее количество раз,
     * а если таких чисел несколько, то найти минимальное из них,
     * и после этого переместить все такие числа в конец заданной последовательности.
     * Порядок расположения остальных чисел должен остаться без изменения.
     *
     * 1
     * 3
     * 3
     * 1
     * 2
     * 2
     * 2
     */
    // Трудоёмкость - O(n)
    // Ресурсоёмкость - O(n)
    static public void sortSequence(String inputName, String outputName)
            throws IOException, IllegalFormatException {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1, number, value, minOfNumbers = Integer.MAX_VALUE;
        String currentLine;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputName));
        while ((currentLine = bufferedReader.readLine()) != null) {
            number = Integer.parseInt(currentLine);
            listOfNumbers.add(number);
            if (map.containsKey(number)) {
                value = map.get(number);
                map.put(number, (value + 1));
                if ((value + 1) > count) {
                    count = value + 1;
                    minOfNumbers = number;
                }
                else if ((value + 1) == count) minOfNumbers = min(minOfNumbers, number);
            } else {
                map.put(number, 1);
                if (count == 1) minOfNumbers = min(minOfNumbers, number);
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputName));
        for (Integer i: listOfNumbers) {
            if (i != minOfNumbers) {
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
            }
        }
        for (int i = 0; i < count; i++) {
            bufferedWriter.write(String.valueOf(minOfNumbers));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * Соединить два отсортированных массива в один
     *
     * Простая
     *
     * Задан отсортированный массив first и второй массив second,
     * первые first.size ячеек которого содержат null, а остальные ячейки также отсортированы.
     * Соединить оба массива в массиве second так, чтобы он оказался отсортирован. Пример:
     *
     * first = [4 9 15 20 28]
     * second = [null null null null null 1 3 9 13 18 23]
     *
     * Результат: second = [1 3 4 9 9 13 15 20 23 28]
     */
    static <T extends Comparable<T>> void mergeArrays(T[] first, T[] second) {
        throw new NotImplementedError();
    }
}
