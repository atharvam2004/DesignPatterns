package SOLID;
// A class should have only one reason to change, meaning it should only have one job or responsibility.
//Single Responsibility Principle

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Separate class for printing
class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice Amount: " + invoice.getAmount());
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(100);
        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(invoice);
    }
}
