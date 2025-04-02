package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Класс для генерации (создания) данных
 */
public class DataGenerator {

    /**
     * Получить текущую дату
     * @return дату
     */
    public static String currentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateFormat = LocalDateTime.now().format(formatter);
        return dateFormat;
    }

    /**
     * Получить дату плюс "N" дней
     * @param day количество дней , которое надо добавить
     * @return дату
     */
    public static String currentPlusDate(int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateFormat = LocalDateTime.now().plusDays(day).format(formatter);
        return dateFormat;
    }

    /**
     * Получить дату минус "N" дней
     * @param day количество дней , которое надо вычесть
     * @return дату
     */
    public static String currentMinusDate(int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateFormat = LocalDateTime.now().minusDays(day).format(formatter);
        return dateFormat;
    }

    /**
     * Рандомный текст с латиницей
     * @param characters символы
     * @param length длина текста
     * @return текст
     */
    public static String randomString(String characters, int length) {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
            text[i] = characters.charAt(random.nextInt(characters.length()));
        return new String(text);
    }


    /**
     * Рандомный текст с кириллицей
     * @param length длина текста
     * @return текст
     */
    public static String randomRusString(int length) {
        String characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        return randomString(characters, length);
    }
}
