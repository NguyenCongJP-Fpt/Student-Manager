package com.studentmanager.studentmanager.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "Name con not null or empty!.")
//    @Size(min = 7, max = 7, message = "Student ID length must be 7 characters!.")
    private int id;
    private String name;
//    @Email(message = "Invalid email.")
//    @NotNull(message = "Email can not be null or empty!.")
    private String email;
//    @Column(columnDefinition = "TEXT")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "universeId")
    private Clazz clazzes;

    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Clazz getClazzes() {
        return clazzes;
    }

    public void setClazzes(Clazz clazzes) {
        this.clazzes = clazzes;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
