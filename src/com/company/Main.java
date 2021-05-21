package com.company;

import com.company.player.RandomPlayer;
import com.company.player.UnimplementedPlayer;

public class Main {

    public static void main(String[] args) {
        ISimulator ISimulator = new Simulator.Builder()
                .setName("new simulation")
                .setTtl(3000)
                .setDebug(true)
                .setMaxMoves(100)
                .setLogging(true)
                .build();

        System.out.println(ISimulator.run(RandomPlayer.class, UnimplementedPlayer.class));
    }
}
