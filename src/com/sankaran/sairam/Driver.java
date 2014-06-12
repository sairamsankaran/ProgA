package com.sankaran.sairam;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by sairamsankaran on 6/11/14.
 * Driver class driver the entire operation of reading the command stream
 * and managing the software installation
 */
public class Driver {
    public static void main(String[] args) {
        final String COMMAND_END        = "END";
        final String COMMAND_DEPEND     = "DEPEND";
        final String COMMAND_INSTALL    = "INSTALL";
        final String COMMAND_REMOVE     = "REMOVE";
        final String COMMAND_LIST       = "LIST";

        OperatingSystem os = new OperatingSystem();
        DependencyList dependencyList = os.getDependencyList();

        String inputFile = "input.txt";
        URL url = Driver.class.getResource(inputFile);
        BufferedReader br = null;
        String line="";
        String delimiter = " ";
        try {
            br = new BufferedReader(new FileReader(url.getPath()));
            while (((line = br.readLine()) != null) && (!line.toUpperCase().equals(COMMAND_END))){
                String [] commands = line.split(delimiter);
                String command = commands[0]; // first split is always a command
                String name = "";
                if (commands.length > 1) {
                    name = commands[1]; // second split is always a software name except LIST and END
                }
                System.out.println(line);
                if (command.toUpperCase().equals(COMMAND_LIST)) {
                    Set<Software> installedSoftwares = os.getInstalledSoftwares();
                    Iterator<Software> iterator = installedSoftwares.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next().getName().toUpperCase());
                    }
                } if (command.toUpperCase().equals(COMMAND_INSTALL)) {

                } if (command.toUpperCase().equals(COMMAND_REMOVE)) {

                } if (command.toUpperCase().equals(COMMAND_DEPEND)) {
                    Software software = new Software(name);
                    for (int i = 2; i < commands.length; i++) {
                        dependencyList.addDependency(software, new Software(commands[i]));
                    }
                } else {
                    System.out.println("Invalid command!");
                }
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
