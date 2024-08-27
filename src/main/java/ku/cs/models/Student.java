package ku.cs.models;

public class Student {
    private String id;
    private String name;
    private double score;
    private String password;

    public Student(String id, String name) {
        this(id, name, 0, "");
    }

    public Student(String id, String name, double score, String password) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.password = password;
    }

    public void changeName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void addScore(double score) {
        if (score > 0) {
            this.score += score;
        }
    }

    public String grade() {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";
        return "F";
    }

    public boolean isId(String id) {
        return this.id.equals(id);
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

    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword) && !newPassword.trim().isEmpty()) {
            this.password = newPassword.trim();
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", score: " + score +
                '}';
    }
}
