package questions.tree;

public class AreTwoArraysSameBST {
	
	public static boolean isSameBST(int[] a, int[] b){
		
		int n = a!=null?a.length:0;
		char [] aLeft= null;
		char [] aRight= null;
		char [] bLeft= null;
		char [] bRight= null;
		boolean flag = false;
		int aLi=0,aRi=0,bLi=0,bRi=0;
		
		if((a==null&&b!=null)||(b==null&&a!=null)){
			flag = false;
			return flag;
		}else  if(a==null&&b==null){
			flag = true;
			return flag;
		}
		
		if(a.length != b.length|| n==0||a[0] != b[0]){
			flag = false;
			return flag;
		}else  if(n==1){
			flag = true;
			return flag;
		}
		
		for(int i=1;i<n;i++){
			if(a[i]<a[0]){
				if (aLeft ==null){
					aLeft = new char[n];
				}
				aLeft[aLi++] = (char) a[i];
			}else{
				if (aRight ==null){
					aRight = new char[n];
				}
				aRight[aRi++] = (char) a[i];
			}
		}
		
		for(int i=1;i<n;i++){
			if(b[i]<b[0]){
				if (bLeft ==null){
					bLeft = new char[n];
				}
				bLeft[bLi++] = (char)b[i];
			}else{
				if (bRight ==null){
					bRight = new int[n];
				}
				bRight[bRi++] = b[i];
			}
		}
		
		flag = isSameBST(aLeft,bLeft)&&isSameBST(aRight,bRight);
		
		return flag;
	}

	public static void main(String[] args) {
		int[] m = {1,2,3};
		int[] n = {1,2,3};
		
		System.out.println(isSameBST(m,n));
	}

}
