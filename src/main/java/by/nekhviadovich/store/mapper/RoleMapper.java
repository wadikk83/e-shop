package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.RoleDTO;
import by.nekhviadovich.store.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDTO dto);

    RoleDTO toDto(Role entity);
}
