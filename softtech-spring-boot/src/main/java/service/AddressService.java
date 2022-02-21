package service;

import converter.AllMapper;
import dto.AddressDto;
import dto.CountryDto;
import dto.CountrySaveRequestDto;
import entity.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.entityService.AddressEntityService;
import service.entityService.CountryEntityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressEntityService addressEntityService;


}
