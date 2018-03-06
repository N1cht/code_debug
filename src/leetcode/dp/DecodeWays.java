package leetcode.dp;

public class DecodeWays {
	
	public static void main(String[] args){
		System.out.println(numDecodings("110"));
	}

	public static int numDecodings(String s) {
		int size = s.length();
        if(size == 0) return 0;
        //how many ways this character can be combined
        int[] dpCanGroup = new int[size];
        //how many ways this character can not be combined
        int[] dpCanNotGroup = new int[size];
        dpCanGroup[size-1] = 1;
        dpCanNotGroup[size-1] = 0;
        
        boolean zeroNeedTobeSolved = (s.charAt(size-1) - '0') == 0 ? true : false;
            
        for(int i = size - 2; i >= 0; i--){
        	//if this char is zero: previous character needs to be combined with zero
            if((s.charAt(i) - '0') == 0){ 
                if(zeroNeedTobeSolved) return 0;
                dpCanGroup[i] = dpCanGroup[i+1] + dpCanNotGroup[i+1];
                dpCanNotGroup[i] = 0;
                zeroNeedTobeSolved = true;
            }else{
            	//if this char can combine with next char within 27
                if(((s.charAt(i) - '0')*10+(s.charAt(i+1)-'0') < 27)){
                    if(zeroNeedTobeSolved){
                        dpCanNotGroup[i] = dpCanGroup[i+1];
                        dpCanGroup[i] = 0;
                        zeroNeedTobeSolved = false;
                    }else{
                        dpCanNotGroup[i] = dpCanGroup[i+1];
                        dpCanGroup[i] = dpCanGroup[i+1] + dpCanNotGroup[i+1];
                    }
                }else{
                	if(zeroNeedTobeSolved){
                        return 0;
                    }else{
	                    dpCanNotGroup[i] = 0;
	                    dpCanGroup[i] = dpCanGroup[i+1] + dpCanNotGroup[i+1];
                    }
                }
            } 
        }
        
        if(zeroNeedTobeSolved) return 0;
        return dpCanNotGroup[0] + dpCanGroup[0];
    }
}
