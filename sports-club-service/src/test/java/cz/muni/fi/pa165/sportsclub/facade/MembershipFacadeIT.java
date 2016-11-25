package cz.muni.fi.pa165.sportsclub.facade;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import cz.muni.fi.pa165.sportsclub.dao.MembershipDao;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipCreateDto;
import cz.muni.fi.pa165.sportsclub.dto.membership.MembershipDto;
import cz.muni.fi.pa165.sportsclub.entity.Membership;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by jsmolar on 11/25/16.
 */
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class MembershipFacadeIT extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    private MembershipFacade membershipFacade;

    @Inject
    private MembershipDao membershipDao;

    @Inject
    private DtoMapper dtoMapper;

    private EntityFactoryService entityFactoryService = new EntityFactoryService();

    private Membership membership;

    private MembershipDto membershipDto;

    @BeforeMethod
    public void setUp(){
        membership = entityFactoryService.createPersistedMembership(membershipDao);
    }

    @Test
    public void createMembershipIT(){
        MembershipCreateDto membershipCreateDto = entityFactoryService.createMembershipCreateDto();
        membershipFacade.createMembership(membershipCreateDto);

        List<Membership> memberships = membershipDao.findAll();

        assertEquals(memberships.get(0), membership);
    }

    @Test
    public void update(){
//        Membership persistedMembership = entityFactoryService.createPersistedMembership(membershipDao);
        MembershipDto updatedMembershipDto = dtoMapper.membershipToDto(membership);
        updatedMembershipDto.setJerseyNumber(99);

        membershipFacade.updateMembership(updatedMembershipDto);

        Membership updateResult = membershipDao.findById(membership.getId());
        assertEquals(updateResult.getJerseyNumber(), 99);
    }

    @Test
    public void deleteMembershipIT() {
//        entityFactoryService.createPersistedMembership(membershipDao, 47L);
//
//        membershipFacade.deleteMembership(membershipFacade.findMembership(47L));
//
//        assertNull(membershipDao.findById(47L));
    }

}
