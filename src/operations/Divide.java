package operations;

// Все операции наследуются от общего родителя и имеют его методы. Обязательно имплементируют абстрактный метод действия.
public class Divide extends Operation {
    @Override
    public double calculate(double x, double y) {
        if (y == 0) {
            // Кидаем исключение при делении на 0.
            throw new ArithmeticException("Divide by 0 is impossible");
        }
        return x / y;
    }
}
