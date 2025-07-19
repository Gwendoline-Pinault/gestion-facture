public class Invoice {
    private int id;
    private String date;
    private Prestation prestation;
    private double amount;

    public Invoice() {}

    public Invoice(int id, String date, Prestation prestation, double amount) {
        this.id = id;
        this.date = date;
        this.prestation = prestation;
        this.amount = amount;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public double getAmount() {
        return amount;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
