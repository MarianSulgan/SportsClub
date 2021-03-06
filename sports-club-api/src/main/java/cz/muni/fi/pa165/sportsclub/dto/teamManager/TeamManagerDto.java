package cz.muni.fi.pa165.sportsclub.dto.teamManager;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cz.muni.fi.pa165.sportsclub.dto.team.TeamDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marian Sulgan
 */
public class TeamManagerDto {
    
    private long id;
    
    @NotNull
    @Size(min = 2, max = 80)
    private String name;

    @NotNull
    @Size(min = 2, max = 200)
    private String address;

    @NotNull
    @Size(min = 2, max = 60)
    private String contact;

    @JsonBackReference
    private List<TeamDto> teams;
    
    public TeamManagerDto() {

    }

    public TeamManagerDto(TeamManagerDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.contact = dto.getContact();
        this.teams = dto.getTeams();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if ((o == null) || !(o instanceof TeamManagerDto)) 
            return false;

        TeamManagerDto tmDto = (TeamManagerDto) o;

        return getTeams().equals(tmDto.getTeams());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.getName());
        hash = 47 * hash + Objects.hashCode(this.getContact());
        hash = 47 * hash + Objects.hashCode(this.getAddress());
        return hash;
    }

    @Override
    public String toString() {
        return "TeamManagerDto{" + 
                "id=" + id + 
                "name=" + getName() + 
                ", address=" + getAddress() + 
                ", contact=" + getContact() + 
                ", teamsCount=" + getTeams().size() + 
                '}';
    }
}
