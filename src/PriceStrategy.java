// Exercise 2: Service Price Calculator
@FunctionalInterface
public interface PriceStrategy {
    double calculate(ServiceOrder order);
}
