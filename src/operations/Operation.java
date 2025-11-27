package operations;

public abstract class Operation {

    // Создаю абстрактный класс для всех операций. У него будет два метода.
    // Абстрактное действие и паблик метод для вывода результата.
    public abstract double calculate(double x, double y);

    public void printResult(double x, double y, double result) {
        System.out.println(
                String.format(
                        "Operation: %s: %.2f and %.2f -> Result: %.2f", this.getClass().getSimpleName(), x, y, result)
        );
    }
}
