package com.digital.epharmacy.repository.Driver;
/*
 * Author: Chad Boswell
 * Date: 29/08/2020
 * Description: Driver Repository class extends the IRepository class
 *
 * Modified: 27 October 2020
 * Extends JPA Repository
 * Deprecated IRepository
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCarRepository extends JpaRepository<DriverCar, String> {

}

