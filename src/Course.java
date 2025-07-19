public class Course extends Prestation {
    private String startHour;
    private String endHour;
    private String module;
    private String classLevel;
    private int userId;

    public Course() {}

    /** Constructor pour la création en base */
    public Course(String date, String client, String type, String startHour, String endHour, String module, String classLevel, int userId) {
        super(date, client, type, userId);
        this.startHour = startHour;
        this.endHour = endHour;
        this.module = module;
        this.classLevel = classLevel;
    }

    /** Constructor pour la récupération de la base */
    public Course(int id, String date, String client, String type, String startHour, String endHour, String module, String classLevel, int userId) {
        super(id, date, client, type, userId);
        this.startHour = startHour;
        this.endHour = endHour;
        this.module = module;
        this.classLevel = classLevel;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
