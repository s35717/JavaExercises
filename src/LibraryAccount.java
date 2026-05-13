// Exercise 4: Library Account

@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

public class LibraryAccount {

    private final String readerName;
    private final int    borrowedBooks;
    private final int    lateDays;

    public LibraryAccount(String readerName, int borrowedBooks, int lateDays) {
        this.readerName    = readerName;
        this.borrowedBooks = borrowedBooks;
        this.lateDays      = lateDays;
    }

    public String getReaderName()   { return readerName; }
    public int    getBorrowedBooks(){ return borrowedBooks; }
    public int    getLateDays()     { return lateDays; }

    // ── Non-static inner class — accesses outer instance fields ───────────────
    public class FineCalculator {

        public double calculate() {
            return borrowedBooks * lateDays * 1.50;
        }
    }
}
