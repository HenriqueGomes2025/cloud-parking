package one.digialinnovation.parking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digialinnovation.parking.dto.ParkingCreateDTO;
import one.digialinnovation.parking.dto.ParkingDTO;
import one.digialinnovation.parking.mapper.ParkingMapper;
import one.digialinnovation.parking.model.Parking;
import one.digialinnovation.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking Controller")
public class ParkingController {
    
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }
    
    
    @GetMapping
    @Operation(summary = "Find all parking")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "FindById parking")
    
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping
    @Operation(summary = "Create parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
