package cz.muni.fi.pa165.sportsclub.facade;

import cz.muni.fi.pa165.sportsclub.EntityFactoryService;
import cz.muni.fi.pa165.sportsclub.dto.teamManager.TeamManagerDto;
import cz.muni.fi.pa165.sportsclub.entity.TeamManager;
import cz.muni.fi.pa165.sportsclub.mapper.DtoMapper;
import cz.muni.fi.pa165.sportsclub.service.TeamManagerService;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marian Sulgan
 */
public class TeamManagerFacadeTest {
    
    @Mock
    private TeamManagerService tmService;
    
    @Mock
    private DtoMapper dtoMapper;
    
    private EntityFactoryService entityFactoryService = new EntityFactoryService();
    
    @InjectMocks
    private TeamManagerFacade tmFacade = new TeamManagerFacadeImpl();
    
    @BeforeClass
    public void setupClass() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void setUpMethod() {
        Mockito.when(dtoMapper.dtoToTeamManager(Mockito.any()))
                .thenReturn(entityFactoryService.createTeamManager());
    }
    
    @Test
    public void createTeamManagerTest() {
        tmFacade.createTeamManager(entityFactoryService.createTeamManagerDto());
        Mockito.verify(tmService, Mockito.times(1)).createTeamManager(Mockito.any());
    }
    
    @Test
    public void deleteTeamManagerTest() {
        Mockito.when(tmService.findById(Mockito.anyLong())).thenReturn(entityFactoryService.createTeamManager());
        tmFacade.deleteTeamManager(1L);
        Mockito.verify(tmService, Mockito.times(1)).removeTeamManager(Mockito.anyLong());
    }
    
    @Test
    public void updateTeamManagerTest() {
        tmFacade.updateTeamManager(entityFactoryService.createTeamManagerDto());
        Mockito.verify(tmService, Mockito.times(1)).updateTeamManager(Mockito.any());
    }
    
    @Test
    public void getTeamManagerTest() {
        Mockito.when(dtoMapper.teamManagerToDto(Mockito.any()))
                .thenReturn(entityFactoryService.createTeamManagerDto());
        Mockito.when(tmService.findById(Mockito.anyLong()))
                .thenReturn(entityFactoryService.createTeamManager());

        TeamManagerDto test = tmFacade.getTeamManager(1L);

        Assert.assertNotNull(test);
    }
    
    @Test
    public void getAllTeamManagersTest() {
        List<TeamManager> tms = new ArrayList<>();
        tms.add(entityFactoryService.createTeamManager());
        tms.add(entityFactoryService.createTeamManager());
        tms.add(entityFactoryService.createTeamManager());
        
        Mockito.when(tmService.getAll()).thenReturn(tms);
        
        tmFacade.getAllTeamManagers();
        
        Mockito.verify(tmService, Mockito.times(1)).getAll();
    }
    
}
