package com.sankaran.sairam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sairamsankaran on 6/11/14.
 * Software class represents a software than can be installed
 * on a system.
 */
public class Software {
    private String name = null;

    public Software () {

    }

    public Software(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Software) && ((Software) o).getName().equalsIgnoreCase(name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
