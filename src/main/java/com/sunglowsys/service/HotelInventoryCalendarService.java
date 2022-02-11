package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;

import java.util.List;

public interface HotelInventoryCalendarService {


    HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar);

    HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Long id);

    List<HotelInventoryCalendar> findAll();

    HotelInventoryCalendar findById(Long id);

    void delete(Long id);
}
