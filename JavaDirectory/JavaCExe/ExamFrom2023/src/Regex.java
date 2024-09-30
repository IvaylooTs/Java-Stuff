public class Regex {
    private int id;
    private String pattern;
    private String description;
    private int rating;
    public static int nextId = 0;


    public Regex (String pattern, String description) {
        this.rating = 0;
        this.pattern = pattern;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setDescription(String s) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getPattern() {
        return pattern;
    }

    public int getId() {
        return id;
    }
}
