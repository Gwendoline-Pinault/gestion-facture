public class Prestation {
    private int id;
    private String date;
    private String client;
    private String type;
    private int userId;

    public Prestation() {}

    public Prestation(int id, String date, String client, String type, int userId) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.type = type;
        this.userId = userId;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getClient() {
        return client;
    }

    public String getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
