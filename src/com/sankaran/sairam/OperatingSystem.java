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

    public void addDependency(Software software, Software dependency) {
        dependencyList.addDependency(software, dependency);
    }

    public Map<Software, String> getInstalledSoftwares() {
        return installedSoftwares;
    }

    public void install(String name) {
        Software software = new Software(name);
        if (Boolean.valueOf(installedSoftwares.get(software))) {
            // already installed
            System.out.println(name + " is already installed.");
        } else {
            // check if dependencies are installed
            List<Software> requiredList = dependencyList.getDependencyList().get(software);
            if (requiredList != null) {
                for (Software required : requiredList) {
                    if (Boolean.valueOf(installedSoftwares.get(required))) {
                        continue;
                    } else {
                        install(required.getName());
                    }
                }
            }
            System.out.println("Installing " + software.getName());
            installedSoftwares.put(software, "1");
        }
    }

    public void printInstalledSoftwares() {
        Iterator<Software> iterator = installedSoftwares.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName().toUpperCase());
        }
    }

    public void remove(String name) {
        Software software = new Software(name);
        Iterator<Software> iterator = dependencyList.getDependencyList().keySet().iterator();
        while (iterator.hasNext()) {
            List<Software> requiredList = dependencyList.getDependencyList().get(iterator.next());
            if (requiredList.indexOf(software) >= 0) {
                System.out.println(name + " is still needed.");
                return;
            }
        }
        installedSoftwares.remove(software);
        return;
    }
}
