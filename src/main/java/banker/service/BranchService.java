package banker.service;

import banker.entity.BranchEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shaziya on 25/3/18.
 */

@Service
public interface BranchService {
    public BranchEntity getBranchByIfsc(String ifsc) throws Exception;
    public List<BranchEntity> getBranches(String bankName, String city) throws Exception;
}
