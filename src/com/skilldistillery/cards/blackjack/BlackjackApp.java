package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();

		app.start(sc);

		sc.close();
	}

	public void start(Scanner sc) {

		Deck deck = new Deck();
		deck.shuffle();

		// Deal player 2 cards, then dealer 2 cards (2)
		Hand player = new Hand("Player");
		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());

		Hand dealer = new Hand("Dealer");
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());

		System.out.println("PHV: " + player.getHandValue());
		System.out.println("DHV: " + dealer.getHandValue());

		// Player is dealt cards, shown dealer show card, and decides to hit or stay

		boolean pBj = player.checkBlackjack();
		boolean pBust = player.checkBust();
		boolean dBj = dealer.checkBlackjack();
		boolean dBust = dealer.checkBust();
		int choice = 0;

		while ((pBj == false) && (pBust == false) && (choice != 2)) {

			dealer.getShowCard();

			System.out.println("1. Hit me!\n2. Stay");

			try {
				choice = sc.nextInt();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Not a valid input. Try again");
				sc.nextLine(); // clear buffer
			}

			if (choice == 1) {
				player.addCard(deck.dealCard());
				System.out.println(player.toString());
				pBj = player.checkBlackjack();
				pBust = player.checkBust();

			} else if (choice == 2) {
				System.out.println("STAYING with: " + player.toString());
			} else {
				System.out.println("Not a valid input. Try again.");
			}
		}
		
		// Dealer logic
		
		System.out.println("Dealer has: " + dealer.getHand() + "(" + dealer.getHandValue() + ")");
		
		
		
		while (dealer.getHandValue() < 17 && dBust ) {
			System.out.println("Dealer must HIT if hand value is less than 17. Hitting..");
			dealer.addCard(deck.dealCard());
			dBj = dealer.checkBlackjack();
			dBust = dealer.checkBust();
			if (dealer.getHandValue() > player.getHandValue()) {
				System.out.println("Dealer wins! " + "(" + + dealer.getHandValue() + ") beats " + "(" + player.getHandValue() + ")");
			}
		}
		

	}
}
