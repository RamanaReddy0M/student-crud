package in.one2n.ramana.entities;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;


@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Date dob;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

    private String emailId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    //constructors
    public Student() {
    }

    public Student(String name, Date dob, Gender gender, String emailId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.emailId = emailId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", emailId='" + emailId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
