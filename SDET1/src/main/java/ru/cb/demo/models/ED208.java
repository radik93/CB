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
  //  @Column(name = "edAuthor")
  //  private int edAuthor;
  //  @Column(name = "edReceiver")
  //  private int edReceiver;
    @Column(name = "resultCode")
    private int ctrlCode;
}
