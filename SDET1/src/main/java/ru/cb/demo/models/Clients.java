package ru.cb.demo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name="clients")
@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

      @Column(name = "name")
      private String name;
      @Column(name = "INN")
      private int INN;
      @Column(name = "PS")
      private int PS;
      @Column(name = "BIK")
      private int BIK;
}
