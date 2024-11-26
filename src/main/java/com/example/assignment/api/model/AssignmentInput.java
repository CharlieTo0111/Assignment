package com.example.assignment.api.model;
import java.util.List;


public class AssignmentInput {
    private int[] roomSize= new int[2];
    private int[] coords= new int[2];
    private List<List<Integer>> patches;
    private String instructions;


    public int[] getRoomSize() {
        return roomSize;
    }
    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public int[] getCoords() {
        return coords;
    }
    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public List<List<Integer>> getPatches() {
        return patches;
    }
    public void setPatches(List<List<Integer>> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}

