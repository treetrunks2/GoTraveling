package com.example.rentdotcom.ar;
/**
 * Created by sookmyung on 2017-10-10.
 */

import java.util.Date;

public final class KidEntry {
    private final String name;
    private final String parents;
    private final Date birthDate;
    private final int icon;

    public KidEntry(final String name, final String parents,
                    final Date birthDate, final int icon) {
        this.name = name;
        this.parents = parents;
        this.birthDate = birthDate;
        this.icon = icon;
    }

    /**
     * @return Title of news entry
     */
    public String getName() {
        return name;
    }

    /**
     * @return Author of news entry
     */
    public String getParents() {
        return parents;
    }

    /**
     * @return Post date of news entry
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return Icon of this news entry
     */
    public int getIcon() {
        return icon;
    }
}
