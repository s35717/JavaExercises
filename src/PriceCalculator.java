// Exercise 2: Service Price Calculator
public class PriceCalculator {

    public double calculate(ServiceOrder order, PriceStrategy strategy) {
        return strategy.calculate(order);
    }
}
