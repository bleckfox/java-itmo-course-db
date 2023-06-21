package ru.itmo.course.courseWork4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Модель группы альпинистов
 */
@Getter
@Setter
@Entity
@Table(name = "climbing_groups")
public class ClimbingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "group_mountaineers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "mountaineer_id")
    )
    private List<Mountaineer> mountaineers;

    @ManyToOne
    @JoinColumn(name = "mountain_id")
    private Mountain mountain;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "recruiting")
    private boolean isRecruiting;

    public List<Mountaineer> getMountaineers() {
        return mountaineers;
    }

    public void setMountaineers(List<Mountaineer> mountaineers) {
        this.mountaineers = mountaineers;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isRecruiting() {
        return isRecruiting;
    }

    public void setRecruiting(boolean recruiting) {
        isRecruiting = recruiting;
    }
}
