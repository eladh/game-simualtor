package com.company;

import com.company.game.Game;
import com.company.game.GameStatus;
import com.company.player.IPlayerMove;
import com.company.player.Player;
import com.company.util.PlayerLoader;


public class Simulator implements ISimulator {

    private final String name;
    private final int ttl;
    private final int maxMoves;
    private final boolean logging;
    private final boolean debug;

    public Simulator(Builder builder) {
        this.name = builder.name;
        this.ttl = builder.ttl;
        this.maxMoves = builder.maxMoves;
        this.logging = builder.logging;
        this.debug = builder.debug;
    }

    @Override
    //todo - run games in parallel , spin new thread and set simulator execution id
    public GameStatus run(Class<? extends IPlayerMove> player1Class, Class<? extends IPlayerMove> player2Class) {
        Player player1 = PlayerLoader.getPlayer(player1Class.getName(), true, player1Class);
        Player player2 = PlayerLoader.getPlayer(player2Class.getName(), false, player2Class);

        Game game = new Game(player1, player2);

        while (!game.isEnd()) {
            Player player = game.getCurrentPlayer();
            game.makeMove(player.getMove(game.getMoveTracker(), game.getBoardBoxes(), player.isWhiteSide()), player);
        }

        return game.getStatus();
    }

    @Override
    public GameStatus stop() {
        //todo - in a case of a long running game support stop simulation in the middle
        return null;
    }

    public static class Builder {
        private String name;
        private int ttl;
        private int maxMoves;
        private boolean logging;
        private boolean debug;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setTtl(int ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder setMaxMoves(int maxMoves) {
            this.maxMoves = maxMoves;
            return this;
        }

        public Builder setLogging(boolean logging) {
            this.logging = logging;
            return this;
        }

        public Builder setDebug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Simulator build() {
            return new Simulator(this);
        }
    }


}
