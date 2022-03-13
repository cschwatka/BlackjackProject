package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand {

	private List<Card> hand = new ArrayList<>();
	private int handValue;
	private String player;

	// CONSTRUCTORS

	public Hand(String player) {
		super();
		this.player = player;
	}

	public Hand(List<Card> hand, String player) {
		super();
		this.hand = hand;
		this.player = player;
	}

	// GETTERS & SETTERS

	// TODO game logic

	public void addCard(Card card) {
		// TODO needs to come from Deck
		hand.add(card);
		

	}

	public boolean checkBlackjack() {
		boolean isBlackjack = false;
		int checkValue = getHandValue();
		if (checkValue == 21) {
			isBlackjack = true;
			System.out.print(player + "has Blackjack! You ");
			if (player.equals("Player")) {
			System.out.println("win!");
			} else {
				System.out.println("lose!");
			}
		} 
		return isBlackjack;
	}
	
	public boolean checkBust() {
		boolean isBust = false;
		int checkValue = getHandValue();
		if (checkValue > 21) {
			isBust = true;
			System.out.println("BUST! " + player + " exceeded 21. ");
		} 
		return isBust;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getHandValue() {

		int handValue = 0;
		for (Card dealtCard : this.hand) {
//			System.out.println(dealtCard);
			handValue += dealtCard.getValue();
		}

		return handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getShowCard() {
		return "Dealer is showing: " + hand.get(1) + " face up.";
	}

	@Override
	public String toString() {
		return "Hand: " + hand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		return Objects.equals(hand, other.hand);
	}

}
