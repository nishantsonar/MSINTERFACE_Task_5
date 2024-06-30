/* Author @ Nishant Suresh Sonar 
created on 26/06/24 
inside the package - com.Msinterface.demo.Entities */
package com.Msinterface.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_details")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String rating;
}
