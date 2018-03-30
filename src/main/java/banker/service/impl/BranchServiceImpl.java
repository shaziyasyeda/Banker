package banker.service.impl;

import banker.domain.Branch;
import banker.entity.BranchEntity;
import banker.repository.BranchRepository;
import banker.repository.custom.BranchRepositoryCustom;
import banker.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by shaziya on 25/3/18.
 */
@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchRepositoryCustom branchRepositoryCustom;

    public BranchEntity getBranchByIfsc(String ifsc) throws Exception{
        try {
            BranchEntity branchEntity = null;
            Branch branch = branchRepository.findByIfsc(ifsc);

            if(branch != null) {
                branchEntity = new BranchEntity();
                branchEntity.name = branch.getBranchName();
                branchEntity.city = branch.getCity();
                branchEntity.state = branch.getState();
                branchEntity.ifsc = branch.getIfsc();
                branchEntity.bank = branch.getBank();
                branchEntity.address = branch.getAddress();
            }

            return branchEntity;

        } catch (Exception e) {
            //Log here if you would like to have logs at service layer
            System.out.println(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<BranchEntity> getBranches(String bankName, String city) throws Exception{
        try {
            if(bankName == null || city == null) {
                throw new IllegalArgumentException("Missing required parameters");
            }

            ArrayList<BranchEntity> branchEntities =  new ArrayList<BranchEntity>();;
            List<Branch> branches = branchRepositoryCustom.findByBankNameAndCity(bankName, city);

            if(branches == null) {
               return branchEntities;
            }

            for (Branch branch: branches) {
                BranchEntity branchEntity = new BranchEntity();
                branchEntity.name = branch.getBranchName();
                branchEntity.city = branch.getCity();
                branchEntity.state = branch.getState();
                branchEntity.ifsc = branch.getIfsc();
                branchEntity.bank = branch.getBank();
                branchEntity.address = branch.getAddress();
                branchEntities.add(branchEntity);
            }

            return branchEntities;
        } catch (Exception e) {
            //Log here if you would like to have logs at service layer
            System.out.println(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<BranchEntity> getBranchesByCity(String city) throws Exception{
        try {
            if(city == null) {
                throw new IllegalArgumentException("Missing required parameters");
            }

            ArrayList<BranchEntity> branchEntities =  new ArrayList<BranchEntity>();;
            List<Branch> branches = branchRepository.findByCity(city.toUpperCase());

            if(branches == null) {
                return branchEntities;
            }

            for (Branch branch: branches) {
                BranchEntity branchEntity = new BranchEntity();
                branchEntity.name = branch.getBranchName();
                branchEntity.city = branch.getCity();
                branchEntity.state = branch.getState();
                branchEntity.ifsc = branch.getIfsc();
                branchEntity.bank = branch.getBank();
                branchEntity.address = branch.getAddress();
                branchEntities.add(branchEntity);
            }

            return branchEntities;
        } catch (Exception e) {
            //Log here if you would like to have logs at service layer
            System.out.println(e.getLocalizedMessage());
            throw e;
        }
    }
}
