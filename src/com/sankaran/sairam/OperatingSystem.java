package com.sankaran.sairam;

import java.util.*;

/**
 * Created by sairamsankaran on 6/11/14.
 * OperatingSystem class represents a system on which various software
 * can be installed
 */
public class OperatingSystem {
    private Map<Software, String> installedSoftwares = new HashMap<Software, String>();
    private DependencyList dependencyList = new DependencyList();

    public OperatingSystem() {

    }

    public DependencyList getDependencyList() {
        return dependencyList;
    }

    public Set<Software> getInstalledSoftwares() {
        return installedSoftwares.keySet();
    }

    public boolean install(String name) {
        Software software = new Software(name);
        return true;
    }

    public boolean remove(String name) {
        return true;
    }
}
