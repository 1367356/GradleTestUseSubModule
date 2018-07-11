package com.li.chapter24;


public class TestDijkstraAlgorithm {
	public static void main(String[] args) {
		DijkstraAlgorithm da=new DijkstraAlgorithm();
		da.createGraph();
		da.printWeightGraph();
		da.shortestPathOfBFS(2);
		da.printShortestPathOfBFS(2);
	
	}
}
