public class Consultation extends Prestation {
    private String description;
    private int rate;
    private int prestationId;
    private int userId;

    // default constructor
    public Consultation() {}

    // constructor
    public Consultation(int id, String date, String client, String type, String description, int rate, int prestationId, int userId) {
        super(id, date, client, type, userId);
        this.description = description;
        this.rate = rate;
        this.prestationId = prestationId;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public int getRate() {
        return rate;
    }

    public int getPrestationId() {
        return prestationId;
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

    public void setPrestationId(int prestationId) {
        this.prestationId = prestationId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
