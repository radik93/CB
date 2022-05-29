package ru.cb.demo.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="ed201")
@Entity
public class ED201 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long edno;

   @Column(name = "edDate")
   private int edDate;
 //   @Column(name = "edAuthor")
 //   private int edAuthor;
 //   @Column(name = "edReceiver")
 //   private int edReceiver;
    @Column(name = "ctrlCode")
    private int ctrlCode;

    @Column(name = "isRelevant")
    private int isRelevant;

    @ManyToOne(targetEntity=ED243.class)
    @JoinColumn(name="ed243_id")
    ED243 ed243;
}
