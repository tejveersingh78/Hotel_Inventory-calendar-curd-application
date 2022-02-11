package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.service.HotelInventoryCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelInventoryCalendarResource {

    @Autowired
    private HotelInventoryCalendarService hotelInventoryCalendarService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HotelInventoryCalendar hotelInventoryCalendar){
        HotelInventoryCalendar result = hotelInventoryCalendarService.create(hotelInventoryCalendar);
        return ResponseEntity.ok().body("HotelInventoryCalendar is created Successfully : " + result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HotelInventoryCalendar> update(@RequestBody HotelInventoryCalendar hotelInventoryCalendar,@PathVariable("id") Long id){
        HotelInventoryCalendar result = hotelInventoryCalendarService.update(hotelInventoryCalendar,id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<HotelInventoryCalendar> getAll(){
        List<HotelInventoryCalendar> result = hotelInventoryCalendarService.findAll();
        return result;
    }

    @GetMapping("/get/{id}")
    public HotelInventoryCalendar getById(@PathVariable("id") Long id){
        return hotelInventoryCalendarService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        hotelInventoryCalendarService.delete(id);
        return ResponseEntity.ok().body("HotelInventoryCalendar is deleted successfully on this Id : " + id);
    }


}
