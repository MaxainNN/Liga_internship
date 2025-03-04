package browser;

/**
 * Класс с путями до папок
 * **/
public class Path {
    /**
     * Текущая директория пользователя
     * **/
    public static final String USER_DIR = System.getProperty("user.dir");
    /**
     * Путь к "resources" (Драйверы)
     * **/
    public static final String DRIVERS_PATH = USER_DIR + "/src/main/resources/";
    /**
     * Путь к тестовым файлам (для загрузки)
     * **/
    public static final String TEST_FILES_PATH = USER_DIR + "/src/test/resources/testFiles/";
    /**
     * Путь к папке со скриншотами
     * **/
    public static final String SCREENSHOT_DIR = USER_DIR + "/target/screenshots/";
    /**
     * Путь к папке , в которую загружаются файлы
     * **/
    public static final String DOWNLOAD_DIR = USER_DIR + "\\src\\test\\resources\\downloadFiles\\";
}
