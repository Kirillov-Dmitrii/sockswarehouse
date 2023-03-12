package com.skypro.sockswarehouse.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Socks {
    @Id
    @GeneratedValue
    int id;
    String color;
    int cottonPart;
    int quantity;
}
