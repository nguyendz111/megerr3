public class Student {
    private String id;
    private String name;
    private double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getGrade() {
        if (score >= 9.0) {
            return "Excellent";
        } else if (score >= 7.5) {
            return "Very Good";
        } else if (score >= 6.0) {
            return "Good";
        } else if (score >= 5.0) {
            return "Average";
        } else {
            return "Fail";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Score: " + score + ", Grade: " + getGrade();
    }
}
