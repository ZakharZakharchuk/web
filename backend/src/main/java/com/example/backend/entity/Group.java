package com.example.backend.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "name")
    private String name;
    @Column(name = "course")
    private Integer course;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;
}
