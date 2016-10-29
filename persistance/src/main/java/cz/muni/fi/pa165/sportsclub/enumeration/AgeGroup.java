package cz.muni.fi.pa165.sportsclub.enumeration;

import cz.muni.fi.pa165.sportsclub.entity.Player;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by norbert on 24.10.16.
 */
public enum AgeGroup {
    A (new GregorianCalendar(1990, 0, 0).getTime(), new GregorianCalendar(1991, 11, 30).getTime()),
    B (new GregorianCalendar(1992, 0, 0).getTime(), new GregorianCalendar(1993, 11, 30).getTime());

    private final Date from;
    private final Date to;

    AgeGroup(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return new Date(from.getTime());
    }

    public Date getTo() {
        return new Date(to.getTime());
    }

    /**
     * Returns an AgeGroup according to the players birthday.
     * If no group exists for the specified player's birthday, null is returned.
     *
     * @param player Player to whom return the AgeGroup.
     * @return AgeGroup for the players birthday or null if no group exists for the player's birthday.
     */
    public AgeGroup getAgeGroup(Player player) {
        for(AgeGroup group : AgeGroup.values()) {
            if(player.getDateOfBirth().after(from) && player.getDateOfBirth().before(to))
                return group;
        }
        return null;
    }
}
