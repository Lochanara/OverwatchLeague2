package com.example.demo.services;

import java.util.Comparator;

public class KDsort implements Comparator<PlayerKD> {
	
	@Override
    public int compare(PlayerKD o1, PlayerKD o2) {
        return (int) (o1.KD - o2.KD);
    }

}
