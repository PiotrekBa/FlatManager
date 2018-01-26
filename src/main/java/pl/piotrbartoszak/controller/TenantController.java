package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piotrbartoszak.model.Room;
import pl.piotrbartoszak.model.Tenant;
import pl.piotrbartoszak.model.TenantToSave;
import pl.piotrbartoszak.repository.RoomRepository;
import pl.piotrbartoszak.repository.TenantRepository;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    TenantRepository tenantRepository;


    @PostMapping("")
    public void saveTenant(@RequestBody TenantToSave tenantToSave) {
        Tenant tenant = new Tenant();
        tenant.setFirstName(tenantToSave.getFirstName());
        tenant.setLastName(tenantToSave.getLastName());
        tenant.setEmail(tenantToSave.getEmail());
        tenant.setPhone(tenantToSave.getPhone());
        Room room = roomRepository.findOne(tenantToSave.getRoomId());
        tenant.setRoom(room);
        tenantRepository.save(tenant);
    }


}
