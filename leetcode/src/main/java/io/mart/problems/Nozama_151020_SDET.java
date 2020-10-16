package io.mart.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Nozama_151020_SDET {
	
	/*
	 * Complete the 'fiveStarReviews' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. 2D_INTEGER_ARRAY productRatings
	 *  2. INTEGER ratingThreshold
	 */
	
	public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {
		
		double currentRating = calculateRating(productRatings);
		List<List<Integer>> currentProductRatings = productRatings;
		int iterations = 0;
		
		
		while (currentRating < ratingThreshold) {
			PriorityQueue<List<Integer>> queue = new PriorityQueue<>(comparator2());
			
			for (List<Integer> rating : currentProductRatings) {
				queue.add(rating);
			}
			
			List<Integer> fastestProd = queue.remove();
			List<Integer> fastestProdIncreased = Arrays.asList(
					fastestProd.get(0)+1,
					fastestProd.get(1)+1
			);
			currentProductRatings.remove(fastestProd);
			currentProductRatings.add(fastestProdIncreased);
			
			
			currentRating = calculateRating(currentProductRatings);
			iterations++;
		}
		return iterations;
	}
	
	
	private static double calculateRating(List<List<Integer>> productRatings) {
		double rating = 0;
		for (List<Integer> r : productRatings) {
			rating += (double) r.get(0)/r.get(1);
		}
		return rating/productRatings.size();
	}
	
	
	private static Comparator<List<Integer>> comparator() {
		return (a, b) -> (b.get(0)+1)/(b.get(1)+1) - (a.get(0)+1)/(a.get(1)+1);
	}
	
	private static Comparator<List<Integer>> comparator2() {
		return (a, b) -> {
			double deltaForA = ((double)(a.get(0)+1)/(double)(a.get(1)+1)) - ((double)a.get(0)/(double)a.get(1));
			double deltaForB = ((double)(b.get(0)+1)/(double)(b.get(1)+1)) - ((double)b.get(0)/(double)b.get(1));
			return Double.compare(deltaForB, deltaForA);
		};
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> productRatings = new ArrayList<>();
		productRatings.add(Arrays.asList(4,4));
		productRatings.add(Arrays.asList(1,2));
		productRatings.add(Arrays.asList(3,6));
		Nozama_151020_SDET.fiveStarReviews(productRatings, 77);
		
	}
	
}