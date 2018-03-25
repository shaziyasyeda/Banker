package banker.repository;

import banker.domain.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shaziya on 25/3/18.
 */
public interface BranchRepository extends CrudRepository<Branch, Long> {

    public Branch findByIfsc(String ifsc);

    public List<Branch> findByBankNameAndCity(String bankName, String city);
}