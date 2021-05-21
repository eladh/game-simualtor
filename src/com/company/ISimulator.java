package com.company;

import com.company.game.GameStatus;
import com.company.player.IPlayerMove;

public interface ISimulator {

    GameStatus run(Class<? extends IPlayerMove> player1Class, Class<? extends IPlayerMove> player2Class);

    GameStatus stop();
}
