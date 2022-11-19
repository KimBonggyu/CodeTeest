
public class pracController {
	
	public static void main(String[] args) {
		
		class Solution {
			/*
			 문제 : 다음에 올 숫자
			 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
			 
			 조건
			 1. common 길이는 3 ~ 999
			 2. common 원소는 -999 ~ 1999
			 3. 무조건 등차 or 등비수열
			 4. 공비는 0이 될 수 없음
			 */
			
		    public boolean checkArr(int[] common) {
		        boolean result = true;
		        int gap = common[1] - common[0];
		        
		        for(int i = 2; i < common.length; i++) {
		        	if(common[i] - common[i-1] != gap) {
		        		result = false;
		        		break;
		        	}
		        }
		        return result;
		    }
		    
		    public int nextVal(boolean type, int[] arr) {
		    	int result = 0;
		    	
		    	if(type) {
		    		result = arr[arr.length - 1] + (arr[1] - arr[0]);
		    	}else {
		    		result = arr[arr.length - 1] * (arr[1] / arr[0]);
		    	}
		    	return result;
		    }
		}
		
		int[] param = {2, 4, 8};
		
		Solution sol = new Solution();
		System.out.println(sol.nextVal(sol.checkArr(param), param));
	}

}
