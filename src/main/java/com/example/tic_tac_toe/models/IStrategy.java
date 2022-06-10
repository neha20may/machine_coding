package com.example.tic_tac_toe.models;

public abstract class IStrategy {
    public abstract Cell move(Cell position, Grid board);
}
