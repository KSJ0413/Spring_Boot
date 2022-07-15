package com.rentcar.carinfo.service;


import com.rentcar.carinfo.mapper.CarinfoMapper;
import com.rentcar.carinfo.model.CarinfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("com.rentcar.carinfo.service.CarinfoServiceImpl")
public class CarinfoServiceImpl implements CarinfoService {

    @Autowired
    private CarinfoMapper mapper;


    @Override
    public int create(CarinfoDTO dto) {
        return mapper.create(dto);
    }

    @Override
    public int total(Map map) {
        return mapper.total(map);
    }

    @Override
    public List<CarinfoDTO> list(Map map) {
        return mapper.list(map);
    }

    @Override
    public CarinfoDTO read(int carnumber) {
        return mapper.read(carnumber);
    }

    @Override
    public int update(CarinfoDTO dto) {
        return mapper.update(dto);
    }
}

