package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DTOs.fee.request.FeeRequestDTO;
import service.DTOs.fee.response.FeeResponseDTO;
import service.FeeService;

import java.util.List;

@RestController
@RequestMapping("/api/fee")
public class FeeController {
    private FeeService service;

    public FeeController(FeeService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity createFee(@RequestBody FeeRequestDTO request){
        return this.service.saveFee(request);
    }

    @GetMapping("/")
    public List<FeeResponseDTO> getAllFees(){
        return this.service.findAll();
    }

    @GetMapping("/{category}")
    public List<FeeResponseDTO>getFeesByFootballCategory(@PathVariable int category){
        return this.service.findByCategory(category);
    }
}
