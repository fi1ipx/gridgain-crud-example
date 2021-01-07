package com.gridgain.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = ObjectController.MAX_AGE)
@RequestMapping("/v1/api/object")
public class ObjectController {

    public static final int MAX_AGE = 3600;

    private ObjectService objectService;

    @GetMapping(value = {"/", ""})
    public List<Object> findAll() {
        return null;
    }

    @DeleteMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Object> delete(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(objectService.deleteObject(id), HttpStatus.OK);
    }

    @PatchMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Object> patch(@PathVariable("id") final Long id,
                                        @RequestBody final Object object) {
        return new ResponseEntity<>(objectService.modifyObject(id, object), HttpStatus.OK);
    }

    @GetMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Object> get(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(objectService.getObject(id), HttpStatus.OK);
    }

    @GetMapping({"/exit/", "/exit"})
    public void getExit() {
        System.exit(1);
    }

    @PutMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Object> put(@PathVariable("id") final Long id,
                                        @RequestBody final Object object) {
        return new ResponseEntity<>(objectService.modifyObject(id, object), HttpStatus.OK);
    }

    @Autowired
    public void setObjectService(ObjectService objectService) {
        this.objectService = objectService;
    }
}
