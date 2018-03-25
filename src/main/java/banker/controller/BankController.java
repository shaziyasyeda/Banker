package banker.controller;

import banker.entity.BranchEntity;
import banker.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BranchService branchService;

    @RequestMapping("/test")
    public String test() {
        return "TEsting testing";
    }

    @RequestMapping(value= "/branch/{ifsc}", method = RequestMethod.GET)
    public ResponseEntity<BranchEntity> getBranch(@PathVariable("ifsc") String ifsc){
        BranchEntity branch = null;
        try {
            branch =  branchService.getBranchByIfsc(ifsc);
            return new ResponseEntity(branch, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(branch, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(branch, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value= "/branches", method = RequestMethod.GET)
    public ResponseEntity<List<BranchEntity>> getBranches(@RequestParam String bankName, @RequestParam String city) {
        List<BranchEntity> branches = null;
        try {
            branches = branchService.getBranches(bankName, city);
            return new ResponseEntity(branches, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(branches, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(branches, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}