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
    //private List<Software> dependencies = new ArrayList<Software>();

    public Software () {

    }

    public Software(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Software> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Software> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(Software dependency) {
        this.dependencies.add(dependency);
    }*/

    public boolean equals(Object o) {
        if ((o instanceof Software) && ((Software) o).getName().equalsIgnoreCase(name))
            return true;
        return false;
    }
}
