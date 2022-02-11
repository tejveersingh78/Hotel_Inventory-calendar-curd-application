package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.repository.HotelInventoryCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelInventoryCalendarServiceImpl implements HotelInventoryCalendarService{

    @Autowired
    private HotelInventoryCalendarRepository hotelInventoryCalendarRepository;


    @Override
    public HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar) {
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Long id) {

        HotelInventoryCalendar hotelInventoryCalendar1 = findById(id);
        if(hotelInventoryCalendar.getAvailable() != null){
            hotelInventoryCalendar1.setAvailable(hotelInventoryCalendar.getAvailable());
        }
        if(hotelInventoryCalendar.getSold() != null){
            hotelInventoryCalendar1.setSold(hotelInventoryCalendar.getSold());
        }
        if(hotelInventoryCalendar.getBlock() !=null){
            hotelInventoryCalendar1.setBlock(hotelInventoryCalendar.getBlock());
        }
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar1);
    }

    @Override
    public List<HotelInventoryCalendar> findAll() {

        return hotelInventoryCalendarRepository.findAll();
    }

    @Override
    public HotelInventoryCalendar findById(Long id) {
        Optional<HotelInventoryCalendar> optional = hotelInventoryCalendarRepository.findById(id);
        HotelInventoryCalendar hotelInventoryCalendar = null;
        if(optional.isPresent()){
            hotelInventoryCalendar = optional.get();
        }
        else{
            throw new RuntimeException("HotelInventoryCalendar not found for ID : " + id);
        }
        return hotelInventoryCalendar;
    }

    @Override
    public void delete(Long id) {
        hotelInventoryCalendarRepository.deleteById(id);

    }
}
