package service.entityService;

import converter.AllMapper;
import dao.AddressDao;
import dto.AddressDto;
import dto.AddressSaveRequestDto;
import entity.AddressEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final AddressDao addressDao;

    public AddressEntity createNewAddress(AddressEntity address){
        return addressDao.save(address);
    }

    public AddressDto saveAddressEntity(AddressSaveRequestDto addressSaveRequestDto){

        AddressEntity addressEntity = AllMapper.INSTANCE.convertToAddressEntity(addressSaveRequestDto);

        addressEntity = addressDao.save(addressEntity);

        AddressDto addressDto = AllMapper.INSTANCE.convertToAddressDto(addressEntity);

        return addressDto;
    }


    public void deleteAddress(long id){
        addressDao.deleteById(id);
    }


    public Optional<AddressEntity> findById(long id){

        return addressDao.findById(id);
    }

    public AddressEntity updateStreet(Long id,AddressEntity address){
        Optional<AddressEntity> optionalAddress = addressDao.findById(id);
        return addressDao.save(address);
    }

}
