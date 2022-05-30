package ru.cb.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="ed208")
@Entity
public class ED208 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edno;

    @Column(name = "edDate")
    private int edDate;
    @Column(name = "edAuthor")
    private int edAuthor;
    @Column(name = "edReceiver")
    private int edReceiver;
    @Column(name = "resultCode")
    private int ctrlCode;

    public ED208(int edDate, int ctrlCode, ED243 ed243) {
        this.edDate = edDate;
        this.ctrlCode=ctrlCode;
        this.edAuthor=ed243.getEdAuthor();
        this.edReceiver=ed243.getEdReceiver();
    }
}
