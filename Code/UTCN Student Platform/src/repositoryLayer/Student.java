package repositoryLayer;

public class Student extends User {
    private int id;
    private Long PNC;
    private String name;
    private String address;
    private String email;
    private int year;

    public Student(int id, String name, String address, String email, Long PNC, int year) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.PNC = PNC;
        this.year = year;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPNC() {
        return PNC;
    }

    public void setPNC(Long PNC) {
        this.PNC = PNC;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", PNC=" + PNC +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", year=" + year +
                '}';
    }
}
