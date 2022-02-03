package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Setter
@Getter
@NoArgsConstructor
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private Integer series;

    @OneToOne(mappedBy = "car")
    private User user;
    public Car(String model, Integer series){
        this.model=model;
        this.series=series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
