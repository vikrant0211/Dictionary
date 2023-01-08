package com.example.dictionary;

import java.util.HashMap;

public class dictionaryUsingHashMap {
    private HashMap<String,String> dictionary;
    public dictionaryUsingHashMap(){
        this.dictionary =new HashMap<>();
        addWordList();
    }
    public boolean addWord(String word,String meaning){
        try{
            dictionary.put(word,meaning);
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }
    public String getMeaning(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        else{
            return "Word is not present in dictionary";
        }
    }
    private void addWordList(){
        addWord("ability","power or capicity");
        addWord("submerge","to dip into a liquid");
        addWord("energy","ability to do work");
        addWord("able","elegibal");
    }
}
