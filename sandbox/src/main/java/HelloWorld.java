public class HelloWorld {
    public static void main(String[] args) {
        //механизм ветвления if - else:
            int x = 3;
            int y = 0;
            if (y==0) {
                System.out.println("Division by zero is not allowed");
            } else {
                int z = devide(x, y);
                System.out.println(z); //можно убрать, тк это выводится в отладчике
                System.out.println("Hello, World!");
            }

/*        //механизм перехвата исключений try - catch:
        try {
            int x = 3;
            int y = 3;
            int z = devide(x, y);
            System.out.println(z); //можно убрать, тк это выводится в отладчике
            System.out.println("Hello, World!");
        } catch (ArithmeticException exception){
            System.out.println("Division by zero is not allowed");
            //2. exception.printStackTrace(); --вывод лога выполнения вызовов
            //1. System.out.println(exception.getMessage()); --вывод краткого текста ошибки из лога
        }
*/
/*
            //Выводит путь до файла, проверает, есть ли файл по этому пути
            var configFile = new File("sandbox/build.gradle");
            System.out.println(configFile.getAbsolutePath());
            System.out.println(configFile.exists());
 */
    }

    private static int devide(int x, int y) {
        int z = x / y;
        return z;
    }
}
