package hash.p2;

public class Wrong {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
		
	}
    public static boolean solution(String[] phone_book) {
    	//phone_book의 마지막 전 원소까지 반복
    	for(int i=0; i<phone_book.length -1; i++) {
    		//String.hashCode(): 문자열의 해쉬코드 반환
    		//i번째 전화번호에 해쉬코드 부여
    		int hashPhone = phone_book[i].hashCode();
    		int len = phone_book[i].length();
    		
    		//j는 i+1부터 phone_book의 마지막 원소까지 탐색, i가 증가할 때마다 초기화
    		for(int j=i+1; j< phone_book.length; j++) {
    			//i번째 전화번호보다 j번째 전화번호의 길이가 길고,
    			//i번째 전화번호의 길이만큼 j번째 전화번호의 substring의 해쉬값이 같음.(j가 i 문자열로 시작)
    			if(phone_book[j].length() >=len && 
    					hashPhone == (phone_book[j].substring(0, len).hashCode())){
    				return false;
    			}
    			//j번째 전화번호보다 i번째 전화번호의 길이가 길고,
    			//j번째 전화번호의 길이만큼 i번째 전화번호의 substring의 해쉬값이 같음.(i가 j 문자열로 시작)
    			else if(phone_book[j].length()<len && 
    					phone_book[i].substring(0, phone_book[j].length())
    					.hashCode() == phone_book[j].hashCode()) {
    				return false;
    			}
			}
    	}
    	//위 상황에 해당하는 case가 없으면 true 반환
        return true;
    }
}