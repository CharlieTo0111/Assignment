package com.example.assignment.service;

import com.example.assignment.api.model.AssignmentOutput;
import org.springframework.stereotype.Service;

import com.example.assignment.service.exception.InvalidInputException;
import com.example.assignment.api.model.AssignmentInput;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    public static AssignmentOutput processCoords(AssignmentInput request) {
    String instructions = request.getInstructions();
    int[] coords = request.getCoords();
    int[] roomSize = request.getRoomSize();
    List<List<Integer>> patches = request.getPatches();
    int numpatches = 0;
    Set<List<Integer>> set = new LinkedHashSet<>(patches);
    List<List<Integer>> singlepatch = new ArrayList<>(set); //remove the duplicated, so if it is cleaned, it wont be cleaned again.

        if (roomSize[0] < 0 || roomSize[1] < 0) {
            throw new InvalidInputException("Room size cannot be negative");
        }
        if (coords[0] < 0 || coords[1] < 0) {
            throw new InvalidInputException("Coordinates cannot be negative");
        }


    char[] Direction = new char[instructions.length()];
    for (int a = 0; a < instructions.length(); a++) {
        Direction[a] = instructions.charAt(a);          //Separate the characters in the instruction
    }


        for (char character : Direction) {
            switch (character) {
                case 'W':
                    if (0 < coords[0]) {
                        coords[0]--;
                    }
                    break;
                case 'N':
                    if (roomSize[1] > coords[1]) {
                        coords[1]++;
                    }
                    break;
                case 'S':
                    if (0 < coords[1]) {
                        coords[1]--;
                    }
                    break;
                case 'E':
                    if (roomSize[0] > coords[0]) {
                        coords[0]++;
                    }
                    break;
            }
            for (int i=0;i<singlepatch.size();i++){
                if(coords[0] == singlepatch.get(i).get(0) && coords[1] == singlepatch.get(i).get(1)){
                    numpatches++;
                    singlepatch.set(i, List.of(-1, -1));
                }}

        }
        return new AssignmentOutput(coords, numpatches);
    }
}
