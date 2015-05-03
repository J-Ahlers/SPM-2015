package main;

import metrics.ProjectMetrics;

public class Aufgabe3A {
	
	public static void main(String[] args) {
		if(args.length == 1) {
			ProjectMetrics metrics = new ProjectMetrics(args[0], ".java");
			metrics.printMetrics();
		}
		else {
			System.out.println("Error: please specify a project path.");
		}	
    }
}
