package ru.itmo.course.courseWork4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Модель альпиниста
 */
@Getter
@Setter
@Entity
@Table(name = "mountaineers")
public class Mountaineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

