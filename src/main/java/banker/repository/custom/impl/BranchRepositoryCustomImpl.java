package banker.repository.custom.impl;

import banker.domain.Branch;
import banker.repository.custom.BranchRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

/**
 * Created by shaziya on 26/3/18.
 */
@Repository
public class BranchRepositoryCustomImpl implements BranchRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    private final String BRANCH_TABLE = "branch";

    public List<Branch> findByBankNameAndCity(String bankName, String city) {
        Query query = entityManager.createNativeQuery(
                "SELECT br.* FROM "+BRANCH_TABLE+" br " +
                        "WHERE br.city = ? AND " +
                        "br.bank_id IN " +
                        "(SELECT id FROM bank b WHERE b.name LIKE ?)"
                , Branch.class);

        query.setParameter(1, city);
        query.setParameter(2, "%"+bankName+"%");

        return query.getResultList();
    }
}
