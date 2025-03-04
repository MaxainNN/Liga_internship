package browser;

/**
 * Класс Config содержит переменные , необходимые для конфигурации браузера (тип)
 * **/
public class Config {
    /**
     * BROWSER_TYPE переменная отвечающая за открытие необходимого браузера, Может принимать значения chrome и firefox
     * Может быть заменена на конструкцию типа Properties , в которой значение типа браузера
     * будет получено из .properties файла. Это необходимо при запуске тестов с разными параметрами.
     */
    public static final String BROWSER_TYPE = "chrome";

    /**
     * Переменная , отвечающая за неявное ожидание
     * **/
    public static final int WAIT = 1;
    /**
     * Переменная , отвечающая за явное ожидание
     * **/
    public static final int EXPLICIT_WAIT = 30;
}
