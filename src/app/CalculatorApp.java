package app;

import operations.Operation;

public class CalculatorApp {
    public static void main(String[] args) {

        // Проверяем что аргументов передано в принципе нужное количество.
        if (args.length != 3) {
            System.out.println("Error! Invalid arguments! Expected: number X, number Y, operation!");
            return;
        }

        // Создаю переменные для хранения аргументов.
        double x;
        double y;

        try {
            // Достаю из строк аргументы.
            x = Double.parseDouble((args[0]));
            y = Double.parseDouble((args[1]));
        } catch (NumberFormatException error) {
            System.out.println("Error! Invalid number X or Y. Expected numeric value!");
            return;
        }

        // Создаю имя класса операции для рефлексии с большой буквы независимо от ввода.
        String operationClassName = args[2].substring(0, 1).toUpperCase() + args[2].substring(1);

        try {
            // Создаю экземпляр класса Class любого типа.
            // Используя метод forName() класса Class кладу этот объект метаданных о классе в переменную clazz.
            // Для метода forName() нужно имя класса с пакетом где он находится.
            Class<?> clazz = Class.forName("operations." + operationClassName);
            // Создаю объект абстрактного класса Operation.
            // Кладу туда объект созданный дефолтным конструктором, того объекта который лежит у меня в clazz.
            // Привожу ему тип к типу Operation. Использую Operation потому что все возможные действия это его наследники.
            Operation operation = (Operation) clazz.getDeclaredConstructor().newInstance();

            // Сохраняем результат в переменную для метода printResult().
            double result = operation.calculate(x, y);
            // Вызываем printResult().
            operation.printResult(x, y, result);

            // Ловим ошибки.
        } catch (ClassNotFoundException error) {
            System.out.println("Error! Can not found this operation: " + error.getMessage().substring(11));
        } catch (Exception error) {
            System.out.println("Error! " + error.getMessage());
        }
    }
}
