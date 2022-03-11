package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// List of cards

	private List<Card> cards;
	
	{	// Instance initializer - oh my
		this.cards = new ArrayList<>(52);
	}

	public Deck() {
		
//		this.cards = new ArrayList<>(52);
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		
//		System.out.println("New Deck created! " + cards.size() );
//		System.out.println(cards);
	}
	
	
	
	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}



	public int checkDeckSize() {
		return cards.size();
		
	}
	
	public Card dealCard() {
		return cards.remove(0);
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		
	}
	
}
