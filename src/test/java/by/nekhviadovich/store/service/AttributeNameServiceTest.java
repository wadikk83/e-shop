package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.AttributeName;
import by.nekhviadovich.store.repository.AttributeNameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
class AttributeNameServiceTest {

    @Autowired
    private AttributeNameRepository repository;

    @Autowired
    private AttributeNameService service;

    private AttributeName createTestEntity() {
        AttributeName testEntity = new AttributeName();
        testEntity.setName("test entity attribute name");
        return testEntity;
    }

    private AttributeNameDTO createTestEntityDTO() {
        AttributeNameDTO testEntityDto = new AttributeNameDTO();
        testEntityDto.setName("test entity attribute name");
        return testEntityDto;
    }


    @Test
    void save() {
        AttributeName genericEntity = repository
                .save(createTestEntity());
        AttributeName foundEntity = repository
                .getReferenceById(genericEntity.getId());

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getName(), foundEntity.getName());
    }

    @Test
    void findAll() {
        final AttributeNameDTO saveEntityDto = service.save(createTestEntityDTO());
        Pageable pageable = PageRequest.of(0, 10);
        final Page<AttributeNameDTO> result = service.findAll(pageable);
        assertEquals(result.getTotalElements(), 1L);
    }

    @Test
    void findById() {
        final AttributeNameDTO saveEntityDto = service.save(createTestEntityDTO());
        final AttributeName foundEntityDto = service.findById(saveEntityDto.getId());
        assertNotNull(foundEntityDto);
        assertEquals(foundEntityDto.getName(), saveEntityDto.getName());
    }
}