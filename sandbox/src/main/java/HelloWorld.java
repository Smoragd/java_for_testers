import java.io.File;

public class HelloWorld {
    public static void main(String[] args) {
        //механизм перехвата исключений:
        try {
            int z = calculateZ();
            System.out.println(z);
            System.out.println("Hello, World!");
        } catch (ArithmeticException exception){
            //вывод лога выполнения
            exception.printStackTrace();
            //System.out.println(exception.getMessage()); --еще вариант вывода текста ошибки из лога
        }

//        --Выводит путь до файла, проверает, есть ли файл по этому пути
//        var configFile = new File("sandbox/build.gradle");
//        System.out.println(configFile.getAbsolutePath());
//        System.out.println(configFile.exists());
    }

    private static int calculateZ() {
        int x = 3;
        int y = 0;
        int z = devide(x, y);
        return z;
    }

    private static int devide(int x, int y) {
        int z = x / y;
        return z;
    }
}
