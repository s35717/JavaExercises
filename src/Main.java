public class Main {
    public static void main(String[] args) {

        // ── Exercise 1: User Validation ───────────────────────────────────────
        System.out.println("=== Exercise 1: User Validation ===");

        UserValidator validator = new UserValidator();
        validator.addRule(form -> form.email().contains("@"));
        validator.addRule(form -> form.password().length() >= 8);
        validator.addRule(form -> form.age() >= 18);

        UserForm validForm   = new UserForm("anna@example.com", "secure123", 20);
        UserForm invalidForm = new UserForm("no-at-sign.com",   "short",     15);

        System.out.println("Valid form:   " + validator.isValid(validForm));   // true
        System.out.println("Invalid form: " + validator.isValid(invalidForm)); // false
        System.out.println();

        // ── Exercise 2: Service Price Calculator ──────────────────────────────
        System.out.println("=== Exercise 2: Service Price Calculator ===");

        ServiceOrder order      = new ServiceOrder("Alpha Company", 10, 120.0);
        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard = o -> o.hours() * o.hourRate();
        PriceStrategy discount = o -> o.hours() * o.hourRate() * 0.90;
        PriceStrategy weekend  = o -> o.hours() * o.hourRate() * 1.25;

        System.out.println("Standard: " + calculator.calculate(order, standard)); // 1200.0
        System.out.println("Discount: " + calculator.calculate(order, discount)); // 1080.0
        System.out.println("Weekend:  " + calculator.calculate(order, weekend));  // 1500.0
        System.out.println();

        // ── Exercise 3: Store Order ───────────────────────────────────────────
        System.out.println("=== Exercise 3: Store Order ===");

        Order storeOrder = new Order("ORD-100", "Anna Kowalska");
        storeOrder.addItem(new Order.OrderItem("Keyboard", 249.99, 1));
        storeOrder.addItem(new Order.OrderItem("Mouse",     99.99, 2));

        OrderSummary summary = new OrderSummary(
                storeOrder.getOrderNumber(),
                storeOrder.getCustomerName(),
                storeOrder.total()
        );
        System.out.println(summary); // OrderSummary[orderNumber=ORD-100, ...]
        System.out.println();

        // ── Exercise 4: Library Account ───────────────────────────────────────
        System.out.println("=== Exercise 4: Library Account ===");

        LibraryAccount account = new LibraryAccount("John Smith", 3, 5);
        LibraryAccount.FineCalculator fineCalc = account.new FineCalculator();

        double fine = fineCalc.calculate();

        // Lambda implementation of MessagePrinter
        MessagePrinter printer = message -> System.out.println("[LIBRARY] " + message);
        printer.print("Reader: " + account.getReaderName() + ", fine: " + fine + " PLN");
    }
}
