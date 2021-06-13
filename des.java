package crypto;

public class des {
	
	  static String hextoBin(String hex) 
	  {
		  String bin = "";
		    String binFragment = "";
		    int iHex;
		    for(int i = 0; i < hex.length(); i++){
		        iHex = Integer.parseInt(""+hex.charAt(i),16);
		        binFragment = Integer.toBinaryString(iHex);

		        while(binFragment.length() < 4){
		            binFragment = "0" + binFragment;
		        }
		        bin += binFragment;
		    }
		    return bin;
		}

 static String binToHex(String binary) {
	 int digitNumber = 1;
	    int sum = 0;
	    String out=""; 
	    
	    for(int i = 0; i < binary.length(); i++){
	        if(digitNumber == 1)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*8;
	        else if(digitNumber == 2)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*4;
	        else if(digitNumber == 3)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*2;
	        else if(digitNumber == 4 || i < binary.length()+1){
	            sum+=Integer.parseInt(binary.charAt(i) + "")*1;
	            digitNumber = 0;
	            String sum1=String.valueOf(sum);
	            if(sum < 10)
	                out+=sum1;
	            else if(sum == 10)
	                out+="A";
	            else if(sum == 11)
	            	out+="B";
	            else if(sum == 12)
	            	out+="C";
	            else if(sum == 13)
	            	out+="D";
	            else if(sum == 14)
	            	out+="E";
	            else if(sum == 15)
	            	out+="F";
	            sum=0;
	        }
	        digitNumber++;  
	    }return out;
	    }
	

	 static String permutation(int[] sequence, String input) 
     { 
         String output = ""; 
         input = hextoBin(input); 
         for (int i = 0; i < sequence.length; i++) 
             output += input.charAt(sequence[i] - 1); 
         output=binToHex(output);
         return output; 
     } 
	 static String shift(String key) {
		String  output="";
		 String in=hextoBin(key);
		 String in1=in.substring(0,28);
		 String in1s=in1.substring(1,28)+in1.substring(0,1);
		 String in2=in.substring(28,56);
		 String in2s=in2.substring(1,28)+in2.substring(0,1);
		 output=in1s+in2s;
		 String o=binToHex(output);
		 return o;
	 }
	 public static void main(String []ars) {
		 int[] PC1 = { 57, 49, 41, 33, 25, 
	             17, 9, 1, 58, 50, 42, 34, 26, 
	             18, 10, 2, 59, 51, 43, 35, 27, 
	             19, 11, 3, 60, 52, 44, 36, 63, 
	             55, 47, 39, 31, 23, 15, 7, 62, 
	             54, 46, 38, 30, 22, 14, 6, 61, 
	             53, 45, 37, 29, 21, 13, 5, 28, 
	             20, 12, 4 }; 
		 int[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 
	             28, 15, 6, 21, 10, 23, 19, 12, 
	             4, 26, 8, 16, 7, 27, 20, 13, 2, 
	             41, 52, 31, 37, 47, 55, 30, 40, 
	             51, 45, 33, 48, 44, 49, 39, 56, 
	             34, 53, 46, 42, 50, 36, 29, 32 }; 
		 String key = "AABB09182736CCDD"; 
		 String parity=permutation(PC1,key);
		 System.out.println("after parity "+parity);
		 String shift=shift(parity);
		 
		 System.out.println("after shift "+shift);
		 String ou1=permutation(PC2,shift);
		 System.out.println("key is "+ou1);
	 }
}
