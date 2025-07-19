public class Course extends Prestation {
    private String startHour;
    private String endHour;
    private String module;
    private String classLevel;
    private int prestationId;
    private int userId;

    public Course() {}

    public Course(int id, String date, String client, String type, String startHour, String endHour, String module, String classLevel, int prestationId, int userId) {
        super(id, date, client, type, userId);
        this.startHour = startHour;
        this.endHour = endHour;
        this.module = module;
        this.classLevel = classLevel;
        this.prestationId = prestationId;
        this.userId = userId;
    }

    // getters
    public String getStartHour() {
        return startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getModule() {
        return module;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public int getPrestationId() {
        return prestationId;
    }

    public int getUserId() {
        return userId;
    }

    // setters
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public void setPrestationId(int prestationId) {
        this.prestationId = prestationId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
