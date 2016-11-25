package cz.muni.fi.pa165.sportsclub.facade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.MembershipService;

/**
 * Created by jsmolar on 11/23/16.
 */
public class MembershipFacadeImpl implements MembershipFacade {

    @Inject
    private DtoMapper dtoMapper;

    @Inject
    private MembershipService membershipService;

    @Override
    public void createMembership(MembershipCreateDto dto) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        membershipService.createMembership(membership);
    }

    @Override
    public void deleteMembership(MembershipDto dto) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        membershipService.removeMembership(membership);
    }

    @Override
    public void updateMembership(MembershipDto dto) {
        Membership membership =  dtoMapper.mapTo(dto, Membership.class);
        membershipService.updateMembership(membership);
    }

    @Override
    public List<MembershipDto> findAllMemberships() {
        List<MembershipDto> result = new ArrayList<>();
        for (Membership membership : membershipService.findAll()) {
            result.add(dtoMapper.mapTo(membership, MembershipDto.class));
        }

        return result;
    }

    @Override
    public MembershipDto findMembership(long id) {
        Membership membership = membershipService.findById(id);
        return dtoMapper.mapTo(membership, MembershipDto.class);
    }
}