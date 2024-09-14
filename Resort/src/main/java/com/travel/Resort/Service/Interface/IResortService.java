package com.travel.Resort.Service.Interface;

import com.travel.Resort.DTO.ResortDTO;
import com.travel.Resort.Model.Resort;

import java.util.List;

public interface IResortService {

    List<Resort> getAllResorts();
    ResortDTO getResortById(String id);
    Resort createResort(Resort resort);
    Resort updateResort(String id, Resort resort);
    void deleteResort(String id);

}
