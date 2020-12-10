/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cindyokino.player.deck;

/**
 *
 * @author Cindy
 */
public class Card {
    
    private String title;
    private String description;
    
    public Card() {
        
    }
    
    public Card(String titleIn, String descriptionIn) {
        this.title = titleIn;
        this.description = descriptionIn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
