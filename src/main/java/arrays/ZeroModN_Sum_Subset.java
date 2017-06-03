
package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroModN_Sum_Subset {

	public static int[] zeroModNSubset(int[] A){
		int[] prefixSum = new int[A.length];
		int[] subset = null;
		Map<Integer,Integer> sumToIndex = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			prefixSum[i] += i>0?prefixSum[i-1]:0;
			prefixSum[i] += A[i];
			prefixSum[i] %= A.length;
			System.out.println(Arrays.toString(prefixSum));
		}
		
		for(int i=0;i<A.length;i++){
		if(prefixSum[i] == 0){
				subset =  Arrays.copyOfRange(A,0,i+1);
				break;
			}else{
				if(!sumToIndex.isEmpty() && sumToIndex.containsKey(prefixSum[i])){
					int p = sumToIndex.get(prefixSum[i]);
					subset = Arrays.copyOfRange(A,p,i+1);
					break;
				}else{
				sumToIndex.put(prefixSum[i],i);
			    }
		    }
		}
		return subset;
	}
	
	public static void main(String[] args){
		int[] A = {1,9,18,7,25,38,46,58,72,52,10};
		int [] subset = zeroModNSubset(A);
		System.out.println(Arrays.toString(subset));
	}
}
