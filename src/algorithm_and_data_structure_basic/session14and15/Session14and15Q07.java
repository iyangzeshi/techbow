package algorithm_and_data_structure_basic.session14and15;

/*Given unsorted array, find largest and second largest number with least comparision*/
public class Session14and15Q07 {
	
	// preconditions: no duplicates
	public static int[] firstTwoLargest(int[] nums) {
		// corner case
		if (nums == null || nums.length < 2) {
			return null;
		}
		
		//general case
		int length = nums.length;
		// n-1 comparisons;
		int[] winnerRoad = MaxTournament(0, length - 1, nums); 
		int max = winnerRoad[0];
		int max2nd = winnerRoad[1];
		
		// log2(n)-1 comparisons.
		for (int i = 1; i < winnerRoad.length; i++) {
			max2nd = Math.max(winnerRoad[i], max2nd);
		}
		int[] result = {max, max2nd};
		return result;
		// Total comparisons: n+log2(n)-2;
	}
	
	
	/**
	 * this function is used to find the largest elements in the array[left, right] 
	 * and the elements it defeated by time order 
	 * (last defeated is located in the last place of array)
	 * postorder idea
	 * @param left:		leftest limitation
	 * @param right:	rightest limitation
	 * @param nums:		target array
	 * @return			the larger elements followed 
	 * by the elements it defeated in total log2(n) elements
	 */
	private static int[] MaxTournament(int left, int right, int[] nums) {
		// base case
		if (left == right) {
			int[] tour = new int[1];
			tour[0] = nums[left];
			return tour;
		}
		int[] tour1 = MaxTournament(left, left + (right - left) / 2, nums);
		int[] tour2 = MaxTournament(left + (right - left) / 2 + 1, right, nums);
		int[] larger;
		int[] smaller;
		if (tour1[0] > tour2[0]) {
			larger = tour1;
			smaller = tour2;
		}
		else {
			larger = tour2;
			smaller = tour1;
		}
		int length = larger.length + 1;
		int[] newTour = new int[length];
		System.arraycopy(larger, 1, newTour, 1, larger.length - 1);
		newTour[0] = larger[0];
		newTour[length - 1] = smaller[0];
		return newTour;
	}
}
