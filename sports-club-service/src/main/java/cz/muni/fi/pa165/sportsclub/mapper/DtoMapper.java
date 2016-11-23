package cz.muni.fi.pa165.sportsclub.mapper;

import cz.muni.fi.pa165.sportsclub.dto.player.PlayerCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.player.PlayerDto;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamCreateDto;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;

/**
 * Created by norbert on 20.11.16.
 */
public interface DtoMapper {

    /**
     * Maps a team entity to a dto of given type.
     *
     * @param team Team entity
     * @param mapToClass Dto type
     * @param <T> Implementation of TeamCreateDto
     * @return Mapped dto of the given type
     */
    <T extends TeamCreateDto> T teamToDto(Team team, Class<T> mapToClass);

    /**
     * Maps a teamDto to an entity.
     *
     * @param dto Dto to map
     * @return Mapped team entity
     */
    Team dtoToTeam(TeamCreateDto dto);
    
    /**
     * Maps a player entity to a PlayerDto.
     *
     * @param <T> implementation of PlayerCreateDto
     * @param player Player entity
     * @param maptoClass Dto type
     * @return Mapped Dto of the given type
     */
    <T extends PlayerCreateDto> T playerToDto(Player player, Class<T> maptoClass);

    /**
     * Maps a playerDto to an entity.
     *
     * @param dto Dto to map
     * @return Mapped player entity
     */
    Player dtoToPlayer(PlayerDto dto);
}
