package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();

		app.run(sc);
		sc.close();
	}

	public void run(Scanner sc) {

		Deck deck = new Deck();
		deck.shuffle();

		// SETUP: Deal player 2 cards, then dealer 2 cards (2)
		Hand player = new Hand("Player");
		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		System.out.print(player.toString());
		System.out.println("\t==>  Hand Value: " + player.getHandValue() + "\n");

		Hand dealer = new Hand("Dealer");
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		System.out.println(dealer.getShowCard());


		// PLAYER TURN: Player is shown dealer show card, and decides to hit or stay
		boolean pBj = player.checkBlackjack();
		boolean pBust = player.checkBust();
		boolean dBj = dealer.checkBlackjack();
		boolean dBust = dealer.checkBust();
		int choice = 0;

		while ((pBj == false) && (pBust == false) && (choice != 2)) {

			dealer.getShowCard();

			System.out.println("\n**** CHOOSE ****\n1. Hit me!\n2. Stay");

			try {
				choice = sc.nextInt();

			} catch (Exception e) {

				System.out.println("Not a valid input. Try again");
				sc.nextLine(); // clear buffer
			}

			if (choice == 1) {
				player.addCard(deck.dealCard());
				System.out.print(player.toString());
				System.out.println("\t==>  Hand Value: " + player.getHandValue());
				pBj = player.checkBlackjack();
				pBust = player.checkBust();

			} else if (choice == 2) {
				System.out.println("STAYING with: " + player.toString() + " ==> Hand Value: " + player.getHandValue());
			} else {
				System.out.println("Not a valid input. Try again.");
			}
		}

		// DEALER TURN: Dealer shows his hole card and hits if value is less than 17 (stays if not). 
		System.out.println("Dealer has: " + dealer.getHand() + "(" + dealer.getHandValue() + ")");

		while (dealer.getHandValue() < 17 && (dBust == false) && (pBust == false)) {
			System.out.println("Dealer must HIT if hand value is less than 17. Hitting..");
			Card d = deck.dealCard();
			dealer.addCard(d);
			System.out.println("Dealt card: " + d);

			dBj = dealer.checkBlackjack();
			dBust = dealer.checkBust();

		}
		
		// Final check for busts
		System.out.println("**********************");
		if (pBust == true) {
			System.out.println("Dealer wins! " + " Player busted out with " + "(" + player.getHandValue() + ")");
		} else if (dBust == true) {
			System.out.println("Player wins! " + " Dealer busted out with " + "(" + dealer.getHandValue() + ")");
		}

		// If no busts, final win/lose decision analysis

		if (pBust == false && dBust == false) {

			if ((dealer.getHandValue() > player.getHandValue())) {
				System.out.println("Dealer wins! " + "(" + +dealer.getHandValue() + ") beats " + "("
						+ player.getHandValue() + ")");

			} else if (dealer.getHandValue() == player.getHandValue()) {
				System.out.println("PUSH. Nobody wins.");
			} else {
				System.out.println("Player wins! " + "(" + +player.getHandValue() + ") beats " + "("
						+ dealer.getHandValue() + ")");
			}
		}

	}
}
