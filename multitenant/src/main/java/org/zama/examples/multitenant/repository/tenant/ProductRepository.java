package org.zama.examples.multitenant.repository.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zama.examples.multitenant.model.tenant.Product;

import java.util.List;
import java.util.Optional;

/**
 * RoleRepository.
 * @author Zakir Magdum
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findOneByName(String name);

    @Query("FROM Product AS p WHERE p.company.companyKey = ?1")
    List<Product> findByCompanyKey(String companyName);
}