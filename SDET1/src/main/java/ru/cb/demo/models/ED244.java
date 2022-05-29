package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="ed244")
@Entity
public class ED244 {

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
    @Column(name = "ackCode")
    private int ackCode;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "requestCode")
    private ED243 ed243;
}
