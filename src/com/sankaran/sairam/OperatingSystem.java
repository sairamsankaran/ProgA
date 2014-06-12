package com.sankaran.sairam;

import java.util.*;

/**
 * Created by sairamsankaran on 6/11/14.
 * OperatingSystem class represents a system on which various software
 * can be installed
 */
public class OperatingSystem {
    private Set<Software> installedSoftwares = new HashSet<Software>();
    private DependencyList dependencyList = new DependencyList();

    public OperatingSystem() {

    }

    public void addDependency(Software software, Software dependency) {
        dependencyList.addDependency(software, dependency);
    }

    public void install(String name) {
        Software software = new Software(name);
        if (installedSoftwares.contains(software)) {
            // already installed
            System.out.println(name + " is already installed.");
            return;
        } else {
            // check if dependencies are installed
            List<Software> requiredList = dependencyList.getDependencyList().get(software);
            if (requiredList != null) {
                for (Software required : requiredList) {
                    if (installedSoftwares.contains(software)) {
                        continue;
                    } else {
                        install(required.getName());
                    }
                }
            }
            System.out.println("Installing " + software.getName() + ".");
            installedSoftwares.add(software);
            return;
        }
    }

    public void printInstalledSoftwares() {
        Iterator<Software> iterator = installedSoftwares.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName().toUpperCase());
        }
    }

    public void remove(String name) {
        Software software = new Software(name);
        List<Software> requiredList;
        if (!installedSoftwares.contains(software)) {
            System.out.println(name + " is not installed.");
            return;
        } else {
            Iterator<Software> iterator = dependencyList.getDependencyList().keySet().iterator();
            while (iterator.hasNext()) {
                Software currentSoftware = iterator.next();
                if (software.equals(currentSoftware)) { // dont check its own dependency list
                    continue;
                } else if(!installedSoftwares.contains(currentSoftware)) { // dont check  dependency list of software not installed
                    continue;
                } else {
                    requiredList = dependencyList.getDependencyList().get(currentSoftware);
                    if (requiredList.indexOf(software) >= 0) {
                        System.out.println(name + " is still needed.");
                        return;
                    }
                }
            }
            System.out.println("Removing " + software.getName() + ".");
            installedSoftwares.remove(software);

            // remove dependant software no more required
            requiredList = dependencyList.getDependencyList().get(software);
            if (requiredList != null) {
                for (Software required : requiredList) {
                    remove(required.getName());
                }
            } else {
                return;
            }
        }
    }
}
