class Solution {
    public String convert(String s, int numRows) {
         
        String result ="" ;

        int numberOfCharSkip = numRows + (numRows - 2);
        
        if(numRows ==1){
            return s;
        }

        int i=0;
        for(int j=0; j<numRows ; j++, i=j){
    
            for( i=j ; i < s.length() ; i = i + numberOfCharSkip ) { 
                result += s.charAt(i);
                if(i+ (numberOfCharSkip -j *2) < s.length() && i>0 && j > 0 && j <numRows -1){ 
                    result +=s.charAt(i + (numberOfCharSkip -j *2));
                }
            }
        }

           // System.out.println("String is : ");
            System.out.println(result);
        return result;
    }
}
