package service;

import domain.Fee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.FeeRepository;
import service.DTOs.fee.request.FeeRequestDTO;
import service.DTOs.fee.response.FeeResponseDTO;
import service.exception.ConflictExistException;

import java.util.List;
import java.util.stream.Collectors;

@Service("FeeService")
public class FeeService {
    private FeeRepository repository;

    public FeeService(FeeRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity saveFee(FeeRequestDTO request) {
        if(!this.repository.existsById(request.getId())){
            Fee fee = new Fee(request);
            //if(playerService.existPlayer(request.getPlayerID())){
            //    this.repository.save(fee);
            //}
            //else{
            //     throw new NotFoundException("Player", "DNI", request.getPlayerID());
            //}
            return new ResponseEntity(fee.getId(), HttpStatus.CREATED);
        }
        else {
            throw new ConflictExistException("Fee","id", request.getId());
        }
    }

    public List<FeeResponseDTO> findAll() {
        List<Fee> fees = this.repository.findAll();
        return fees.stream().map(fee -> new FeeResponseDTO(fee)).collect(Collectors.toList());
    }

    public List<FeeResponseDTO> findByCategory(int category) {
       //List<players> players = this.playerService.getByCategory(category);
       //List<Fee> fees = new ArrayList<>();
       //foreach(Player p : players){
            //Fee fee = this.repository.findByPlayerID(p.getId());
            //fees.add(fee);
        // }
        //return fees.stream().map(fee -> new FeeResponseDTO(fee)).collect(Collectors.toList());
        return null;
    }

    public List<FeeResponseDTO> findByPlayerId(int id) {
        //Player player = this.playerService.getById(id);
        //List<Fee> fees = this.repository.getAllByPlayerID(id);
        //return fees.stream().map(fee -> new FeeResponseDTO(fee)).collect(Collectors.toList());
        return null;
    }
}
