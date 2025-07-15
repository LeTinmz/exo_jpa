package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="observation")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String observerName;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;
    @Column(nullable = false)
    private LocalDate observationDate;
    @Column
    private String comment;
    @ManyToOne
    @JoinColumn(name = "specie_id")
    private Specie specie;
    @OneToOne
    @JoinColumn(name = "travel_log_id")
    private TravelLog travelLog;
    @ManyToOne
    @JoinColumn(name="region_id")
    private Region region;
}