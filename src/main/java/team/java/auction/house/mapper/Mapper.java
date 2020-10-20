package team.java.auction.house.mapper;

public interface Mapper<DTO, ENTITY> {

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
