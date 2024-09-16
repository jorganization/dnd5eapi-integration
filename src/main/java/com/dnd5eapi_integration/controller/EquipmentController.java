package com.dnd5eapi_integration.controller;

import com.dnd5eapi_integration.model.equipment.EquipmentDetail;
import com.dnd5eapi_integration.service.EquipmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("equipment")
@AllArgsConstructor
public class EquipmentController {

    EquipmentService equipmentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<EquipmentDetail> getEquipment() {
        List<EquipmentDetail> equipmentDetails = new ArrayList<>();
        equipmentDetails = equipmentService.getEquipmentDetails();
        return equipmentDetails;
    }

    @RequestMapping(params = "index", method = RequestMethod.GET)
    public EquipmentDetail getEquipmentDetailByIndex(@RequestParam("index") String equipmentIndex) {
        log.info("index: {}",equipmentIndex);
        EquipmentDetail equipmentDetail = new EquipmentDetail();
        equipmentDetail = equipmentService.getEquipmentDetailsByEquipmentIndex(equipmentIndex);
        return equipmentDetail;
    }

}
