package service;

import domain.Fee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.FeeRepository;
import service.DTOs.fee.request.FeeRequestDTO;
import service.exception.ConflictExistException;

@Service("FeeService")
public class FeeService {
    private FeeRepository repository;

    public FeeService(FeeRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity saveFee(FeeRequestDTO request) {
        if(!this.repository.existsById(request.getId())){
            Fee fee = new Fee(request);
            this.repository.save(fee);
            return new ResponseEntity(fee.getId(), HttpStatus.CREATED);
        }
        else {
            throw new ConflictExistException("Fee","id", request.getId());
        }
    }
}
