package com.example.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIdentityInfo(

      generator = ObjectIdGenerators.PropertyGenerator.class,

      property = "studentId")

public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "StudentId")
  private long studentId;

  @Column(name = "studentName")
  private String studentName;

  @Column(name = "rollNumber", unique = true)
  private String rollNumber;

  @Column(name = "registerNumber", unique = true)
  private String registerNumber;

  @Column(name = "gender")
  private String gender;

  @Column(name = "dOB")
  private Date dOB;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "email")
  private String email;

  @Column(name = "aadharNumber", unique = true)
  private String aadharNumber;

  @Column(name = "medium")
  private String medium;

  @Column(name = "admittedYear")
  private String admittedYear;

  @Column(name = "dOJ")
  private Date dOj;

  @Column(name = "currentyear")
  private int currentyear;

  @Column(name = "photo")
  private String photo;

  @Column(name = "motherTongue")
  private String motherTongue;

  @Column(name = "nationality")
  private String nationality;

  @Column(name = "religion")
  private String religion;

  @Column(name = "caste")
  private String caste;

  @Column(name = "cummunitycategory")
  private String communityCategory;

  @Column(name = "dOL")
  private Date dOL;

  @Column(name = "comleted")
  private boolean completed;

  @Column(name = "leavingReason")
  private String leavingReason;

  private long recordId;

  @Column(name = "deleted")
  private boolean deleted;
  
  @JsonManagedReference
  @OneToMany(mappedBy = "student",cascade=CascadeType.ALL)
  public List<Parent> parent;
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="address")
  public Address address;
  
  
  @JsonManagedReference
  @OneToMany(mappedBy="student",cascade=CascadeType.ALL)
  public List<Course> course;
  
  @OneToMany(mappedBy ="student",cascade=CascadeType.ALL)
  public List<AcademicYear> academicyear;

}