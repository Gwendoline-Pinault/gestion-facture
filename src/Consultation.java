public class Consultation extends Prestation {
    private String description;
    private int rate;
    private int userId;

    // default constructor
    public Consultation() {}

    // constructor
    public Consultation(String date, String client, String type, String description, int rate, int userId) {
        super(date, client, type, userId);
        this.description = description;
        this.rate = rate;
    }

    /** Constructor pour la récupération de la base */
    public Consultation(int id, String date, String client, String type, String description, int rate, int userId) {
        super(id, date, client, type, userId);
        this.description = description;
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public int getRate() {
        return rate;
    }

    public int getUserId() {
        return userId;
    }

    // setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
