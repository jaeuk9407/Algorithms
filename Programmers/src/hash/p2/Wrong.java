package hash.p2;

public class Wrong {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
		
	}
    public static boolean solution(String[] phone_book) {
    	//phone_book�� ������ �� ���ұ��� �ݺ�
    	for(int i=0; i<phone_book.length -1; i++) {
    		//String.hashCode(): ���ڿ��� �ؽ��ڵ� ��ȯ
    		//i��° ��ȭ��ȣ�� �ؽ��ڵ� �ο�
    		int hashPhone = phone_book[i].hashCode();
    		int len = phone_book[i].length();
    		
    		//j�� i+1���� phone_book�� ������ ���ұ��� Ž��, i�� ������ ������ �ʱ�ȭ
    		for(int j=i+1; j< phone_book.length; j++) {
    			//i��° ��ȭ��ȣ���� j��° ��ȭ��ȣ�� ���̰� ���,
    			//i��° ��ȭ��ȣ�� ���̸�ŭ j��° ��ȭ��ȣ�� substring�� �ؽ����� ����.(j�� i ���ڿ��� ����)
    			if(phone_book[j].length() >=len && 
    					hashPhone == (phone_book[j].substring(0, len).hashCode())){
    				return false;
    			}
    			//j��° ��ȭ��ȣ���� i��° ��ȭ��ȣ�� ���̰� ���,
    			//j��° ��ȭ��ȣ�� ���̸�ŭ i��° ��ȭ��ȣ�� substring�� �ؽ����� ����.(i�� j ���ڿ��� ����)
    			else if(phone_book[j].length()<len && 
    					phone_book[i].substring(0, phone_book[j].length())
    					.hashCode() == phone_book[j].hashCode()) {
    				return false;
    			}
			}
    	}
    	//�� ��Ȳ�� �ش��ϴ� case�� ������ true ��ȯ
        return true;
    }
}