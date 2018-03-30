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

    private final String BRANCH_TABLE = "branches";
    private final String BANK_TABLE = "banks";

    public List<Branch> findByBankNameAndCity(String bankName, String city) {
        Query query = entityManager.createNativeQuery(
                "SELECT br.* FROM "+BRANCH_TABLE+" br " +
                        "WHERE upper(br.city) = ? AND " +
                        "br.bank_id IN " +
                        "(SELECT id FROM "+BANK_TABLE+" b WHERE upper(b.name) LIKE ?)"
                , Branch.class);

        bankName = bankName.toUpperCase().trim();
        city = city.toUpperCase().trim();
        query.setParameter(1, city);
        query.setParameter(2, "%"+bankName+"%");

        return query.getResultList();
    }
}
