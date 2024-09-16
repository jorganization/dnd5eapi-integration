package com.dnd5eapi_integration.cleint;

import com.dnd5eapi_integration.model.equipment.EquipmentDetail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class EquipmentClient {

    public List<EquipmentDetail> getEquipmentDetails() {
        List<EquipmentDetail> equipmentDetails = new ArrayList<>();
        log.info("Client");

        return equipmentDetails;
    }
    public EquipmentDetail getEquipmentDetailsByEquipmentIndex(String index) {
        EquipmentDetail equipmentDetails = new EquipmentDetail();
        log.info("Client");
        log.info(index);

        return equipmentDetails;
    }

}
