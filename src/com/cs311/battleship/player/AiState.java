package com.cs311.battleship.player;

/**
 * Created by HP1 on 2/25/2017.
 */
public enum AiState {

    RANDOM,         // search for a random target
    LAST_HIT,       // hit the last ship, look for the rest
    LAST_DESTROYED, // destroyed the last ship, look for a new target
    HIT_LAST_MISSED // hit a ship and then missed before destroying

}
