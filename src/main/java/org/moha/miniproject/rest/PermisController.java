package org.moha.miniproject.rest;

import org.moha.miniproject.enteties.Permis;
import org.moha.miniproject.services.permis.PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermisController {
    @Autowired
    private PermisService permisService;

    @PostMapping("/permis")
    public Permis createPermis(Permis permis){
        return permisService.savePermis(permis);
    }

    @PutMapping("/permis/{idPermis}")
    public Permis updatePermis(@PathVariable Long idPermis, @RequestBody Permis permis){
        permis.setIdPermis(idPermis);
        return permisService.savePermis(permis);
    }

    @DeleteMapping("/permis/{idPermis}")
    public void deletePermis(@PathVariable Long idPermis){
        permisService.removePermis(idPermis);
    }
}