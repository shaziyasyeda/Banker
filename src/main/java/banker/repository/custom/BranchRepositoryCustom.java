package banker.repository.custom;

import banker.domain.Branch;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by shaziya on 26/3/18.
 */
@Repository
public interface BranchRepositoryCustom {

    public List<Branch> findByBankNameAndCity(String bankName, String city);
}
