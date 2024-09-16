package com.dnd5eapi_integration.service;

import com.dnd5eapi_integration.cleint.EquipmentClient;
import com.dnd5eapi_integration.model.equipment.EquipmentDetail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class EquipmentService {

    EquipmentClient equipmentClient;

    public List<EquipmentDetail> getEquipmentDetails() {
        List<EquipmentDetail> equipmentDetails = new ArrayList<>();
        equipmentClient.getEquipmentDetails();
        return equipmentDetails;
    }

    public EquipmentDetail getEquipmentDetailsByEquipmentIndex(String equipmentIndex) {
        EquipmentDetail equipmentDetail = new EquipmentDetail();
        equipmentDetail = equipmentClient.getEquipmentDetailsByEquipmentIndex(equipmentIndex);
        return equipmentDetail;
    }

}
