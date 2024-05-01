package org.backendprojectsst.hotelmanagementsystem.repositories;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
