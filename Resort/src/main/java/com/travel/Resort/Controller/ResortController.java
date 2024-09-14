package com.travel.Resort.Controller;

import com.travel.Resort.DTO.ResortDTO;
import com.travel.Resort.Model.Resort;
import com.travel.Resort.Service.Interface.IResortService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resort")
public class ResortController {

    private final IResortService resortService;

    public ResortController(IResortService resortService) {
        this.resortService = resortService;
    }

    @GetMapping
    public List<Resort> getAll() {
        return resortService.getAllResorts();
    }

    @GetMapping("/{id}")
    public ResortDTO getById(@PathVariable String id) {
        return resortService.getResortById(id);
    }

    @PostMapping
    public Resort add(@RequestBody Resort resort) {
        return resortService.createResort(resort);
    }

    @PutMapping("/{id}")
    public Resort update(@PathVariable String id, @RequestBody Resort resort) {
        return resortService.updateResort(id, resort);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        resortService.deleteResort(id);
    }
}
