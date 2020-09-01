<<<<<<< HEAD
<<<<<<< HEAD
package com.digital.epharmacy.repository.Order;
=======
package com.digital.epharmacy.repository.Order.OrderHistory;
>>>>>>> origin/groupCollaboration
=======
package com.digital.epharmacy.repository.Order;
>>>>>>> upstream/groupCollaboration

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 29/08/2020
 * Description: Interface for getting all orders from the database
 */

public interface OrderRepository extends Repository<Order, String> {
    Set<Order> getAll();
}
