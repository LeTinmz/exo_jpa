package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.utils.CategoryEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "specie")
public class Specie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String commonName;
    @Column(nullable = false)
    private String scientificName;
    @Column(nullable = false)
    private CategoryEnum category;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "specie_region",
            joinColumns = @JoinColumn(name="specie_id"),
            inverseJoinColumns = @JoinColumn(name="region_id")
    )

    private List<Region> regions;
    @OneToMany(mappedBy = "specie")
    private List<Observation> observations;

}
