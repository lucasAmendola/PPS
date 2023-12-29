package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DTOs.fee.request.FeeRequestDTO;
import service.FeeService;

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
}
