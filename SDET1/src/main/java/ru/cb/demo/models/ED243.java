package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name="ed243")
@Entity
public class ED243 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edno;

    @Column(name = "edDate")
    private int edDate;
    @Column(name = "edAuthor")
    private int edAuthor;
    @Column(name = "edReceiver")
    private int edReceiver;
    @Column(name = "requestCode")
    private int requestCode;

   @OneToOne(mappedBy = "ed244")
    private ED244 ed244;

    @OneToMany(targetEntity=ED201.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name="edReceiver")
    private List<ED201> ed201s;
}
