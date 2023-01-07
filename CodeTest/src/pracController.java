import java.util.HashMap;
import java.util.Map;

public class pracController {
	
	public static void main(String[] args) {
		
		//다음에 올 숫자 Lv0
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
		
		/*
		int[] param = {2, 4, 8};

		Solution sol = new Solution();
		System.out.println(sol.nextVal(sol.checkArr(param), param));
		*/
		
		
		/************************************************************************************************
		 ************************************************************************************************
		 											다 음 문 제
		 ************************************************************************************************
		 *************************************************************************************************/
		
		
		/*
		다음에 올 숫자 싱행
		int[] param = {2, 4, 8};
		
		Solution sol = new Solution();
		System.out.println(sol.nextVal(sol.checkArr(param), param));
		*/
		
		//햄버거 만들기 Lv1
		class Solution1 {
			
			/*
			문제 : 햄버거 만들기 
			 
			햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 
			상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 
			상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
			재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
			예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고,
			아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
			상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
			
			조건
			1. 1 <= ingredient 길이 <= 1000000
			2. ingredient의 원소는 1,2,3중 하나의 값이며 순서대로 빵, 야채, 고기를 의미한다.
			*/
			
			/*
			 처음 생각없는 반복문 사용으로 실행시간 초과. 코드 길이 줄이기만 생각하지 말고 수행시간도 생각하며 코딩
			 다른 사람의 풀이법을 보다가 Stack 을 사용한 풀이법 발견, 좀 더 좋은 풀이법인듯
			 */
			
			public int makeBurger(int[] ingredient) {
				int result = 0;
				StringBuilder sbIngredient = new StringBuilder();
				
				for(int i = 0; i < ingredient.length; i++) {
					sbIngredient.append(ingredient[i]);
					
					if(ingredient[i] == 1 && sbIngredient.length() > 3) {
						if(checkBurger(sbIngredient)) {
							result++;
						}
					}
				}
				return result;
			}
			
			public boolean checkBurger(StringBuilder sbIngredient) {
				if(sbIngredient.length() > 3 && sbIngredient.subSequence(sbIngredient.length() - 4, sbIngredient.length()).equals("1231")) {
					sbIngredient.delete(sbIngredient.length() - 4, sbIngredient.length());
					return true;
				}
				return false;
			}
		}
		
		/*
		int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		Solution1 sol1 = new Solution1();
		System.out.println("햄버거 갯수 : " + sol1.makeBurger(arr));
		*/
		
		
		/************************************************************************************************
		 ************************************************************************************************
		 											다 음 문 제
		 ************************************************************************************************
		 *************************************************************************************************/
		
		// 성격 유형 검사
		class Solution2 {
			
			public StringBuilder checkCharater(String[] survey, int[] choice) {
				Map<Character, Integer> result = new HashMap<>();		// 각 유형별 점수
				
				for(int i = 0; i < survey.length; i++) {
					int score = choice[i];								// 각 문항별 선택값
					
					if(score > 4) {
						result.put(survey[i].charAt(1), score - 4);
					}else{
						result.put(survey[i].charAt(0), Math.abs(score - 4));
					}
				}
				return new StringBuilder().append(result.getOrDefault('R', 0) >= result.getOrDefault('T', 0) ? 'R' : 'T')
						.append(result.getOrDefault('C', 0) >= result.getOrDefault('F', 0) ? 'C' : 'F')
						.append(result.getOrDefault('J', 0) >= result.getOrDefault('M', 0) ? 'J' : 'M')
						.append(result.getOrDefault('A', 0) >= result.getOrDefault('N', 0) ? 'A' : 'N');
			}
		}
		
		Solution2 sol2 = new Solution2();
		String[] q = {"AN", "CF", "MJ", "RT", "NA"};
		int[] a = {5, 3, 2, 7, 5};
		
		System.out.println(sol2.checkCharater(q, a));
		
	}
	
	

}
