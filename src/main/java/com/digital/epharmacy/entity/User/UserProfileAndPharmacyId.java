package com.digital.epharmacy.entity.User;

import java.io.Serializable;
import java.util.Objects;

/**Author: Nicole Hawthorne
 *Desc: Class to add composite keys for userProfile primary key and for pharmacy primary key bridging
 * Date: 25/10/2020
 * */
public class UserProfileAndPharmacyId implements Serializable {
    private String userId, pharmacyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileAndPharmacyId that = (UserProfileAndPharmacyId) o;
        return userId.equals(that.userId) &&
                pharmacyId.equals(that.pharmacyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, pharmacyId);
    }
}
