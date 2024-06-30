/* Author @ Nishant Suresh Sonar 
created on 26/06/24 
inside the package - com.Msinterface.demo.Repository */
package com.Msinterface.demo.Repository;

import com.Msinterface.demo.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
