package com.adaptionsoft.games.trivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameTest {

	private Game game;
	private static boolean notAWinner;
    private final ByteArrayOutputStream systemOutput = new ByteArrayOutputStream();
    private String result = "player0 was added\r\n" + 
    		"They are player number 1\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 0\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player0 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 0\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 1 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 0\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 2 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 0\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 3 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 1\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 4 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 1\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 5 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 1\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 6 Gold Coins.\r\n" + 
    		"------------------------------\r\n" + 
    		"player1 was added\r\n" + 
    		"They are player number 2\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 1\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 7 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 2\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player1 now has 1 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 3\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 8 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1's new location is 8\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 2\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player1 now has 2 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 2\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player1 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 2\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 9 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 3\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player1 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 3\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 10 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 4\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 3 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 2\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 3\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 11 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 5\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 12 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 4\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 4 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 5\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 13 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 4\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 14 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 5\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 5 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 4\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 15 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 6\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 6 Gold Coins.\r\n" + 
    		"------------------------------\r\n" + 
    		"player2 was added\r\n" + 
    		"They are player number 3\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 6\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 7 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 6\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player2 now has 1 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 2\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 7\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 8 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 8\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player2 now has 2 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 7\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 16 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 7\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 9 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 8\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player2 now has 3 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 9\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 17 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 10\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player2 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 11\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 10 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 8\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 18 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 9\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 11 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 9\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 4 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 2\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 12\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player0 was sent to the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 5\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 12 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 13\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player2 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player0 was sent to the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 10\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 13 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 11\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 5 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 6\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player1 was sent to the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player2 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 12\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player0 was sent to the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 7\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 6 Gold Coins.\r\n" + 
    		"------------------------------\r\n" + 
    		"player3 was added\r\n" + 
    		"They are player number 4\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 8\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 19 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 10\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player1 was sent to the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player3's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 11\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player3 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 12\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 20 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 2\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 14\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 14 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 13\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 7 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 15\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 1 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 13\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 15 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 8\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 9\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 21 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 8\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 10\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 16 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 14\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 22 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 15\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 17 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 8\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 11\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 8 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 12\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 23 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 13\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 18 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 16\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 9 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 17\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 2 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 18\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 24 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 14\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 19 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player2 was sent to the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 14\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 3 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 16\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 20 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 15\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 10 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 15\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 4 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 19\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 21 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 2\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 17\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 5 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 16\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 25 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 17\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 22 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 20\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 26 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 16\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 23 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 17\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player2 was sent to the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 21\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 6 Gold Coins.\r\n" + 
    		"------------------------------\r\n" + 
    		"player4 was added\r\n" + 
    		"They are player number 5\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 18\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player0 was sent to the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 8\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 18\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 11 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player4's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 22\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player4 now has 1 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 18\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 27 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 19\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 24 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 23\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 12 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 20\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 7 Gold Coins.\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player4's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 19\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player4 now has 2 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 20\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 28 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 24\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 25 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 21\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 13 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player4's new location is 11\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 25\r\n" + 
    		"Answer was corrent!!!!\r\n" + 
    		"player4 now has 3 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 19\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 29 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 22\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 26 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 20\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 14 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 26\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 8 Gold Coins.\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player4's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 23\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player4 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 1\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 21\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 27 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player4 is getting out of the penalty box\r\n" + 
    		"player4's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 22\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player4 now has 4 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 21\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 30 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player4 is not getting out of the penalty box\r\n" + 
    		"Question was incorrectly answered\r\n" + 
    		"player4 was sent to the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 22\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 15 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 6\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 23\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 9 Gold Coins.\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player4 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 23\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 31 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 24\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 28 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 3\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 27\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 16 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 7\r\n" + 
    		"The category is Rock\r\n" + 
    		"Rock Question 28\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 10 Gold Coins.\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player4 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player0 is getting out of the penalty box\r\n" + 
    		"player0's new location is 10\r\n" + 
    		"The category is Sports\r\n" + 
    		"Sports Question 24\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player0 now has 32 Gold Coins.\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 3\r\n" + 
    		"player4 is getting out of the penalty box\r\n" + 
    		"player4's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 25\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player4 now has 5 Gold Coins.\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player1 is getting out of the penalty box\r\n" + 
    		"player1's new location is 9\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 24\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player1 now has 29 Gold Coins.\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player2 is not getting out of the penalty box\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player3 is getting out of the penalty box\r\n" + 
    		"player3's new location is 0\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 26\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player3 now has 11 Gold Coins.\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player4 is not getting out of the penalty box\r\n" + 
    		"player0 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player0 is not getting out of the penalty box\r\n" + 
    		"player1 is the current player\r\n" + 
    		"They have rolled a 2\r\n" + 
    		"player1 is not getting out of the penalty box\r\n" + 
    		"player2 is the current player\r\n" + 
    		"They have rolled a 1\r\n" + 
    		"player2 is getting out of the penalty box\r\n" + 
    		"player2's new location is 4\r\n" + 
    		"The category is Pop\r\n" + 
    		"Pop Question 27\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player2 now has 17 Gold Coins.\r\n" + 
    		"player3 is the current player\r\n" + 
    		"They have rolled a 4\r\n" + 
    		"player3 is not getting out of the penalty box\r\n" + 
    		"player4 is the current player\r\n" + 
    		"They have rolled a 5\r\n" + 
    		"player4 is getting out of the penalty box\r\n" + 
    		"player4's new location is 5\r\n" + 
    		"The category is Science\r\n" + 
    		"Science Question 25\r\n" + 
    		"Answer was correct!!!!\r\n" + 
    		"player4 now has 6 Gold Coins.\r\n" + 
    		"------------------------------\r\n";
	
	@Test
	public void playGame() {
		Random rand = new Random();

		for (int i = 0; i < 5; i++) {
			game.add("player" + i);
			rand.setSeed(i);

			do {

				game.roll(rand.nextInt(5) + 1);

				if (rand.nextInt(9) == 7) {
					notAWinner = game.wrongAnswer();
				} else {
					notAWinner = game.wasCorrectlyAnswered();
				}

			} while (notAWinner);

			System.out.println("------------------------------");
		}
		
		assertEquals(result, systemOutput.toString());
		
	}
	
	@Before
	public void initGame() {
        System.setOut(new PrintStream(systemOutput));

		game = new Game();
	}

    @After
    public void after() {
        System.setOut(System.out);
        System.out.println(systemOutput.toString());
    }
}
