package com.sankaran.sairam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sairamsankaran on 6/11/14.
 * DependencyList class maintains a map of software and
 * their dependencies
 */
public class DependencyList {
    private Map<Software, List<Software>> dependencyList = new HashMap<Software, List<Software>>();

    public DependencyList() {

    }

    public void addDependency(Software software, Software dependency) {
        if(dependencyList.get(software) == null) {
            dependencyList.put(software, new ArrayList<Software>());
        }
        dependencyList.get(software).add(dependency);
    }
}
