package rough;

public class CharArraySum {
    public char[] sumCharArray(char[] a,char[] b){
    	float num1 = 0;
    	float num2 = 0;
    	char[] x = null;
    	
    	for(int i=0;i<a.length;i++){
    		while(a[i+1] != '.'){
    			num1 = 10*(num1+a[i]);
    		}
    		num1 = 0.1f*(num1+a[i]);
    	}
    	return x;
    }
    
    public static float charArrayToNumber(char[] c){
    	float pre = 0;
    	float post = 0;
    	int i = 0;
    	int decimal = c.length;
    	if(c[i+1] != '.' && i < decimal){ // Till '.' is not encountered
			pre = 10*pre+c[i]; // Keep multiplying 10 to the sum
		}else{
			pre += c[i];
			decimal = i;
			i+=2;
		}
    	System.out.println(pre);
    	int j=-1;
    	while(i<c.length){
    		post = (float)(Math.pow(10,j)*c[i]);
    		i++;
    		j--;
    	}
    	System.out.println(post);
    	
    	return pre+post;
    }
    
	public static void main(String[] args) {
		char[] a = new String("12.453").toCharArray();
		float f = charArrayToNumber(a);
		System.out.println(f);
	}

}
